package com.example.khai.duan1khailqph05639;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


import com.example.khai.duan1khailqph05639.adapter.DanhsachAdapter;
import com.example.khai.duan1khailqph05639.dao.DanhsachDao;
import com.example.khai.duan1khailqph05639.model.Danhsach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DanhsachActivity extends AppCompatActivity {


    private EditText edId;
    private EditText edChucvu;
    private EditText edTen;
    private EditText edTuoi;
    private EditText edNamsinh;
    private EditText edLuong;
    private EditText edGioitinh;
    private EditText edStatus;
    private EditText edQuoctich;

    SimpleDateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy" );


    private Toolbar toolbar;
    private ImageView btnback;
    private ListView lvEmployee;
    private FloatingActionButton floatThemDanhsach;
    public static List<Danhsach> dsDanhSach = new ArrayList<>();
    DanhsachDao danhsachDao;
    private DanhsachAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_danhsach );
        toolbar = (Toolbar) findViewById( R.id.toolbar );
        btnback = (ImageView) findViewById( R.id.btnback );
        lvEmployee = (ListView) findViewById( R.id.lv_Employee );
        floatThemDanhsach = (FloatingActionButton) findViewById( R.id.float_them_danhsach );
        danhsachDao = new DanhsachDao( DanhsachActivity.this );
        adapter = new DanhsachAdapter( DanhsachActivity.this, dsDanhSach );
        lvEmployee.setAdapter( adapter );
        try {
            dsDanhSach = danhsachDao.getAllDanhSach();
        } catch (ParseException e) {
            Log.d( "Error: ", e.toString() );
        }
        btnback.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(), NavigationActivity.class ) );
            }
        } );


    }

    private void setDate(Calendar calendar) {
        edNamsinh.setText( sdf.format( calendar.getTime() ) );

    }

    public void showDialog(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Add Members " );

        LayoutInflater inflater = (LayoutInflater) getSystemService( LAYOUT_INFLATER_SERVICE );
        final View view1 = inflater.inflate( R.layout.form_add, null );
        builder.setView( view1 );

        edId = (EditText) view1.findViewById( R.id.ed_id );
        edChucvu = (EditText) view1.findViewById( R.id.ed_chucvu );
        edTen = (EditText) view1.findViewById( R.id.ed_ten );
        edTuoi = (EditText) view1.findViewById( R.id.ed_tuoi );
        edNamsinh = (EditText) view1.findViewById( R.id.ed_namsinh );
        edLuong = (EditText) view1.findViewById( R.id.ed_luong );
        edGioitinh = (EditText) view1.findViewById( R.id.ed_gioitinh );
        edStatus = (EditText) view1.findViewById( R.id.ed_status );
        edQuoctich = (EditText) view1.findViewById( R.id.ed_quoctich );

        edNamsinh.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get( Calendar.YEAR );
                int month = calendar.get( Calendar.MONTH );
                final int day = calendar.get( Calendar.DAY_OF_MONTH );

                DatePickerDialog datePickerDialog = new DatePickerDialog( view1.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar calendar1 = new GregorianCalendar( year, month, dayOfMonth );
                        setDate( calendar1 );
                    }
                }, year, month, day );
                datePickerDialog.show();
            }
        } );


        builder.setPositiveButton( "Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                danhsachDao = new DanhsachDao( getApplicationContext() );
                try {
                    if (validation()>0){
                    Danhsach danhsach = new Danhsach( edId.getText().toString(), edChucvu.getText().toString(), edTen.getText().toString(), edGioitinh.getText().toString(), edStatus.getText().toString(), edQuoctich.getText().toString(), Integer.parseInt( edTuoi.getText().toString() ), Double.parseDouble( edLuong.getText().toString() ), sdf.parse( edNamsinh.getText().toString() ) );
                    danhsachDao.insertDanhSach( danhsach );
                        Toast.makeText( DanhsachActivity.this, "SuccessFully", Toast.LENGTH_SHORT ).show();
                    onResume();}
                    else {
                        Toast.makeText( DanhsachActivity.this, "Fail", Toast.LENGTH_SHORT ).show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } );
        builder.setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        } );
        builder.show();
    }

    public int validation() {
        if (edChucvu.getText().toString().isEmpty() || edTen.getText().toString().isEmpty() || edTuoi.getText().toString().isEmpty() || edNamsinh.getText().toString().isEmpty() || edLuong.getText().toString().isEmpty() || edGioitinh.getText().toString().isEmpty() || edStatus.getText().toString().isEmpty() || edQuoctich.getText().toString().isEmpty()) {
            return -1;
        }
        return 1;
    }

    @Override
    protected void onResume() {
        super.onResume();
        dsDanhSach.clear();
        try {
            dsDanhSach = danhsachDao.getAllDanhSach();
            adapter.changeDataset( danhsachDao.getAllDanhSach() );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


