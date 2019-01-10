package com.abed.prawo.data.models;

import android.support.annotation.NonNull;

public class CollectionItem {
    private String imageUrl;
    @NonNull
    private String word;
    private String translatedWord;
    private String audioUrl;
    private String translatedAudioUrl;

    public CollectionItem(String imageUrl, @NonNull String word, String translatedWord,
                          String audioUrl, String translatedAudioUrl) {
        this.imageUrl = imageUrl;
        this.word = word;
        this.translatedWord = translatedWord;
        this.audioUrl = audioUrl;
        this.translatedAudioUrl = translatedAudioUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @NonNull
    public String getWord() {
        return word;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public String getTranslatedAudioUrl() {
        return translatedAudioUrl;
    }
}