package com.eaut.todos.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.eaut.todos.model.ToDo;

import java.util.ArrayList;
import java.util.List;

public class ToDoDBHelper extends SQLiteOpenHelper {
    public ToDoDBHelper(Context context) {
        super(context, "todo", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE todo(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public void addToDo(String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);

        db.insert("todo", null, values);
    }
    public List<ToDo> getTodos() {
        List<ToDo> listTodos = new ArrayList<ToDo>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, name FROM todo", null);
        while (cursor.moveToNext()) {
            listTodos.add(new ToDo(cursor.getInt(0), cursor.getString(1)));
        }

        cursor.close();
        return listTodos;
    }
}
