package com.example.ugest.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.ugest.model.repository.UserRepository;

public class UserViewModelFactory implements ViewModelProvider.Factory {
    private UserRepository userRepository;
    public UserViewModelFactory(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public  <T extends ViewModel> T create(Class<T> modelClass){
      if (modelClass.isAssignableFrom(UserViewModel.class))
      {
          return (T) new UserViewModel(userRepository);
      }
     throw new  IllegalArgumentException("Class ViewModel inconnue");
    }
}
