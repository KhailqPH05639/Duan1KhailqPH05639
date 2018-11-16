package com.example.khai.duan1khailqph05639;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.khai.duan1khailqph05639.dao.DanhsachDao;

public class ThongkeActivity extends AppCompatActivity {
    private TextView tvThongke;
    private DanhsachDao danhsachDao;
    private TextView tvGiatri;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_thongke );
        tvThongke = (TextView) findViewById(R.id.tv_thongke);
        danhsachDao=new DanhsachDao( ThongkeActivity.this);
        tvGiatri = (TextView) findViewById(R.id.tv_giatri);
        tvThongke.setText( danhsachDao.getSothanhvien() +"");
        tvGiatri.setText( danhsachDao.getgiatri()+" $" );


    }

    public void back(View view) {
        Intent intent= new Intent( ThongkeActivity.this,NavigationActivity.class );
   startActivity( intent );
    }
}
