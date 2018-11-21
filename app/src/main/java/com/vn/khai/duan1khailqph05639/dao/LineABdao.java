package com.vn.khai.duan1khailqph05639.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.vn.khai.duan1khailqph05639.database.DatabaseHelper;

import com.vn.khai.duan1khailqph05639.model.LineAB;


import java.util.ArrayList;
import java.util.List;

public class LineABdao {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbHelper;

    public static final String TABLE_NAME = "LineAB";
    public static final String SQL_LINEAB = "create table LineAB (id text primary key, vitri text, ten text, soao int, chiso int);";
    public static final String TAG = "LineABdao";


    public LineABdao(Context context) {
        dbHelper = new DatabaseHelper( context );
        db = dbHelper.getWritableDatabase();
    }

    public int insertLineAB(LineAB lineab) {
        ContentValues values = new ContentValues();
        values.put( "id", lineab.getId() );
        values.put( "vitri", lineab.getVitri() );
        values.put( "ten", lineab.getTen() );
        values.put( "soao", lineab.getSoao() );
        values.put( "chiso", lineab.getChiso() );

        try {
            if (db.insert( TABLE_NAME, null, values ) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.d( TAG, ex.toString() );
        }
        return 1;
    }

    public int updateLineAB(String id, String vitri, String ten, int soao, int chiso) {
        ContentValues values = new ContentValues();
        values.put( "id", id );
        values.put( "vitri", vitri );
        values.put( "ten", ten );
        values.put( "soao", soao );
        values.put( "chiso", chiso );
        int result = db.update( TABLE_NAME, values, "id=?", new String[]{id} );
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteLineABByID(String id) {
        int result = db.delete( TABLE_NAME, "id=?", new String[]{id} );
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public List<LineAB> getAllLineAB()  {
        List<LineAB> dsLineAB=new ArrayList<>( );
        Cursor cursor=db.query( TABLE_NAME,null,null,null,null,null,null );
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            LineAB ds=new LineAB(  );
            ds.setId( cursor.getString( 0 ) );
            ds.setVitri( cursor.getString( 1 ) );
            ds.setTen( cursor.getString( 2 ) );
            ds.setSoao( Integer.parseInt( cursor.getString( 3 ) ) );
            ds.setChiso( Integer.parseInt( cursor.getString( 4 ) ) );
            dsLineAB.add( ds );
            Log.d( "//====",ds.toString() );
            cursor.moveToNext();
        }
        cursor.close();
        return dsLineAB;
    }



}