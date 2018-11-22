package com.vn.khai.duan1khailqph05639.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.vn.khai.duan1khailqph05639.model.Danhsach;
import com.vn.khai.duan1khailqph05639.sqlite.SqliteHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.vn.khai.duan1khailqph05639.common.Contants.DANHSACH_CHUCVU;
import static com.vn.khai.duan1khailqph05639.common.Contants.DANHSACH_GIATRI;
import static com.vn.khai.duan1khailqph05639.common.Contants.DANHSACH_GIOITINH;
import static com.vn.khai.duan1khailqph05639.common.Contants.DANHSACH_ID;
import static com.vn.khai.duan1khailqph05639.common.Contants.DANHSACH_NGAYSINH;
import static com.vn.khai.duan1khailqph05639.common.Contants.DANHSACH_QUOCTICH;
import static com.vn.khai.duan1khailqph05639.common.Contants.DANHSACH_TABLE;
import static com.vn.khai.duan1khailqph05639.common.Contants.DANHSACH_TEN;
import static com.vn.khai.duan1khailqph05639.common.Contants.DANHSACH_TINHTRANG;
import static com.vn.khai.duan1khailqph05639.common.Contants.DANHSACH_TUOI;

public class DanhsachDao {
    SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
//    private SQLiteDatabase db;
//    private SQLiteOpenHelper dbHelper;
//
//    public static final String TABLE_NAME = "DanhSach";
//    public static final String SQL_DANHSACH = "CREATE TABLE DanhSach(id text primary key, chucvu text, ten text, tuoi int, ngaysinh date, luong double, gioitinh text, tinhtrang text, quoctich text );";
//    public static final String TAG = "DanhSachDAO";
//    SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
//
//    public DanhsachDao(Context context) {
//        dbHelper = new DatabaseHelper( context );
//        db = dbHelper.getWritableDatabase();
//    }
//
//    public int insertDanhSach(Danhsach danhsach) {
//        ContentValues values = new ContentValues();
//        values.put( "id", danhsach.getId() );
//        values.put( "chucvu", danhsach.getChucvu() );
//        values.put( "ten", danhsach.getTen() );
//        values.put( "tuoi", danhsach.getTuoi() );
//        values.put( "ngaysinh", sdf.format( danhsach.getDate() ) );
//        values.put( "luong", danhsach.getLuong() );
//        values.put( "gioitinh", danhsach.getGioitinh() );
//        values.put( "tinhtrang", danhsach.getTinhtrang() );
//        values.put( "quoctich", danhsach.getQuoctich() );
//        try {
//            if (db.insert( TABLE_NAME, null, values ) == -1) {
//                return -1;
//            }
//        } catch (Exception ex) {
//            Log.d( TAG, ex.toString() );
//        }
//        return 1;
//    }
//
//    public int updateDanhsach(String id, String chucvu, String ten, int tuoi, Date ngaysinh, double luong, String gioitinh, String tinhtrang, String quoctich) {
//        ContentValues values = new ContentValues();
//        values.put( "id", id );
//        values.put( "chucvu", chucvu );
//        values.put( "ten", ten );
//        values.put( "tuoi", tuoi );
//        values.put( "ngaysinh", sdf.format( ngaysinh ) );
//        values.put( "luong", luong );
//        values.put( "gioitinh", gioitinh );
//        values.put( "tinhtrang", tinhtrang );
//        values.put( "quoctich", quoctich );
//        int result = db.update( TABLE_NAME, values, "id=?", new String[]{id} );
//        if (result == 0) {
//            return -1;
//        }
//        return 1;
//    }
//
//    public int deleteDanhSachByID(String id) {
//        int result = db.delete( TABLE_NAME, "id=?", new String[]{id} );
//        if (result == 0) {
//            return -1;
//        }
//        return 1;
//    }
//
//    public List<Danhsach> getAllDanhSach() throws ParseException {
//        List<Danhsach> dsDanhSach = new ArrayList<>();
//        Cursor cursor = db.query( TABLE_NAME, null, null, null, null, null, null );
//        cursor.moveToFirst();
//        while (cursor.isAfterLast() == false) {
//            Danhsach ds = new Danhsach();
//            ds.setId( cursor.getString( 0 ) );
//            ds.setChucvu( cursor.getString( 1 ) );
//            ds.setTen( cursor.getString( 2 ) );
//            ds.setTuoi( Integer.parseInt( cursor.getString( 3 ) ) );
//            ds.setDate( sdf.parse( cursor.getString( 4 ) ) );
//            ds.setLuong( Double.parseDouble( cursor.getString( 5 ) ) );
//            ds.setGioitinh( cursor.getString( 6 ) );
//            ds.setTinhtrang( cursor.getString( 7 ) );
//            ds.setQuoctich( cursor.getString( 8 ) );
//            dsDanhSach.add( ds );
//            Log.d( "//====", ds.toString() );
//            cursor.moveToNext();
//        }
//        cursor.close();
//        return dsDanhSach;
//    }
//
//    public int getSothanhvien() {
//        int so = 0;
//        String sql = "SELECT COUNT(id) from DanhSach";
//        Cursor cursor = db.rawQuery( sql, null );
//        cursor.moveToFirst();
//        while (cursor.isAfterLast() == false) {
//            so = cursor.getInt( 0 );
//            cursor.moveToNext();
//        }
//        cursor.close();
//        return so;
//    }
//    public  double getgiatri(){
//        double giatri=0;
//        String sql="SELECT SUM(luong) from DanhSach";
//        Cursor cursor = db.rawQuery( sql, null );
//        cursor.moveToFirst();
//        while (cursor.isAfterLast() == false) {
//            giatri=cursor.getDouble( 0 );
//            cursor.moveToNext();
//        }
//        cursor.close();
//        return giatri;
//    }
//

    private SQLiteDatabase sqLiteDatabase;
    private SqliteHelper sqliteHelper;

    public DanhsachDao(SqliteHelper sqliteHelper) {
        this.sqliteHelper = sqliteHelper;
    }

    public List<Danhsach> getAllDanhSach() throws ParseException {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        List<Danhsach> danhsaches = new ArrayList<>();
        String GET_ALL_DANHSACH = "SELECT * FROM " + DANHSACH_TABLE;
        Cursor cursor = sqLiteDatabase.rawQuery( GET_ALL_DANHSACH, null );
        if (cursor != null & cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Danhsach danhsach = new Danhsach();
                danhsach.setId( cursor.getString( cursor.getColumnIndex( DANHSACH_ID ) ) );
                danhsach.setChucvu( cursor.getString( cursor.getColumnIndex( DANHSACH_CHUCVU ) ) );
                danhsach.setGioitinh( cursor.getString( cursor.getColumnIndex( DANHSACH_GIOITINH ) ) );
                danhsach.setQuoctich( cursor.getString( cursor.getColumnIndex( DANHSACH_QUOCTICH ) ) );
                danhsach.setTen( cursor.getString( cursor.getColumnIndex( DANHSACH_TEN ) ) );
                danhsach.setDate( sdf.parse( cursor.getString( cursor.getColumnIndex( DANHSACH_NGAYSINH ) ) ) );
                danhsach.setLuong( Double.parseDouble( cursor.getString( cursor.getColumnIndex( DANHSACH_GIATRI ) ) ) );
                danhsach.setTuoi( Integer.parseInt( cursor.getString( cursor.getColumnIndex( DANHSACH_TUOI ) ) ) );
                danhsach.setTinhtrang( cursor.getString( cursor.getColumnIndex( DANHSACH_TINHTRANG ) ) );
                danhsaches.add( danhsach );
                cursor.moveToNext();
            }
            cursor.close();
            sqLiteDatabase.close();
        }
        return danhsaches;
    }

    public long insertDanhSach(Danhsach danhsach) {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( DANHSACH_ID, danhsach.getId() );
        values.put( DANHSACH_CHUCVU, danhsach.getChucvu() );
        values.put( DANHSACH_GIOITINH, danhsach.getGioitinh() );
        values.put( DANHSACH_QUOCTICH, danhsach.getQuoctich() );
        values.put( DANHSACH_TINHTRANG, danhsach.getTinhtrang() );
        values.put( DANHSACH_TEN, danhsach.getTen() );
        values.put( DANHSACH_GIATRI, danhsach.getLuong() );
        values.put( DANHSACH_TUOI, danhsach.getTuoi() );
        values.put( DANHSACH_NGAYSINH, sdf.format( danhsach.getDate() ) );
        long result = sqLiteDatabase.insert( DANHSACH_TABLE, null, values );
        sqLiteDatabase.close();
        return result;
    }

    public long updateDanhSach(String id, String chucvu, String ten, int tuoi, Date ngaysinh, double giatri, String gioitinh, String tinhtrang, String quoctich) {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( DANHSACH_ID, id );
        values.put( DANHSACH_CHUCVU, chucvu );
        values.put( DANHSACH_GIOITINH, gioitinh );
        values.put( DANHSACH_QUOCTICH, quoctich );
        values.put( DANHSACH_TINHTRANG, tinhtrang );
        values.put( DANHSACH_TEN, ten );
        values.put( DANHSACH_GIATRI, giatri );
        values.put( DANHSACH_TUOI, tuoi );
        values.put( DANHSACH_NGAYSINH, sdf.format( ngaysinh ) );
        long result = sqLiteDatabase.update( DANHSACH_TABLE, values, DANHSACH_ID + "=?", new String[]{id} );
        sqLiteDatabase.close();
        return result;
    }

    public long deleteDanhSach(String id) {
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        long result = sqLiteDatabase.delete( DANHSACH_TABLE, DANHSACH_ID + "=?", new String[]{id} );
        sqLiteDatabase.close();
        return result;
    }

    public int getSothanhvien() {
        int so = 0;
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        String sql = "SELECT COUNT(id) from " + DANHSACH_TABLE;
        Cursor cursor = sqLiteDatabase.rawQuery( sql, null );
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            so = cursor.getInt( 0 );
            cursor.moveToNext();
        }
        cursor.close();
        return so;
    }

    public double getgiatri() {
        double giatri = 0;
        sqLiteDatabase = sqliteHelper.getWritableDatabase();
        String sql = "SELECT SUM(giatri) from " + DANHSACH_TABLE;
        Cursor cursor = sqLiteDatabase.rawQuery( sql, null );
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            giatri = cursor.getDouble( 0 );
            cursor.moveToNext();
        }
        cursor.close();
        return giatri;
    }
}
