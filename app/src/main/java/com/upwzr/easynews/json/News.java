package com.upwzr.easynews.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wzr on 2017/9/5.
 */

public class News {
    @SerializedName("news_priority_number")
    public String priority;

    @SerializedName("news_prearranged_time")
    public String prearrangedTime;

    @SerializedName("news_id")
    public String newsId;

    public String title;

    @SerializedName("title_with_ruby")
    public String titleWithRuby;

    @SerializedName("news_file_ver")
    public boolean fileVer;

    @SerializedName("news_creation_time")
    public String creationTime;

    @SerializedName("news_preview_time")
    public String previewTime;

    @SerializedName("news_publication_time")
    public String publicationTime;

    @SerializedName("news_publication_status")
    public boolean publicationStatus;

    @SerializedName("has_news_web_image")
    public boolean hasWebImage;

    @SerializedName("has_news_web_movie")
    public boolean hasWebMovie;

    @SerializedName("has_news_easy_image")
    public boolean hasEasyImage;

    @SerializedName("has_news_easy_movie")
    public boolean hasEasyMovie;

    @SerializedName("has_news_easy_voice")
    public boolean hasEasyVoice;

    @SerializedName("news_web_image_uri")
    public String webImageUri;

    @SerializedName("news_web_movie_uri")
    public String webMovieUri;

    @SerializedName("news_easy_image_uri")
    public String easyImageUri;

    @SerializedName("news_easy_movie_uri")
    public String easyMovieUri;

    @SerializedName("news_easy_voice_uri")
    public String easyVoiceUri;

    @SerializedName("news_display_flag")
    public boolean displayFlag;

    @SerializedName("news_web_url")
    public String webUrl;

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPrearrangedTime() {
        return prearrangedTime;
    }

    public void setPrearrangedTime(String prearrangedTime) {
        this.prearrangedTime = prearrangedTime;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleWithRuby() {
        return titleWithRuby;
    }

    public void setTitleWithRuby(String titleWithRuby) {
        this.titleWithRuby = titleWithRuby;
    }

    public boolean isFileVer() {
        return fileVer;
    }

    public void setFileVer(boolean fileVer) {
        this.fileVer = fileVer;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getPreviewTime() {
        return previewTime;
    }

    public void setPreviewTime(String previewTime) {
        this.previewTime = previewTime;
    }

    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }

    public boolean isPublicationStatus() {
        return publicationStatus;
    }

    public void setPublicationStatus(boolean publicationStatus) {
        this.publicationStatus = publicationStatus;
    }

    public boolean isHasWebImage() {
        return hasWebImage;
    }

    public void setHasWebImage(boolean hasWebImage) {
        this.hasWebImage = hasWebImage;
    }

    public boolean isHasWebMovie() {
        return hasWebMovie;
    }

    public void setHasWebMovie(boolean hasWebMovie) {
        this.hasWebMovie = hasWebMovie;
    }

    public boolean isHasEasyImage() {
        return hasEasyImage;
    }

    public void setHasEasyImage(boolean hasEasyImage) {
        this.hasEasyImage = hasEasyImage;
    }

    public boolean isHasEasyMovie() {
        return hasEasyMovie;
    }

    public void setHasEasyMovie(boolean hasEasyMovie) {
        this.hasEasyMovie = hasEasyMovie;
    }

    public boolean isHasEasyVoice() {
        return hasEasyVoice;
    }

    public void setHasEasyVoice(boolean hasEasyVoice) {
        this.hasEasyVoice = hasEasyVoice;
    }

    public String getWebImageUri() {
        return webImageUri;
    }

    public void setWebImageUri(String webImageUri) {
        this.webImageUri = webImageUri;
    }

    public String getWebMovieUri() {
        return webMovieUri;
    }

    public void setWebMovieUri(String webMovieUri) {
        this.webMovieUri = webMovieUri;
    }

    public String getEasyImageUri() {
        return easyImageUri;
    }

    public void setEasyImageUri(String easyImageUri) {
        this.easyImageUri = easyImageUri;
    }

    public String getEasyMovieUri() {
        return easyMovieUri;
    }

    public void setEasyMovieUri(String easyMovieUri) {
        this.easyMovieUri = easyMovieUri;
    }

    public String getEasyVoiceUri() {
        return easyVoiceUri;
    }

    public void setEasyVoiceUri(String easyVoiceUri) {
        this.easyVoiceUri = easyVoiceUri;
    }

    public boolean isDisplayFlag() {
        return displayFlag;
    }

    public void setDisplayFlag(boolean displayFlag) {
        this.displayFlag = displayFlag;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
