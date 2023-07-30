package com.example.ugest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ugest.databinding.ActivityBottomNavigationBinding;
import com.example.ugest.model.entity.User;
import com.example.ugest.viewmodel.UserViewModel;

public class BottomNavigation extends AppCompatActivity {

    private static final String MYTAG ="MYTAG" ;
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
                   replaceFragment(new UserListFragment());
                    return true;

                case SUBSCRIPTIONS:
                    replaceFragment(new UserListFragmentSupprimer());
                    return true;

                case LIBRARY:
                    replaceFragment(new UserListFragmentModifier());
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
        try{
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialogview,null);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
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
    if (!nom.isEmpty() && !prenom.isEmpty() && !cours.isEmpty()){

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                UserViewModel userViewModel = new ViewModelProvider(BottomNavigation.this).get(UserViewModel.class);
                User user = new User();
                user.setNom(nom);
                user.setPrenom(prenom);
                user.setCours(cours);
                userViewModel.ajouterUser(user);
                Log.d("MY_APP_TAG", "Enregistrement effectué : Nom = " + user.getNom() + ", Prénom = " + user.getPrenom() + ", Cours = " + user.getCours());

            }
        });

        Toast.makeText(BottomNavigation.this, "Utilisateur ajouté", Toast.LENGTH_SHORT).show();

    }
    else{
        Toast.makeText(BottomNavigation.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
    }

                //code pour ajouter un utilisateur
                closeAddUserDialog();

                ;
            }


        });

        alertDialog.show();}
        catch (Exception e){
            e.printStackTrace();
        }


    }
    // Utilisez cette méthode pour fermer le dialogue
    private void closeAddUserDialog() {
        if (alertDialog!= null && alertDialog.isShowing()) {
            alertDialog.cancel();
        }
    }



}