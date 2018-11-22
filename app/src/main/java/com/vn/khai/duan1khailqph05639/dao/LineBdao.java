package com.vn.khai.duan1khailqph05639.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import com.vn.khai.duan1khailqph05639.model.LineB;
import com.vn.khai.duan1khailqph05639.sqlite.SqliteHelper;

import java.util.ArrayList;
import java.util.List;

import static com.vn.khai.duan1khailqph05639.common.Contants.LINEB_CHISO;
import static com.vn.khai.duan1khailqph05639.common.Contants.LINEB_ID;
import static com.vn.khai.duan1khailqph05639.common.Contants.LINEB_SOAO;
import static com.vn.khai.duan1khailqph05639.common.Contants.LINEB_TABLE;
import static com.vn.khai.duan1khailqph05639.common.Contants.LINEB_TEN;
import static com.vn.khai.duan1khailqph05639.common.Contants.LINEB_VITRI;

public class LineBdao {
    //
    private SQLiteDatabase sqLiteDatabase;
    private SqliteHelper sqliteHelper;

    public LineBdao(SqliteHelper sqliteHelper) {
        this.sqliteHelper = sqliteHelper;
    }

    public List<LineB> getAllLineB() {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        List<LineB> lineBS = new ArrayList<>();
        String GET_ALL_LINEB = "SELECT * FROM " + LINEB_TABLE;
        Cursor cursor = sqLiteDatabase.rawQuery( GET_ALL_LINEB, null );
        if (cursor != null & cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                LineB lineB = new LineB();
                lineB.setId( cursor.getString( cursor.getColumnIndex( LINEB_ID ) ) );
                lineB.setTen( cursor.getString( cursor.getColumnIndex( LINEB_TEN ) ) );
                lineB.setVitri( cursor.getString( cursor.getColumnIndex( LINEB_VITRI ) ) );
                lineB.setChiso( Integer.parseInt( cursor.getString( cursor.getColumnIndex( LINEB_CHISO ) ) ) );
                lineB.setSoao( Integer.parseInt( cursor.getString( cursor.getColumnIndex( LINEB_SOAO ) ) ) );
                lineBS.add( lineB );
                cursor.moveToNext();
            }
            cursor.close();
            sqLiteDatabase.close();
        }
        return lineBS;
    }

    public long insertLineB(LineB lineB) {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( LINEB_ID, lineB.getId() );
        values.put( LINEB_TEN, lineB.getTen() );
        values.put( LINEB_VITRI, lineB.getVitri() );
        values.put( LINEB_CHISO, lineB.getChiso() );
        values.put( LINEB_SOAO, lineB.getSoao() );
        long result = sqLiteDatabase.insert( LINEB_TABLE, null, values );
        sqLiteDatabase.close();
        return result;
    }

    public long updateLineB(String id, String vitri, String ten, int soao, int chiso) {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( LINEB_ID, id );
        values.put( LINEB_TEN, ten );
        values.put( LINEB_VITRI, vitri );
        values.put( LINEB_CHISO, chiso );
        values.put( LINEB_SOAO, soao );
        long result = sqLiteDatabase.update( LINEB_TABLE,values,LINEB_ID+"=?",new String[]{id} );
        sqLiteDatabase.close();
        return result;
    }
    public long deleteLineB(String id) {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        long result = sqLiteDatabase.delete( LINEB_TABLE, LINEB_ID + "=?", new String[]{id} );
        sqLiteDatabase.close();
        return result;
    }
}