package com.example.ugest.model;
import android.content.Context;

import com.example.ugest.model.dao.UserDao;
import com.example.ugest.model.entity.User;

import androidx.annotation.Nullable;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

import kotlin.jvm.Volatile;

@Database(entities ={User.class},version =1 )
public abstract class BaseDeDonnee extends RoomDatabase {
    @Volatile
    public static  BaseDeDonnee instance;
    public static String Base_name = "user_BD";
    private static final Object LOCK = new Object();
    public  UserDao userDao;
    public static BaseDeDonnee getInstance(Context context)
    {
        if (instance == null){
            synchronized (LOCK){
                instance = Room.databaseBuilder(context.getApplicationContext(),
                        BaseDeDonnee.class,Base_name).allowMainThreadQueries()
                        .build();
            }
        }
        return instance;
    }

}
