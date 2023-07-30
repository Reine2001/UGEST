package com.example.ugest.model.entity;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import  androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_utilisateur")
public class User implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id_utilisateur")
    public int id;

    @ColumnInfo(name = "nom_utilisateur")
    public String nom;

    @ColumnInfo(name = "prenom_utilisateur")
    public String prenom;

    @ColumnInfo(name = "cours_suivis")
    public String cours;

    public User(int id, String nom, String prenom, String cours) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cours = cours;
    }


    @Ignore
    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCours() {
        return cours;
    }

    public void setCours(String cours) {
        this.cours = cours;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Écrivez les valeurs des attributs de la classe dans le Parcel
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(cours);
        // Ajoutez d'autres attributs si nécessaire
    }

    // Ajoutez un constructeur qui lit les données depuis le Parcel
    protected User(Parcel in) {
        nom = in.readString();
        prenom = in.readString();
        cours = in.readString();
        // Lisez d'autres attributs si nécessaire
    }

    // Ajoutez un CREATOR pour que le système puisse recréer l'objet depuis le Parcel
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}