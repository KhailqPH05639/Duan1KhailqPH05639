package com.example.khai.duan1khailqph05639;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LineaActivity extends AppCompatActivity {
    private Toolbar toolbar;
 private ImageView btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_linea );
        toolbar=findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
      btnback=findViewById( R.id.btnback );
      btnback.setOnClickListener( new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent= new Intent( LineaActivity.this,NavigationActivity.class );
              startActivity( intent );
          }
      } );
    }

    public void create_Employee(View view) {
    }
}
