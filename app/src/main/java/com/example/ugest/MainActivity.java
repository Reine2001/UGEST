package com.example.ugest;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String nom_user="ugestadmin";
    private String mdp="ugest@2023";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        EditText userText = findViewById(R.id.username);
        EditText passwordText = findViewById(R.id.password);
        Button button = findViewById(R.id.ButtonConnection);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userText.getText().toString();
                String  password = passwordText.getText().toString();
                Log.d(TAG, "Value: " + user);
                Log.d(TAG, "value: "+password);
                if (isValidCredential(user,password)){
                    Intent intent = new Intent(MainActivity.this,BottomNavigation.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    // Afficher un message d'erreur dans un popup disant "Incorrect, réessayez"
                    Toast.makeText(MainActivity.this, "Incorrect, réessayez", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    public boolean isValidCredential(String userName, String passWord){
                return userName.equals(nom_user) && passWord.equals(mdp);
    }
}