package com.morepranit.sqlitedemo.database;

import com.morepranit.sqlitedemo.database.daos.UserDao;
import com.morepranit.sqlitedemo.database.entities.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class ContactDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
