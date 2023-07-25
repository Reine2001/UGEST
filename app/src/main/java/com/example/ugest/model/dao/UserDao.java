package com.example.ugest.model.dao;
import com.example.ugest.model.entity.User;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void ajouterUser(User user);

    @Update
    int modifierUser(User user);

    @Delete
    int supprimerUser(User user);

    @Query("SELECT * FROM table_utilisateur WHERE id=:pid")
    User getUser(int pid);

    @Query("SELECT * FROM table_utilisateur")
    List<User> getAllUser();
}
