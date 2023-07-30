package com.example.ugest.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ugest.model.entity.User;
import com.example.ugest.model.repository.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<List<User>> allUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        allUsers =  userRepository.getAllUser();
        allUsers.observeForever(users -> {
            if (users != null && !users.isEmpty()) {
                Log.d("UserViewModel", "Number of users: " + users.size());
            } else {
                Log.d("UserViewModel", "No users found");
            }
        });

    }

    public void ajouterUser(User user) {
        userRepository.ajouterUser(user);
    }

    public void modifierUser(User user, String newNom, String newPrenom, String newCours) {
        // Mettre à jour les informations de l'utilisateur avec les nouvelles valeurs
        user.setNom(newNom);
        user.setPrenom(newPrenom);
        user.setCours(newCours);

        // Appeler la fonction de mise à jour dans le repository pour mettre à jour l'utilisateur dans la base de données
        userRepository.modifierUser(user);
    }

    public void supprimerUser(User user) {
        userRepository.supprimerUser(user);
    }

    public LiveData<List<User>> getAllUser() {
        return allUsers;
    }
}
