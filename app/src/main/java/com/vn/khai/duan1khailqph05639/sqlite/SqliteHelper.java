package com.vn.khai.duan1khailqph05639.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import static com.vn.khai.duan1khailqph05639.common.Contants.CREATE_DANHSACH_TABLE;
import static com.vn.khai.duan1khailqph05639.common.Contants.CREATE_LINEAB_TABLE;
import static com.vn.khai.duan1khailqph05639.common.Contants.CREATE_LINEB_TABLE;
import static com.vn.khai.duan1khailqph05639.common.Contants.CREATE_LINEB_TABLE;
import static com.vn.khai.duan1khailqph05639.common.Contants.DANHSACH_TABLE;
import static com.vn.khai.duan1khailqph05639.common.Contants.LINEAB_TABLE;
import static com.vn.khai.duan1khailqph05639.common.Contants.LINEB_TABLE;
import static com.vn.khai.duan1khailqph05639.common.Contants.isDEBUG;

public class SqliteHelper extends SQLiteOpenHelper {
    public SqliteHelper(Context context) {
        super( context, "db.duan1", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( CREATE_DANHSACH_TABLE );
        if (isDEBUG) Log.e( "DANHSACH",CREATE_DANHSACH_TABLE );
        db.execSQL( CREATE_LINEAB_TABLE );
        if (isDEBUG) Log.e( "LINEAB",CREATE_LINEAB_TABLE );
        db.execSQL( CREATE_LINEB_TABLE );
        if (isDEBUG) Log.e( "LINEB",CREATE_LINEB_TABLE );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DANHSACH_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + LINEAB_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + LINEB_TABLE);
    }
}
