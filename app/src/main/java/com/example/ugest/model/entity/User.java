package com.example.ugest.model.entity;
import androidx.room.ColumnInfo;
import  androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_utilisateur")
public class User{
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
}