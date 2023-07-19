package com.example.ugest.model.entity;
import androidx.room.ColumnInfo;
import  androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_utilisateur")
public class User{
    @PrimaryKey
    @ColumnInfo(name = "Id_utilisateur")
    public int id;

    @ColumnInfo(name = "nom_utilisateur")
    public String nom;

    @ColumnInfo(name = "prenom_utilisateur")
    public String prenom;

    @ColumnInfo(name = "cours_suivis")
    public String cours;
}