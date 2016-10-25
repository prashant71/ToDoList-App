package com.prashant.todolist.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.prashant.todolist.modelclass.ToDOModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PRASHANT KOLI on 4/13/2016.
 */
public class ToDoListTable implements Serializable {
    TodoListSQLiteHelper dbHelper;
    SQLiteDatabase db;
    String TABLE;
    String[] COLUMNS;
    String PKEY;
    boolean isOpen=false;
    static final String CREATE_TABLE = "create table todolist(" +
            "todoIndex INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "todoTitle TEXT, " +
            "todoDescription TEXT, " +
            "todoPriority INT);";

    static final String DROP_TABLE = "drop table if exists todolist";

    public ToDoListTable(Context context) {
        dbHelper = new TodoListSQLiteHelper(context);
        TABLE = "todolist";
        COLUMNS = new String[]{"_id", "todoTitle", "todoDescription", "todoDate", "todoPriority"};
        PKEY = "todoIndex";
    }

    public long insert(ToDOModel todoModel) {
        ContentValues values = new ContentValues();
        values.put("todoTitle",todoModel.getTodoTitle());
        values.put("todoDescription",todoModel.getTodoDescription());
        values.put("todoPriority",todoModel.getTodoPriority());
        open();
        db.insert(TABLE, null, values);
        close();
        return 0;
    }

    public boolean delete(int index) {
        String whereclause = "todoIndex" + "=" + index;
        open();
        boolean b =db.delete(TABLE, whereclause, null) > 0;
        close();
        return b;
    }


    public List<ToDOModel> getTodoList() {
        List<ToDOModel> todolist = new ArrayList<>();
        String query = "select * from " + TABLE + " ORDER BY todoPriority ASC;";

//        String query = "select * from " + TABLE + ";";
        open();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                todolist.add(hydrateNewObject(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        close();
        return todolist;
    }

    private ToDOModel hydrateNewObject(Cursor cursor) {
        ToDOModel todo = new ToDOModel();
        todo.setTodoTitle(cursor.getString(cursor.getColumnIndex("todoTitle")));
        todo.setTodoDescription(cursor.getString(cursor.getColumnIndex("todoDescription")));
        todo.setTodoIndex(cursor.getInt(cursor.getColumnIndex("todoIndex")));
        todo.setTodoPriority(cursor.getInt(cursor.getColumnIndex("todoPriority")));
        return todo;
    }

    void open() {
        if (!isOpen) {
            db = dbHelper.getWritableDatabase();
            isOpen = true;
        }
    }

    void close() {
        if (db != null && isOpen) {
            try {
                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        isOpen = false;

    }
}