package com.example.khai.duan1khailqph05639;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khai.duan1khailqph05639.adapter.DanhsachAdapter;
import com.example.khai.duan1khailqph05639.adapter.LineABadapter;
import com.example.khai.duan1khailqph05639.dao.DanhsachDao;
import com.example.khai.duan1khailqph05639.dao.LineABdao;
import com.example.khai.duan1khailqph05639.model.Danhsach;
import com.example.khai.duan1khailqph05639.model.LineAB;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class LineaActivity extends AppCompatActivity {

    private EditText edid;
    private EditText edvitri;
    private EditText edten;
    private EditText edsooao;
    private EditText edchiso;
    private ImageView imgDelete;


    private Toolbar toolbar;
    private ImageView btnback;

    private ListView lvEmployee;
    private FloatingActionButton floatThemDanhsach;
    public static List<LineAB> dsLineAB = new ArrayList<>();
    LineABdao lineABdao;
    private LineABadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_linea );
        toolbar = (Toolbar) findViewById( R.id.toolbar );
        btnback = (ImageView) findViewById( R.id.btnback );
        lvEmployee = (ListView) findViewById( R.id.lv_Employee );
        floatThemDanhsach = (FloatingActionButton) findViewById( R.id.float_them_danhsach );
        lineABdao = new LineABdao( LineaActivity.this );
        adapter = new LineABadapter( LineaActivity.this, dsLineAB );
        lvEmployee.setAdapter( adapter );
        dsLineAB = lineABdao.getAllLineAB();
        btnback.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(), NavigationActivity.class ) );
            }
        } );


    }

    public void showDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Add Members " );

        LayoutInflater inflater = (LayoutInflater) getSystemService( LAYOUT_INFLATER_SERVICE );
        final View view1 = inflater.inflate( R.layout.form_line, null );
        builder.setView( view1 );

        edid = view1.findViewById( R.id.ed_id );
        edvitri = view1.findViewById( R.id.ed_vitri );
        edten = view1.findViewById( R.id.ed_ten );
        edsooao = view1.findViewById( R.id.ed_soao );
        edchiso = view1.findViewById( R.id.ed_chiso );
        imgDelete = (ImageView) view1.findViewById( R.id.img_delete );


        builder.setPositiveButton( "Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                lineABdao = new LineABdao( getApplicationContext() );
                if (validation() > 0) {
                    LineAB lineAB = new LineAB( edid.getText().toString(), edvitri.getText().toString(), edten.getText().toString(), Integer.parseInt( edsooao.getText().toString() ), Integer.parseInt( edchiso.getText().toString() ) );
                    lineABdao.insertLineAB( lineAB );
                    Toast.makeText( LineaActivity.this, "SuccessFully", Toast.LENGTH_SHORT ).show();
                    onResume();
                } else {
                    Toast.makeText( LineaActivity.this, "Fail", Toast.LENGTH_SHORT ).show();
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
        if (edvitri.getText().toString().isEmpty() || edten.getText().toString().isEmpty() || edsooao.getText().toString().isEmpty() || edchiso.getText().toString().isEmpty()) {
            return -1;
        }
        return 1;
    }

    @Override
    protected void onResume() {
        super.onResume();
        dsLineAB.clear();
        dsLineAB = lineABdao.getAllLineAB();
        adapter.changeDataset( lineABdao.getAllLineAB() );

    }
}
