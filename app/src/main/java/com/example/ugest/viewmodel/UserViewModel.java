package com.example.ugest.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.ugest.model.entity.User;
import com.example.ugest.model.repository.UserRepository;

import org.jetbrains.annotations.Contract;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }
    public void ajouterUser(User user){
     userRepository.ajouterUser(user);
    }
    public void modifierUser(User user){
        userRepository.modifierUser(user);
    }
    public void supprimerUser(User user){
        userRepository.supprimerUser(user);
    }
    public List<User> getAllUser(){
        return userRepository.getAllUser();
    }
}
