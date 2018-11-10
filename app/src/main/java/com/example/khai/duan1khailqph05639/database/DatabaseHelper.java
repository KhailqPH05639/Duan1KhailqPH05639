package com.example.khai.duan1khailqph05639.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.khai.duan1khailqph05639.dao.DanhsachDao;
import com.example.khai.duan1khailqph05639.dao.LineABdao;

public class DatabaseHelper extends SQLiteOpenHelper  {
    public static final String DATABASE_NAME="dbDuAn";
    public static final int VERSION=1;


    public DatabaseHelper(Context context) {
        super( context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DanhsachDao.SQL_DANHSACH );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL( "Drop table if exists "+DanhsachDao.TABLE_NAME );

    onCreate( db );
    }
}