package com.example.ugest.model.repository;
import android.content.Context;

import androidx.lifecycle.LiveData;


import com.example.ugest.model.BaseDeDonnee;
import com.example.ugest.model.dao.UserDao;
import com.example.ugest.model.entity.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UserRepository {
private BaseDeDonnee userBase;
private Executor executor = Executors.newSingleThreadExecutor();

public  UserRepository(Context context){
    userBase = BaseDeDonnee.getInstance(context);
}
public CompletableFuture<Void> ajouterUser(User user){
    return CompletableFuture.runAsync(()->userBase.userDao.ajouterUser(user), executor);
}
public void modifierUser(User user)
{
    executor.execute(new Runnable() {
        @Override
        public void run() {
            userBase.userDao.modifierUser(user);
        }
    });

}
public void supprimerUser(User user){

  executor.execute(new Runnable() {
      @Override
      public void run() {
          userBase.userDao.supprimerUser(user);
      }
  });

}
public LiveData<List<User>> getAllUser(){
    return userBase.userDao.getAllUser();
}
}

