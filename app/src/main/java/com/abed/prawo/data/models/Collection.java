package com.abed.prawo.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "collection_table")
public class Collection {
    @PrimaryKey
    private int id;
    @NonNull
    private String name;
    @ColumnInfo(name = "image_url")
    private String imageUrl;
    @NonNull
    private List<CollectionItem> items;

    public Collection(@NonNull String name, String imageUrl, @NonNull List<CollectionItem> items) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @NonNull
    public List<CollectionItem> getItems() {
        return items;
    }
}
