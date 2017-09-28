package com.upwzr.easynews;

import android.app.Service;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;

import java.io.IOException;

public class AudioService extends Service {
    private MediaPlayer mediaPlayer;

    public class AudioBinder extends Binder {
        public void init(String uri) {
            try {
                mediaPlayer.setDataSource(getApplicationContext(), Uri.parse(uri));
                mediaPlayer.prepareAsync();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void play() {
            if (mediaPlayer != null)
                mediaPlayer.start();
        }

        public void  pause() {
            if (mediaPlayer != null)
                mediaPlayer.pause();
        }

        public void stop() {
            if (mediaPlayer != null)
                mediaPlayer.stop();
        }
    }

    public AudioService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new AudioBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initAudio();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null)
            mediaPlayer.release();
    }

    @SuppressWarnings("deprecation")
    private void initAudio() {
        if (mediaPlayer == null)
            mediaPlayer = new MediaPlayer();
//        防止播放过程中锁屏，需要通过release()释放
        mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            mediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                    .setLegacyStreamType(AudioManager.STREAM_MUSIC)
                    .build());
        else
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);


        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

            }
        });
    }
}
