package com.abed.prawo.data.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.abed.prawo.data.models.Collection;

import java.util.List;

@Dao
public interface CollectionsDao {
    @Insert
    public void insert(Collection collection);

    @Query("SELECT * FROM collection_table ORDER BY id DESC")
    public LiveData<List<Collection>> getAll();

    /*
    @Query("SELECT * FROM collection_table WHERE id = :id LIMIT 1")
    public Collection get(int id);
    */

    @Update
    public void update(Collection collection);

    @Delete
    public void delete(Collection collection);
}
