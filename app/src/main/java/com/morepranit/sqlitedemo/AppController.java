package com.morepranit.sqlitedemo;

import android.app.Application;

import com.morepranit.sqlitedemo.database.ContactDatabase;

import androidx.room.Room;

public class AppController extends Application {
    private static AppController mInstance;
    private ContactDatabase dbInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        dbInstance = Room.databaseBuilder(this, ContactDatabase.class, "contact").allowMainThreadQueries().build();
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public ContactDatabase getDbInstance() {
        return dbInstance;
    }

}
