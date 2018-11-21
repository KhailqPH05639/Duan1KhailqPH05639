package com.vn.khai.duan1khailqph05639.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.vn.khai.duan1khailqph05639.R;

public class ThanhtichActivity extends AppCompatActivity {

    private ImageView btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_thanhtich );
        btnback = findViewById( R.id.btnback );
        btnback.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ThanhtichActivity.this, NavigationActivity.class );
                startActivity( intent );
            }
        } );
    }
}
