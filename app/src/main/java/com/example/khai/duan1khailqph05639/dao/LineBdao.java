package com.example.khai.duan1khailqph05639.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.khai.duan1khailqph05639.database.DatabaseHelper;

import com.example.khai.duan1khailqph05639.model.LineB;

import java.util.ArrayList;
import java.util.List;

public class LineBdao {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbHelper;

    public static final String TABLE_NAME = "LineB";
    public static final String SQL_LINEB = "create table LineB (id text primary key, vitri text, ten text, soao int, chiso int);";
    public static final String TAG = "LineBdao";


    public LineBdao(Context context) {
        dbHelper = new DatabaseHelper( context );
        db = dbHelper.getWritableDatabase();
    }

    public int insertLineB(LineB lineb) {
        ContentValues values = new ContentValues();
        values.put( "id", lineb.getId() );
        values.put( "vitri", lineb.getVitri() );
        values.put( "ten", lineb.getTen() );
        values.put( "soao", lineb.getSoao() );
        values.put( "chiso", lineb.getChiso() );

        try {
            if (db.insert( TABLE_NAME, null, values ) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.d( TAG, ex.toString() );
        }
        return 1;
    }

    public int updateLineB(String id, String vitri, String ten, int soao, int chiso) {
        ContentValues values = new ContentValues();
        values.put( "id", id );
        values.put( "vitri", vitri );
        values.put( "ten",ten );
        values.put( "soao", soao);
        values.put( "chiso", chiso);
        int result = db.update( TABLE_NAME, values, "id=?", new String[]{id} );
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteLineBByID(String id) {
        int result = db.delete( TABLE_NAME, "id=?", new String[]{id} );
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public List<LineB> getAllLineB()  {
        List<LineB> dsLineB=new ArrayList<>( );
        Cursor cursor=db.query( TABLE_NAME,null,null,null,null,null,null );
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            LineB ds=new LineB(  );
            ds.setId( cursor.getString( 0 ) );
            ds.setVitri( cursor.getString( 1 ) );
            ds.setTen( cursor.getString( 2 ) );
            ds.setSoao( Integer.parseInt( cursor.getString( 3 ) ) );
            ds.setChiso( Integer.parseInt( cursor.getString( 4 ) ) );
            dsLineB.add( ds );
            Log.d( "//====",ds.toString() );
            cursor.moveToNext();
        }
        cursor.close();
        return dsLineB;
    }



}