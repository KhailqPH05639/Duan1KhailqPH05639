package com.example.khai.duan1khailqph05639;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
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

//    private ImageView btnback;
//    private Toolbar toolbar;
//    private FloatingActionButton actionButton;
//    private ListView lvEmployee;
//    public static List<Danhsach> dsDanhsach=new ArrayList<>(  );
//    DanhsachAdapter adapter;
//    DanhsachDao danhsachDao;
//
//    private EditText edId;
//    private EditText edChucvu;
//    private EditText edTen;
//    private EditText edTuoi;
//    private EditText edNamsinh;
//    private EditText edLuong;
//    private EditText edGioitinh;
//    private EditText edStatus;
//    private EditText edQuoctich;
//
//    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    private Toolbar toolbar;
    private ImageView btnback;
    private ListView lvEmployee;
    private FloatingActionButton floatThemDanhsach;
    public static List<Danhsach> dsDanhSach=new ArrayList<>(  );
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
        danhsachDao=new DanhsachDao(DanhsachActivity.this);
        adapter=new DanhsachAdapter(DanhsachActivity.this,dsDanhSach );
        lvEmployee.setAdapter( adapter );
        try{
            dsDanhSach=danhsachDao.getAllDanhSach();
        } catch (ParseException e) {
            Log.d("Error: ",e.toString());
        }
        btnback.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(),NavigationActivity.class ) );
            }
        } );

        floatThemDanhsach.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( DanhsachActivity.this, "Click", Toast.LENGTH_SHORT ).show();
            }
        } );



        floatThemDanhsach.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getApplicationContext());
                String title = "Thêm Sách";

                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.BLACK);
                SpannableStringBuilder stringBuilder = new SpannableStringBuilder(title);
                stringBuilder.setSpan(colorSpan, 0, title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                mBuilder.setTitle(stringBuilder);
                LayoutInflater inflater = (LayoutInflater) getSystemService( LAYOUT_INFLATER_SERVICE );
                final View dialog = inflater.inflate(R.layout.form_add, null);
                mBuilder.setView(dialog);

                EditText edId = (EditText) dialog.findViewById(R.id.ed_id);
                EditText edChucvu = (EditText) dialog.findViewById(R.id.ed_chucvu);
                EditText edTen = (EditText) dialog.findViewById(R.id.ed_ten);
                EditText edTuoi = (EditText) dialog.findViewById(R.id.ed_tuoi);
                EditText edNamsinh = (EditText) dialog.findViewById(R.id.ed_namsinh);
                EditText edLuong = (EditText) dialog.findViewById(R.id.ed_luong);
                EditText edGioitinh = (EditText) dialog.findViewById(R.id.ed_gioitinh);
                EditText edStatus = (EditText) dialog.findViewById(R.id.ed_status);
                EditText edQuoctich = (EditText) dialog.findViewById(R.id.ed_quoctich);
                edNamsinh.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar calendar = Calendar.getInstance();
                        int year = calendar.get(Calendar.YEAR);
                        int month = calendar.get(Calendar.MONTH);
                        final int day = calendar.get(Calendar.DAY_OF_MONTH);

                        DatePickerDialog datePickerDialog=new DatePickerDialog( dialog.getContext(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                Calendar calendar1=new GregorianCalendar( year,month,dayOfMonth );
                                setDate( calendar1 );
                            }
                        } ,year,month,day);
                    }
                } );
                mBuilder.setPositiveButton( "Thêm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText( DanhsachActivity.this, "Thêm", Toast.LENGTH_SHORT ).show();
                        danhsachDao=new DanhsachDao( getApplicationContext() );

                    }
                } );
                mBuilder.setNegativeButton( "Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText( DanhsachActivity.this, "hủy", Toast.LENGTH_SHORT ).show();
                    }
                } );

            }
        } );


    }

    private void setDate(Calendar calendar) {

    }
}


