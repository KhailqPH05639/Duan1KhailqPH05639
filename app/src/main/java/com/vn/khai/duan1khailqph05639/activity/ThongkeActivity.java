package com.vn.khai.duan1khailqph05639.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.vn.khai.duan1khailqph05639.R;
import com.vn.khai.duan1khailqph05639.dao.DanhsachDao;
import com.vn.khai.duan1khailqph05639.sqlite.SqliteHelper;

public class ThongkeActivity extends AppCompatActivity {
    private TextView tvThongke;
    private DanhsachDao danhsachDao;
    private TextView tvGiatri;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_thongke );
        tvThongke = (TextView) findViewById(R.id.tv_thongke);
        danhsachDao=new DanhsachDao( new SqliteHelper( getApplicationContext() ) );
        tvGiatri = (TextView) findViewById(R.id.tv_giatri);
        tvThongke.setText( danhsachDao.getSothanhvien() +"");
        tvGiatri.setText( danhsachDao.getgiatri()+" $" );


    }

    public void back(View view) {
        Intent intent= new Intent( ThongkeActivity.this,NavigationActivity.class );
   startActivity( intent );
    }
}
