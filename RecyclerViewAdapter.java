package tdc.edu.doanlaptrinhdidong2.ModulesClass;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbQuanLyXe;
import tdc.edu.doanlaptrinhdidong2.R;
import tdc.edu.doanlaptrinhdidong2.activityLayout.detail_activity;
import tdc.edu.doanlaptrinhdidong2.activityLayout.allProducts_activity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    public RecyclerViewAdapter(Context mContext, List<xemay> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    private Context mContext;
    private List <xemay> mData;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_view_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            final xemay xemay = mData.get(position);
            holder.tvten.setText("Tên xe: "+xemay.getTenxe());
            holder.tvxuatxu.setText("dung tích : "+xemay.getDungtich());
            holder.tvdungtich.setText("số lượng : "+xemay.getSoluong());
            holder.tvgia.setText("mã loại: "+xemay.getMaloai());
            //sự kiện click;

            holder.btnedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, detail_activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("idxemay",xemay.getMaxe());
                    bundle.putString("tenxe",xemay.getTenxe());
                    bundle.putString("dungtich",xemay.getDungtich());
                    bundle.putInt("soluong",xemay.getSoluong());
                    bundle.putInt("gia",xemay.getMaloai());
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
            });
            holder.btnxoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                    dbQuanLyXe db = new dbQuanLyXe(mContext);
                    db.xoa(xemay.getMaxe());
                    Intent intent = new Intent(mContext, allProducts_activity.class);
                    mContext.startActivity(intent);
                    Toast.makeText(mContext,"xóa xe thành công",Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        Log.d("loi", xemay.getMaxe() + " lỗi đây nè ba ơi" + e.getMessage());
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return  mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvten , tvxuatxu, tvdungtich,tvgia;
        CardView cardView;
        ImageButton btnxoa,btnedit;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            tvten = itemView.findViewById(R.id.tvten);
            tvxuatxu = itemView.findViewById(R.id.tvxuatxu);
            tvdungtich = itemView.findViewById(R.id.tvdungtich);
            tvgia = itemView.findViewById(R.id.tvgia);
            cardView = itemView.findViewById(R.id.cardview_id);
            btnxoa = itemView.findViewById(R.id.btnxoacardview);
            btnedit = itemView.findViewById(R.id.editProduct);
        }
    }
}
