package com.vn.khai.duan1khailqph05639.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vn.khai.duan1khailqph05639.R;

public class GioithieuActivity extends AppCompatActivity {
    private ImageView btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_gioithieu );

        btnback = findViewById( R.id.btnback );
        btnback.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( GioithieuActivity.this, NavigationActivity.class );
                startActivity( intent );
            }
        } );

    }
}
