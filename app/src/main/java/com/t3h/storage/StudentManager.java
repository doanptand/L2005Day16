package com.t3h.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.t3h.storage.db.StudentHelper;

import java.util.ArrayList;
import java.util.List;

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
        db.insert(StudentHelper.STUDENT_TB, null, values);
    }

    public List<Student> getAllStudents() {
        List<Student> result = new ArrayList<>();
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + StudentHelper.STUDENT_TB, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int idIndex = cursor.getColumnIndex(StudentHelper.COL_ID);
                int nameIndex = cursor.getColumnIndex(StudentHelper.COL_NAME);
                int ageIndex = cursor.getColumnIndex(StudentHelper.COL_AGE);
                int id = cursor.getInt(idIndex);
                String name = cursor.getString(nameIndex);
                int age = cursor.getInt(ageIndex);
                Student student = new Student(id, name, age);
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> getAllStudent2() {
        List<Student> result = new ArrayList<>();
        db = helper.getReadableDatabase();
        Cursor cursor = db.query(StudentHelper.STUDENT_TB,
                null, null, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int idIndex = cursor.getColumnIndex(StudentHelper.COL_ID);
                int nameIndex = cursor.getColumnIndex(StudentHelper.COL_NAME);
                int ageIndex = cursor.getColumnIndex(StudentHelper.COL_AGE);
                int id = cursor.getInt(idIndex);
                String name = cursor.getString(nameIndex);
                int age = cursor.getInt(ageIndex);
                Student student = new Student(id, name, age);
                result.add(student);
            }
        }
        return result;
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE " + StudentHelper.STUDENT_TB + " SET "
                + StudentHelper.COL_NAME + "='" + student.getName() + "',"
                + StudentHelper.COL_AGE + "=" + student.getAge()
                + " WHERE " + StudentHelper.COL_ID + "=" + student.getId();
        db = helper.getWritableDatabase();
        db.execSQL(sql);
    }

    public void updateStudent2(Student student) {

        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(StudentHelper.COL_NAME, student.getName());
        values.put(StudentHelper.COL_AGE, student.getAge());
        db.update(StudentHelper.STUDENT_TB, values,
                StudentHelper.COL_ID + "=?",
                new String[]{String.valueOf(student.getId())});
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM " + StudentHelper.STUDENT_TB
                + " WHERE " + StudentHelper.COL_ID + "=" + id;
        db = helper.getWritableDatabase();
        db.execSQL(sql);
    }

    public void deleteStudent2(int id) {
        db = helper.getWritableDatabase();
        db.delete(StudentHelper.STUDENT_TB,
                StudentHelper.COL_ID+ "=?",
                new String[]{String.valueOf(id)});
    }

}
