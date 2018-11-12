package com.example.khai.duan1khailqph05639;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
 private Button btnLogin;
    private EditText edUserName;
    private EditText edPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        edUserName = (EditText) findViewById(R.id.edUserName);
        edPassWord = (EditText) findViewById(R.id.edPassWord);
    btnLogin=findViewById( R.id.btnlogin );
    btnLogin.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username = edUserName.getText().toString().trim();
            String password = edPassWord.getText().toString().trim();
            if (username.equals("")) {
                edUserName.setError(getString(R.string.notify_empty_username));
                return;
            }
            if (password.equals("")) {
                edPassWord.setError(getString(R.string.notify_empty_username));
                return;
            }if(username.equals("admin") || password.equals("admin")){
                Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
                startActivity(intent);

            }
            else {
                Toast.makeText(LoginActivity.this, "Tài Khoản và Mật Khẩu Sai", Toast.LENGTH_SHORT).show();
            }
        }

    });
    }
}
