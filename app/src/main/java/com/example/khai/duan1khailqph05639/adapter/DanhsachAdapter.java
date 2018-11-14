package com.example.khai.duan1khailqph05639.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khai.duan1khailqph05639.R;
import com.example.khai.duan1khailqph05639.dao.DanhsachDao;
import com.example.khai.duan1khailqph05639.model.Danhsach;

import java.text.SimpleDateFormat;
import java.util.List;

public class DanhsachAdapter extends BaseAdapter {
    List<Danhsach> arrDanhsach;
    public Activity context;
    public LayoutInflater inflater;
    DanhsachDao danhsachDao;
    SimpleDateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy" );

    public DanhsachAdapter(Activity context, List<Danhsach> arrDanhsach) {
        super();
        this.context = context;
        this.arrDanhsach = arrDanhsach;
        this.inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        danhsachDao = new DanhsachDao( context );

    }

    @Override
    public int getCount() {
        return arrDanhsach.size();
    }

    @Override
    public Object getItem(int position) {
        return arrDanhsach.get( position );
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHoler {

        ImageView img_delete;
        TextView tv_chucvu,tv_ID, tv_ten, tv_tuoi, tv_ngaysinh, tv_luong, tv_gioitinh, tv_tinhtrang, tv_quoctich;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHoler holer;
        if (convertView == null) {
            holer = new ViewHoler();
            convertView = inflater.inflate( R.layout.item_danhsach, null );
            holer.tv_ID=convertView.findViewById( R.id.tv_id );
            holer.img_delete = convertView.findViewById( R.id.img_delete );
            holer.tv_chucvu = convertView.findViewById( R.id.tv_chucvu );
            holer.tv_ten = convertView.findViewById( R.id.tv_ten );
            holer.tv_tuoi = convertView.findViewById( R.id.tv_tuoi );
            holer.tv_ngaysinh = convertView.findViewById( R.id.tv_ngaysinh );
            holer.tv_luong = convertView.findViewById( R.id.tv_luong );
            holer.tv_gioitinh = convertView.findViewById( R.id.tv_gioitinh );
            holer.tv_tinhtrang = convertView.findViewById( R.id.tv_tinhtrang );
            holer.tv_quoctich = convertView.findViewById( R.id.tv_quoctich );

            holer.img_delete.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    danhsachDao.deleteDanhSachByID( arrDanhsach.get( position ).getId() );
                    arrDanhsach.remove( position );
                    notifyDataSetChanged();
                }
            } );
            convertView.setTag( holer );
        } else
            holer = (ViewHoler) convertView.getTag();
        Danhsach _entry = arrDanhsach.get( position );
        holer.tv_ID.setText( _entry.getId() );

        holer.tv_chucvu.setText(_entry.getChucvu() );
        holer.tv_ten.setText( _entry.getTen() );
        holer.tv_tuoi.setText(_entry.getTuoi() + "" );
        holer.tv_ngaysinh.setText( sdf.format( _entry.getDate() ) );
        holer.tv_luong.setText(_entry.getLuong() + "" );
        holer.tv_gioitinh.setText(_entry.getGioitinh() );
        holer.tv_tinhtrang.setText(_entry.getTinhtrang() );
        holer.tv_quoctich.setText( _entry.getQuoctich() );
        holer.img_delete.setImageResource( R.drawable.cancel );
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<Danhsach> items) {
        this.arrDanhsach = items;
        notifyDataSetChanged();
    }

}




