package com.t3h.storage.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPokemon(Pokemon pokemon);

    @Query("DELETE FROM pokemon where _id =:id")
    void deletePokemon(int id);

    @Query("SELECT * FROM pokemon")
    List<Pokemon> getAllPokemon();

    @Query("SELECT * FROM pokemon where _id = :id")
    Pokemon getPokemonById(int id);

    @Delete
    void deleteOnePokemon(Pokemon pokemon);
}
