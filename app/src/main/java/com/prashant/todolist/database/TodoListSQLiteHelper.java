package com.prashant.todolist.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by PRASHANT KOLI on 10/24/2016.
 */
public class TodoListSQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ToDoListApp.sqlite";
    public static final int CURRENT_DATABASE_VERSION = 1;

    private Context context = null;
    private SQLiteDatabase mDatabase = null;

    public TodoListSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null,CURRENT_DATABASE_VERSION );
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(ToDoListTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    @Override
    protected void finalize() throws Throwable {
        this.close();
        super.finalize();
    }
}