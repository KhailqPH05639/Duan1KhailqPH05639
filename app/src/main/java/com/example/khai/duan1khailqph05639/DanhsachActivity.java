package com.example.khai.duan1khailqph05639;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

public class DanhsachActivity extends AppCompatActivity {

    private ImageView btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_danhsach );
        btnback = findViewById( R.id.btnback );
        btnback.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( DanhsachActivity.this, NavigationActivity.class );
                startActivity( intent );
            }
        } );



    }
}


