package com.example.khai.duan1khailqph05639;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ThongkeActivity extends AppCompatActivity {
    private ImageView btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_thongke );
        btnback = findViewById( R.id.btnback );
        btnback.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ThongkeActivity.this, NavigationActivity.class );
                startActivity( intent );
            }
        } );
    }
}
