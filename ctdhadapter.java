package tdc.edu.doanlaptrinhdidong2.ModulesClass;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbchitietdonhang;
import tdc.edu.doanlaptrinhdidong2.R;
import tdc.edu.doanlaptrinhdidong2.activityLayout.editchitietdonhang;

public class ctdhadapter extends ArrayAdapter {
    Context context;
    int resource;
    List <chitietdonhang>dsdata;
    dbchitietdonhang dbchitietdonhang;
    public ctdhadapter(Context context, int resource,List dsdata) {
        super(context, resource, dsdata);
        this.context = context;
        this.resource=resource;
        this.dsdata=dsdata;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.chitietdonhang,parent,false);

        TextView tvmaxe = convertView.findViewById(R.id.tvmaxe_chitietdonhang);
        TextView tvsoluong = convertView.findViewById(R.id.tvsoluongdondathang_chitietdonhang);
        TextView tvdongia = convertView.findViewById(R.id.tvdongia_chitietdonhang);
        TextView tvngaylap = convertView.findViewById(R.id.tvngaylap_chitietdonhang);
        ImageButton btnedit = convertView.findViewById(R.id.imgedit_chitietdonhang);
        ImageButton btndelete = convertView.findViewById(R.id.imgdelete_chitietdonhang);
        dbchitietdonhang = new dbchitietdonhang(context);
        final chitietdonhang ct = dsdata.get(position);

        tvmaxe.setText("mã xe : "+ct.getMaxe());
        tvsoluong.setText("số lượng : "+ ct.getSoluongdonhang());
        tvdongia.setText("đơn giá : " + ct.getDongia());
        tvngaylap.setText("ngày lập : " + ct.getNgaylap());

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mahoadon = ct.getMadonhang();
                if(mahoadon>0){
                    dbchitietdonhang.xoa(mahoadon);
                }
                dsdata.clear();
                dsdata.addAll(dbchitietdonhang.layDuLieu());
                notifyDataSetChanged();
            }
        });
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, editchitietdonhang.class);
                Bundle bundle = new Bundle();
                bundle.putInt("maDH",ct.getMadonhang());
                bundle.putInt("maxe",ct.getMaxe());
                bundle.putInt("soluong",ct.getSoluongdonhang());
                bundle.putInt("dongia",ct.getDongia());
                bundle.putString("ngaylap",ct.getNgaylap());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
