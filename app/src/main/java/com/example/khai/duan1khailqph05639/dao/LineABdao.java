package com.example.khai.duan1khailqph05639.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.khai.duan1khailqph05639.database.DatabaseHelper;
import com.example.khai.duan1khailqph05639.model.Danhsach;
import com.example.khai.duan1khailqph05639.model.LineAB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LineABdao { private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public static final String TABLE_NAME = "Danhsach";
    public static final String SQL_LINE_AB = "CREATE TABLE Danhsach (id int primary key autoincrement,vitri text, ten text, soao int, chiso int);";
    public static final String TAG = "LineABdao";



    public LineABdao(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertLineAB(LineAB ds) {
        ContentValues values = new ContentValues();
        values.put("vitri", ds.getVitri());
        values.put("ten", ds.getTen());
        values.put("soao", ds.getSoao());
        values.put("chiso", ds.getChiso());


        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.d(TAG, ex.toString());
        }
        return 1;
    }

    public List<LineAB> getAllLineAB() throws ParseException {
        List<LineAB> dsThanhVien = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            LineAB ee = new LineAB();
            ee.setId( Integer.parseInt( c.getString( 0 ) ) );
            ee.setVitri(c.getString(1));
            ee.setTen( c.getString( 2 ) );
            ee.setSoao( Integer.parseInt( c.getString ( 3 ) ));
            ee.setChiso( Integer.parseInt( c.getString ( 4 ) ));





            dsThanhVien.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return dsThanhVien;
    }

    public int updateLineAB(LineAB ds) {
        ContentValues values = new ContentValues();

        values.put("vitri", ds.getVitri());
        values.put("ten", ds.getTen());
        values.put("soao", ds.getSoao());
        values.put("chiso", ds.getChiso());


        int result = db.update(TABLE_NAME, values, "id=?", new String[]{String.valueOf(  ds.getId())});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int deleteLineABID(int id) {
        int result = db.delete(TABLE_NAME, "id=?", new String[]{String.valueOf(  id)});
        if (result == 0) {
            return -1;
        }
        return 1;
    }
}