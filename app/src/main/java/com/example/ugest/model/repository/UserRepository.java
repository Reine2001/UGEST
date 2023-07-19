package com.example.ugest.model.repository;
import androidx.lifecycle.LiveData;


import com.example.ugest.model.dao.UserDao;
import com.example.ugest.model.entity.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class UserRepository {
private  UserDao userDao ;
public  UserRepository(UserDao userDao){
    this.userDao = userDao;
}
public CompletableFuture<Long> ajouterUser(User user){
   return userDao.ajouterUser(user);
}
public CompletableFuture<Integer> modifierUser(User user)
{
    return userDao.modifierUser(user);
}
public CompletableFuture<Integer> supprimerUser(User user){
    return userDao.supprimerUser(user);
}
public CompletableFuture<Integer> supprimerTout(){
    return userDao.supprimerTout();
}
CompletableFuture<LiveData<List<User>>> getUser(User user)
{
    return userDao.getUser();
}
CompletableFuture<LiveData<List<User>>> ListeUser = userDao.getUser();
}

