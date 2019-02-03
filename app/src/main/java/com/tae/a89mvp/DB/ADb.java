package com.tae.a89mvp.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Disc.class}, version=2)


public abstract class ADb extends RoomDatabase {

    private static ADb INSTANCE;

    public abstract DiscDao discDao();

    public static ADb getDatabase(Context context) {

        // проверяем если он не существует то его создаем.
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ADb.class, "Discs")
                    .allowMainThreadQueries()
                    .build();
        }
        // если существует то выдаем имеющуюся ссылку
        return INSTANCE;
    }
}