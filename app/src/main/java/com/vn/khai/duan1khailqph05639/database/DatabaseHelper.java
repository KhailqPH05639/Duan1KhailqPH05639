package com.vn.khai.duan1khailqph05639.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vn.khai.duan1khailqph05639.dao.DanhsachDao;
import com.vn.khai.duan1khailqph05639.dao.LineABdao;
import com.vn.khai.duan1khailqph05639.dao.LineBdao;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbDuAn";
    public static final int VERSION = 1;


    public DatabaseHelper(Context context) {
        super( context, DATABASE_NAME, null, VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( DanhsachDao.SQL_DANHSACH );
        db.execSQL( LineABdao.SQL_LINEAB );
        db.execSQL( LineBdao.SQL_LINEB );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "Drop table if exists " + DanhsachDao.TABLE_NAME );
        db.execSQL( "Drop table if exists " + LineABdao.TABLE_NAME );
        db.execSQL( "Drop table if exists " + LineBdao.TABLE_NAME );
        onCreate( db );
    }
}