package com.vn.khai.duan1khailqph05639.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vn.khai.duan1khailqph05639.R;

import com.vn.khai.duan1khailqph05639.dao.LineBdao;
import com.vn.khai.duan1khailqph05639.model.LineB;
import com.vn.khai.duan1khailqph05639.sqlite.SqliteHelper;

import java.util.List;

public class LineBAdapter extends BaseAdapter {
    List<LineB> arrLineB;
    public Activity context;
    public LayoutInflater inflater;
    LineBdao lineBdao;


    public LineBAdapter(Activity context, List<LineB> arrLineB) {
        super();
        this.context = context;
        this.arrLineB = arrLineB;
        this.inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        lineBdao = new LineBdao( new SqliteHelper( context ) );

    }

    public LineBAdapter() {

    }

    @Override
    public int getCount() {
        return arrLineB.size();
    }

    @Override
    public Object getItem(int position) {
        return arrLineB.get( position );
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHoler {

        ImageView img_delete;
        TextView tv_id, tv_vitri, tv_ten, tv_soao, tv_chiso;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LineBAdapter.ViewHoler holer;
        if (convertView == null) {
            holer = new LineBAdapter.ViewHoler();
            convertView = inflater.inflate( R.layout.iteam_lineb, null );
            holer.tv_id = convertView.findViewById( R.id.tv_id );
            holer.tv_vitri = convertView.findViewById( R.id.tv_vitri );
            holer.tv_ten = convertView.findViewById( R.id.tv_ten );
            holer.tv_soao = convertView.findViewById( R.id.tv_soao );
            holer.tv_chiso = convertView.findViewById( R.id.tv_chiso );
            holer.img_delete = convertView.findViewById( R.id.img_delete );

            holer.img_delete.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lineBdao.deleteLineB( arrLineB.get( position ).getId() );
                    arrLineB.remove( position );
                    notifyDataSetChanged();
                }
            } );
            convertView.setTag( holer );
        } else
            holer = (LineBAdapter.ViewHoler) convertView.getTag();
        LineB _entry = arrLineB.get( position );
        holer.tv_id.setText( _entry.getId() );

        holer.tv_vitri.setText(  _entry.getVitri() );
        holer.tv_ten.setText(  _entry.getTen() );
        holer.tv_soao.setText(  _entry.getSoao() + "" );
        holer.tv_chiso.setText(  _entry.getChiso() + "" );
        holer.img_delete.setImageResource( R.drawable.cancel );
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<LineB> items) {
        this.arrLineB = items;
        notifyDataSetChanged();
    }

}