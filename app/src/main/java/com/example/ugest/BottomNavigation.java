package com.example.ugest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.ugest.databinding.ActivityBottomNavigationBinding;
import com.example.ugest.databinding.ActivityMainBinding;

public class BottomNavigation extends AppCompatActivity {


    ActivityBottomNavigationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            MenuItemId menuItemId = MenuItemId.fromId(item.getItemId());
            switch (menuItemId) {
                case HOME:
                    replaceFragment(new HomeFragment());
                    return true;

                case SHORTS:
                    replaceFragment(new ShortsFragment());
                    return true;

                case SUBSCRIPTIONS:
                    replaceFragment(new SubscriptionsFragment());
                    return true;

                case LIBRARY:
                    replaceFragment(new LibraryFragment());
                    return true;
            }
            return false;
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}