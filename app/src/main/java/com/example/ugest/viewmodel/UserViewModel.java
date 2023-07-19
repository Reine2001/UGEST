package com.example.ugest.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.ugest.model.entity.User;
import com.example.ugest.model.repository.UserRepository;

import org.jetbrains.annotations.Contract;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository;
    private ExecutorService executorService;

    public   UserViewModel(UserRepository userRepository)
    {
        this.userRepository = userRepository;
        this.executorService = Executors.newCachedThreadPool();
    }
    public CompletableFuture<Long> ajouterUser(User user){

               return CompletableFuture.supplyAsync(() -> userRepository.ajouterUser(user), executorService).
                       thenCompose(idNouveauUser -> idNouveauUser);


    }
    public CompletableFuture<Integer> modifierUser (User user){

        return CompletableFuture.supplyAsync(() -> userRepository.modifierUser(user),executorService).
                thenCompose(idModifier -> idModifier);
    }
    public CompletableFuture<Integer> supprimerUser (User user){
        return CompletableFuture.supplyAsync(() -> userRepository.supprimerUser(user), executorService).
                thenCompose(idSupprimer -> idSupprimer);
    }
    public CompletableFuture<Integer> supprimerTout(User user){
        return CompletableFuture.supplyAsync(() -> userRepository.supprimerTout(),executorService).
                thenCompose(idSupprimer -> idSupprimer);
    }

}
