package tdc.edu.doanlaptrinhdidong2.ModulesClass;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbquanlycongty;
import tdc.edu.doanlaptrinhdidong2.R;
import tdc.edu.doanlaptrinhdidong2.activityLayout.edittencongty;

public class tencongtyadapter extends ArrayAdapter {
   private Context context;
   private int resource;
   private List <congtyxe> dsData;
   private dbquanlycongty dbquanlycongty;
   public tencongtyadapter(Context context, int resource,List dsData) {
        super(context, resource, dsData);
        this.context = context;
        this.resource=resource;
        this.dsData=dsData;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.tencongty,parent,false);
        final congtyxe congtyxe = dsData.get(position);
        TextView tvtenloai = convertView.findViewById(R.id.tvtenloai_tencongty);
        TextView tvxuatxu = convertView.findViewById(R.id.tvxuatxu_tencongty);
        ImageButton btnxoa = convertView.findViewById(R.id.imgdeletetencongty);
        ImageButton btnedit = convertView.findViewById(R.id.imgedittencongty);
        tvtenloai.setText(congtyxe.getTenloai()+"");
        tvxuatxu.setText(congtyxe.getXuatxu()+"");
        dbquanlycongty = new dbquanlycongty(context);
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idcongty = congtyxe.getMaloai();
                    if(idcongty>0){
                        dbquanlycongty.xoa(idcongty);
                        Log.d("xoa du lieu ", " thanh cong ");
                        dsData.clear();
                        dsData.addAll(dbquanlycongty.layDuLieu());
                        notifyDataSetChanged();
                    }
            }
        });
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idcongty = congtyxe.getMaloai();
                String tenloai = congtyxe.getTenloai();
                String xuatxu = congtyxe.getXuatxu();
                Intent intent = new Intent(context, edittencongty.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id_tencongty",idcongty);
                bundle.putString("tenloai",tenloai);
                bundle.putString("xuatxu",xuatxu);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
