package com.example.ugest.model;
import android.content.Context;

import com.example.ugest.model.dao.UserDao;
import com.example.ugest.model.entity.User;

import androidx.annotation.Nullable;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import kotlin.jvm.Volatile;

@Database(entities ={User .class},version =1 )
public abstract class BaseDeDonnee extends RoomDatabase {
    @Volatile
    private static  BaseDeDonnee INSTANCE = null;

    public BaseDeDonnee getINSTANCE(Context Context) {
        synchronized (this){
             BaseDeDonnee instance = INSTANCE;
             if (instance == null){
                 instance = Room.databaseBuilder(Context, BaseDeDonnee.class,"BDEmployee").build();
             }
             return instance;
        }
    }
}
