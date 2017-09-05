package com.upwzr.easynews.json;

import com.google.gson.annotations.SerializedName;

/**
 * News json model
 * Created by wzr on 2017/9/5.
 */

public class News {
    @SerializedName("news_priority_number")
    private String priority;

    @SerializedName("news_prearranged_time")
    private String prearrangedTime;

    @SerializedName("news_id")
    private String newsId;

    private String title;

    @SerializedName("title_with_ruby")
    private String titleWithRuby;

    @SerializedName("news_file_ver")
    private boolean fileVer;

    @SerializedName("news_creation_time")
    private String creationTime;

    @SerializedName("news_preview_time")
    private String previewTime;

    @SerializedName("news_publication_time")
    private String publicationTime;

    @SerializedName("news_publication_status")
    private boolean publicationStatus;

    @SerializedName("has_news_web_image")
    private boolean hasWebImage;

    @SerializedName("has_news_web_movie")
    private boolean hasWebMovie;

    @SerializedName("has_news_easy_image")
    private boolean hasEasyImage;

    @SerializedName("has_news_easy_movie")
    private boolean hasEasyMovie;

    @SerializedName("has_news_easy_voice")
    private boolean hasEasyVoice;

    @SerializedName("news_web_image_uri")
    private String webImageUri;

    @SerializedName("news_web_movie_uri")
    private String webMovieUri;

    @SerializedName("news_easy_image_uri")
    private String easyImageUri;

    @SerializedName("news_easy_movie_uri")
    private String easyMovieUri;

    @SerializedName("news_easy_voice_uri")
    private String easyVoiceUri;

    @SerializedName("news_display_flag")
    private boolean displayFlag;

    @SerializedName("news_web_url")
    private String webUrl;

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

    @Override
    public String toString() {
        return "News{" +
                "priority='" + priority + '\'' +
                ", prearrangedTime='" + prearrangedTime + '\'' +
                ", newsId='" + newsId + '\'' +
                ", title='" + title + '\'' +
                ", titleWithRuby='" + titleWithRuby + '\'' +
                ", fileVer=" + fileVer +
                ", creationTime='" + creationTime + '\'' +
                ", previewTime='" + previewTime + '\'' +
                ", publicationTime='" + publicationTime + '\'' +
                ", publicationStatus=" + publicationStatus +
                ", hasWebImage=" + hasWebImage +
                ", hasWebMovie=" + hasWebMovie +
                ", hasEasyImage=" + hasEasyImage +
                ", hasEasyMovie=" + hasEasyMovie +
                ", hasEasyVoice=" + hasEasyVoice +
                ", webImageUri='" + webImageUri + '\'' +
                ", webMovieUri='" + webMovieUri + '\'' +
                ", easyImageUri='" + easyImageUri + '\'' +
                ", easyMovieUri='" + easyMovieUri + '\'' +
                ", easyVoiceUri='" + easyVoiceUri + '\'' +
                ", displayFlag=" + displayFlag +
                ", webUrl='" + webUrl + '\'' +
                '}';
    }
}
