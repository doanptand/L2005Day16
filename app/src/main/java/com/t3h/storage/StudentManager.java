package com.t3h.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.t3h.storage.db.StudentHelper;

public class StudentManager {

    private Context context;
    private StudentHelper helper;
    private SQLiteDatabase db;

    public StudentManager(Context context) {
        this.context = context;
        helper = new StudentHelper(context);
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO " + StudentHelper.STUDENT_TB + "("
                + StudentHelper.COL_NAME + ","
                + StudentHelper.COL_AGE + ") values('"
                + student.getName() + "', "
                + student.getAge() + ");";
        db = helper.getWritableDatabase();
        db.execSQL(sql);
    }

    public void addStudent2(Student student) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(StudentHelper.COL_NAME, student.getName());
        values.put(StudentHelper.COL_AGE, student.getAge());
        db.insert(StudentHelper.STUDENT_TB,null, values);
    }
}
