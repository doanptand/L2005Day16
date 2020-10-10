package com.t3h.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.t3h.storage.room.Pokemon;
import com.t3h.storage.room.PokemonDao;
import com.t3h.storage.room.PokemonDatabase;

import java.util.List;

public class StudentActivity extends AppCompatActivity {
    private StudentManager studentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        studentManager = new StudentManager(this);
        studentManager.addStudent(new Student(1, "Doan", 15));
        studentManager.addStudent2(new Student(3, "Hung", 35));
        List<Student> arrStudents = studentManager.getAllStudents();
        Log.d("doanpt", "size=" + arrStudents.size());

        PokemonDatabase pokemonDatabase =
                PokemonDatabase.getPokemonDatabase(getApplication());
        PokemonDao pokemonDao = pokemonDatabase.getPokemonDao();
        pokemonDao.insertPokemon(new Pokemon(1, "Pikachu", "This is avatar"));
        List<Pokemon> pokemonList = pokemonDao.getAllPokemon();
        Log.d("doanpt", "pokemon size:" + pokemonList.size());
    }
}