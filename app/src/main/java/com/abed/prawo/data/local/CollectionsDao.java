package com.abed.prawo.data.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.abed.prawo.data.models.Collection;

import java.util.List;

@Dao
public interface CollectionsDao {
    @Insert
    public void insert(Collection collection);

    @Query("SELECT * FROM collection_table")
    public LiveData<List<Collection>> getAll();

    @Query("SELECT * FROM collection_table WHERE id = :id LIMIT 1")
    public Collection get(int id);

    @Delete
    public void delete(Collection collection);
}
