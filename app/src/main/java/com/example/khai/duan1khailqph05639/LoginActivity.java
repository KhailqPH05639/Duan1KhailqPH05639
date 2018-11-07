package com.example.khai.duan1khailqph05639;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
 private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
    btnLogin=findViewById( R.id.btnLogin );
    btnLogin.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent( LoginActivity.this,NavigationActivity.class );
            startActivity( intent );
        }
    } );

        }
    }

