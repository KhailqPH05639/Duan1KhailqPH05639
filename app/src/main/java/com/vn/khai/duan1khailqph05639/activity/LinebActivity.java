package com.vn.khai.duan1khailqph05639.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


import com.vn.khai.duan1khailqph05639.R;
import com.vn.khai.duan1khailqph05639.adapter.LineBAdapter;

import com.vn.khai.duan1khailqph05639.dao.LineBdao;
import com.vn.khai.duan1khailqph05639.model.LineB;

import java.util.ArrayList;
import java.util.List;

public class LinebActivity extends AppCompatActivity {

    private EditText edid;
    private EditText edvitri;
    private EditText edten;
    private EditText edsooao;
    private EditText edchiso;
    private ImageView imgDelete;


    private Toolbar toolbar;
    private ImageView btnback;

    private ListView lvEmployee;

    public static List<LineB> dsLineB = new ArrayList<>();
    LineBdao lineBdao;
    private LineBAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_lineb );
        toolbar = (Toolbar) findViewById( R.id.toolbar );
        btnback = (ImageView) findViewById( R.id.btnback );
        lvEmployee = (ListView) findViewById( R.id.lv_Employee );

        lineBdao = new LineBdao( LinebActivity.this );
        adapter = new LineBAdapter( LinebActivity.this, dsLineB );
        lvEmployee.setAdapter( adapter );
        dsLineB = lineBdao.getAllLineB();
        btnback.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(), NavigationActivity.class ) );
            }
        } );
        lvEmployee.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder( LinebActivity.this );
                String title = "Edit";
                ForegroundColorSpan colorSpan = new ForegroundColorSpan( Color.BLACK );
                SpannableStringBuilder stringBuilder = new SpannableStringBuilder( title );
                stringBuilder.setSpan( colorSpan, 0, title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
                mBuilder.setTitle( stringBuilder );
                LayoutInflater inflater = (LayoutInflater) getSystemService( LAYOUT_INFLATER_SERVICE );
                final View dialog = inflater.inflate( R.layout.form_lineb, null );
                mBuilder.setView( dialog );

                edid = (EditText) dialog.findViewById( R.id.ed_id );
                edvitri = (EditText) dialog.findViewById( R.id.ed_vitri );
                edten = (EditText) dialog.findViewById( R.id.ed_ten );
                edsooao = (EditText) dialog.findViewById( R.id.ed_soao );
                edchiso = (EditText) dialog.findViewById( R.id.ed_chiso );
                edid.setEnabled( false );
                edid.setText( dsLineB.get( position ).getId() );
                edvitri.setText( dsLineB.get( position ).getVitri() );
                edten.setText( dsLineB.get( position ).getTen() );
                edsooao.setText( dsLineB.get( position ).getSoao() + "" );
                edchiso.setText( dsLineB.get( position ).getChiso() + "" );


                mBuilder.setPositiveButton( "Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        lineBdao = new LineBdao( LinebActivity.this );
                        lineBdao.updateLineB( edid.getText().toString(), edvitri.getText().toString(), edten.getText().toString(), Integer.parseInt( edsooao.getText().toString() ), Integer.parseInt( edchiso.getText().toString() ) );
                        dsLineB.clear();
                        dsLineB = lineBdao.getAllLineB();
                        adapter.changeDataset( dsLineB );
                        Toast.makeText( LinebActivity.this, "Update successfully", Toast.LENGTH_SHORT ).show();
                    }
                } );
                mBuilder.setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mBuilder.setCancelable( true );

                    }
                } );
                mBuilder.show();
            }

        } );


    }

    public void showDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Add Craft " );

        LayoutInflater inflater = (LayoutInflater) getSystemService( LAYOUT_INFLATER_SERVICE );
        final View view1 = inflater.inflate( R.layout.form_lineb, null );
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
                lineBdao = new LineBdao( getApplicationContext() );
                if (validation() > 0) {
                    LineB lineB = new LineB( edid.getText().toString(), edvitri.getText().toString(), edten.getText().toString(), Integer.parseInt( edsooao.getText().toString() ), Integer.parseInt( edchiso.getText().toString() ) );
                    lineBdao.insertLineB( lineB );
                    Toast.makeText( LinebActivity.this, "SuccessFully", Toast.LENGTH_SHORT ).show();
                    onResume();
                } else {
                    Toast.makeText( LinebActivity.this, "Do not leave empty", Toast.LENGTH_SHORT ).show();
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
        dsLineB.clear();
        dsLineB = lineBdao.getAllLineB();
        adapter.changeDataset( lineBdao.getAllLineB() );

    }
}
