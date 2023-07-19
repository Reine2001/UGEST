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
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     CompletableFuture<Long>  ajouterUser(User user);

    @Update
    CompletableFuture<Integer> modifierUser(User user);

    @Delete
    CompletableFuture<Integer> supprimerUser(User user);

    @Query("DELETE FROM table_utilisateur")
    CompletableFuture<Integer> supprimerTout();

    @Query("SELECT * FROM table_utilisateur")
    CompletableFuture<LiveData<List<User>>> getUser();
}
