package com.abed.prawo.data.local;

import android.arch.persistence.room.TypeConverter;

import com.abed.prawo.data.models.CollectionItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Converter {
    private static Gson gson = new Gson();

    @TypeConverter
    public static List<CollectionItem> collectionItemsFromJson(String json) {
        Type type = new TypeToken<List<CollectionItem>>(){}.getType();
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public static String collectionItemsToJson(List<CollectionItem> items) {
        return gson.toJson(items);
    }
}