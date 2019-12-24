package com.example.post_volley_sql.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class db extends SQLiteOpenHelper {
    private static final int DB_V = 1;
    private static final String DB_N = "POST_DB";
    private static final String CR_T = "CREATE TABLE posts (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, body TEXT)";


    public db(Context context){
       super(context, DB_N, null, DB_V );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CR_T);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
