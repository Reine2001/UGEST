package com.example.ugest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ugest.databinding.ActivityMenuBinding;
import com.example.ugest.model.entity.User;
import com.example.ugest.viewmodel.UserViewModel;

public class menu extends AppCompatActivity {

    ActivityMenuBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());

        setContentView(R.layout.activity_menu);
        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddUserDialog();
            }
        });
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
                if (!nom.isEmpty() && !prenom.isEmpty() && !cours.isEmpty()){

                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                            UserViewModel userViewModel = new ViewModelProvider(menu.this).get(UserViewModel.class);
                            User user = new User();
                            user.setNom(nom);
                            user.setPrenom(prenom);
                            user.setCours(cours);
                            userViewModel.ajouterUser(user);
                        }
                    });

                    Toast.makeText(menu.this, "Utilisateur ajouté", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(menu.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                }

                //code pour ajouter un utilisateur
                //closeAddUserDialog();

                ;
            }


        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
}