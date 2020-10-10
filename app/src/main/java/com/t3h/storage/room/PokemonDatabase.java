package com.t3h.storage.room;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Pokemon.class}, version = 1, exportSchema = false)
public abstract class PokemonDatabase extends RoomDatabase {

    public abstract PokemonDao getPokemonDao();

    public static PokemonDatabase getPokemonDatabase(Application application) {
        return Room.databaseBuilder(application.getApplicationContext(),
                PokemonDatabase.class,
                "pokemon.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()//FIXME remove on production, only for testing
                .build();
    }
}
