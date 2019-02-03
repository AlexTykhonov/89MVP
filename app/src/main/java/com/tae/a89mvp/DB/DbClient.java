package com.tae.a89mvp.DB;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DbClient {

    private Context mCtx;

    private static DbClient mInstance;

    //our app database object
    private ADb appDatabase;

    //чтобы не иметь возможности создать экземлпяр класса снаружи
    private DbClient(Context mCtx) {
        this.mCtx = mCtx;

        appDatabase = Room.databaseBuilder(mCtx, ADb.class, "DiscStore").build();
    }

    public static synchronized DbClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DbClient(mCtx);
        }
        return mInstance;
    }

    public ADb getAppDatabase() {
        return appDatabase;
    }
}
