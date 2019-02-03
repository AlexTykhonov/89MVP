package com.tae.a89mvp.DB;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DiscDao {

    @Query("SELECT * FROM disc")
    List<Disc> getAll();

    @Query("SELECT * FROM disc ORDER BY album ASC")
    LiveData<List<Disc>> findAllDiscs();

    @Query("SELECT * FROM disc WHERE id=:id")
    Disc findDisc(long id);

    @Insert
    long insert(Disc disc);

    @Delete
    void delete(Disc disc);

    @Update
    int update(Disc disc);

}