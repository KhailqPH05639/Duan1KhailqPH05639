package com.example.khai.duan1khailqph05639.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khai.duan1khailqph05639.R;

import com.example.khai.duan1khailqph05639.dao.LineABdao;

import com.example.khai.duan1khailqph05639.model.LineAB;

import java.util.List;

public class LineABadapter  extends BaseAdapter {
    List<LineAB> arrLineAB;
    public Activity context;
    public LayoutInflater inflater;
    LineABdao lineABdao;


    public LineABadapter(Activity context, List<LineAB> arrLineAB) {
        super();
        this.context = context;
        this.arrLineAB = arrLineAB;
        this.inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        lineABdao = new LineABdao( context );

    }

    public LineABadapter() {

    }

    @Override
    public int getCount() {
        return arrLineAB.size();
    }

    @Override
    public Object getItem(int position) {
        return arrLineAB.get( position );
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHoler {

        ImageView img_delete;
        TextView tv_id,tv_vitri,tv_ten,tv_soao,tv_chiso ;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LineABadapter.ViewHoler holer;
        if (convertView == null) {
            holer = new ViewHoler();
            convertView = inflater.inflate( R.layout.item_lineab, null );
            holer.tv_id=convertView.findViewById( R.id.tv_id );
            holer.tv_vitri=convertView.findViewById( R.id.tv_vitri );
            holer.tv_ten = convertView.findViewById( R.id.tv_ten );
            holer.tv_soao = convertView.findViewById( R.id.tv_soao );
            holer.tv_chiso = convertView.findViewById( R.id.tv_chiso );
            holer.img_delete = convertView.findViewById( R.id.img_delete );

            holer.img_delete.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lineABdao.deleteLineABByID( arrLineAB.get( position ).getId() );
                    arrLineAB.remove( position );
                    notifyDataSetChanged();
                }
            } );
            convertView.setTag( holer );
        } else
            holer = (LineABadapter.ViewHoler) convertView.getTag();
        LineAB _entry = arrLineAB.get( position );
        holer.tv_id.setText( _entry.getId() );
        holer.img_delete.setImageResource( R.drawable.cancel );
        holer.tv_vitri.setText( _entry.getVitri() );
        holer.tv_ten.setText(  _entry.getTen() );
        holer.tv_soao.setText( _entry.getSoao() + "" );
        holer.tv_chiso.setText(  _entry.getChiso() + "" );
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void changeDataset(List<LineAB> items) {
        this.arrLineAB = items;
        notifyDataSetChanged();
    }

}
