package com.example.ugest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ugest.databinding.ActivityBottomNavigationBinding;

public class BottomNavigation extends AppCompatActivity {


    ActivityBottomNavigationBinding binding;
    private AlertDialog alertDialog;
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
        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddUserDialog();
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
    private void showAddUserDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialogview,null);
        builder.setView(dialogView);
        EditText userNomEditText = dialogView.findViewById(R.id.editTextNom);
        EditText userPrenomText = dialogView.findViewById(R.id.editTextPrenom);
        EditText userCoursEditText = dialogView.findViewById(R.id.editTextCours);

        Button addButton = dialogView.findViewById(R.id.buttonAddUser);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = userNomEditText.getText().toString();
                String prenom =userPrenomText.getText().toString();
                String cours = userCoursEditText.getText().toString();
                //code pour ajouter un utilisateur
                replaceFragment(new ShortsFragment());
                alertDialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

}