package com.t3h.storage.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentHelper extends SQLiteOpenHelper {
    public static final String STUDENT_TB = "student";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "_name";
    public static final String COL_AGE = "_age";

    public static final String CREATE_TB = "CREATE TABLE " + STUDENT_TB +
            "(" + COL_ID + " integer primary key autoincrement," +
            COL_NAME + " text," +
            COL_AGE + " integer);";

//    public static final String INSERT = "INSERT INTO " + STUDENT_TB + "(" + COL_NAME + "," + COL_AGE +") values('" + name + "', " + age +");";

    public StudentHelper(@Nullable Context context) {
        super(context, "student.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
