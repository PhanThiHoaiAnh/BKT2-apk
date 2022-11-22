package com.example.baiso2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ConCaAdapter extends ArrayAdapter <ConCa> {
    private Context context;
    private int layout;
    private List<ConCa> arrayList;




    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        ConCa csi = arrayList.get(i);

        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tv_nickname = view.findViewById(R.id.tv_nickname);
        TextView tv_dt = view.findViewById(R.id.tv_dactinh);
        TextView tv_colo = view.findViewById(R.id.tv_mau);
        ImageView imageV = view.findViewById(R.id.imgHinh);

        tvName.setText(csi.getTenKH());
        tv_nickname.setText(csi.getBietDanh());
        tv_dt.setText(csi.getDacTinh());
        tv_colo.setText(csi.getMauCa());
        imageV.setImageResource(csi.getHinh());
        return view;
    }
}
