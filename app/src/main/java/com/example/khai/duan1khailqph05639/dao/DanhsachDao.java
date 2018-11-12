package com.example.khai.duan1khailqph05639.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.khai.duan1khailqph05639.database.DatabaseHelper;
import com.example.khai.duan1khailqph05639.model.Danhsach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DanhsachDao {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbHelper;

    public static final String TABLE_NAME = "DanhSach";
    public static final String SQL_DANHSACH = "CREATE TABLE DanhSach(id text primary key, chucvu text, ten text, tuoi int, ngaysinh date, luong double, gioitinh text, tinhtrang text, quoctich text );";
    public static final String TAG = "DanhSachDAO";
    SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );

    public DanhsachDao(Context context) {
        dbHelper = new DatabaseHelper( context );
        db = dbHelper.getWritableDatabase();
    }

    public int insertDanhSach(Danhsach danhsach) {
        ContentValues values = new ContentValues();
        values.put( "id", danhsach.getId() );
        values.put( "chucvu", danhsach.getChucvu() );
        values.put( "ten", danhsach.getTen() );
        values.put( "tuoi", danhsach.getTuoi() );
        values.put( "ngaysinh", sdf.format( danhsach.getDate() ) );
        values.put( "luong", danhsach.getLuong() );
        values.put( "gioitinh", danhsach.getGioitinh() );
        values.put( "tinhtrang", danhsach.getTinhtrang() );
        values.put( "quoctich", danhsach.getQuoctich() );
        try {
            if (db.insert( TABLE_NAME, null, values ) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.d( TAG, ex.toString() );
        }
        return 1;
    }

    public int updateDanhsach(String id, String chucvu, String ten, int tuoi, Date ngaysinh, double luong, String gioitinh, String tinhtrang, String quoctich) {
        ContentValues values = new ContentValues();
        values.put( "id", id  );
        values.put( "chucvu", chucvu );
        values.put( "ten", ten );
        values.put( "tuoi", tuoi );
        values.put( "ngaysinh", sdf.format( ngaysinh ) );
        values.put( "luong", luong );
        values.put( "gioitinh", gioitinh );
        values.put( "tinhtrang", tinhtrang );
        values.put( "quoctich", quoctich );
        int result = db.update( TABLE_NAME, values, "id=?", new String[]{id} );
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteDanhSachByID(String id) {
        int result = db.delete( TABLE_NAME, "id=?", new String[]{id} );
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public List<Danhsach> getAllDanhSach() throws ParseException {
        List<Danhsach> dsDanhSach = new ArrayList<>();
        Cursor cursor = db.query( TABLE_NAME, null, null, null, null, null, null );
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Danhsach ds = new Danhsach();
            ds.setId( cursor.getString( 0 ) );
            ds.setChucvu( cursor.getString( 1 ) );
            ds.setTen( cursor.getString( 2 ) );
            ds.setTuoi( Integer.parseInt( cursor.getString( 3 ) ) );
            ds.setDate( sdf.parse( cursor.getString( 4 ) ) );
            ds.setLuong( Double.parseDouble( cursor.getString( 5 ) ) );
            ds.setGioitinh( cursor.getString( 6 ) );
            ds.setTinhtrang( cursor.getString( 7 ) );
            ds.setQuoctich( cursor.getString( 8 ) );
            dsDanhSach.add( ds );
            Log.d( "//====", ds.toString() );
            cursor.moveToNext();
        }
        cursor.close();
        return dsDanhSach;
    }


}
