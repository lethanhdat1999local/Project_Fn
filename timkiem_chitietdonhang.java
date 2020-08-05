package tdc.edu.doanlaptrinhdidong2.activityLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import tdc.edu.doanlaptrinhdidong2.ModulesClass.chitietdonhang;
import tdc.edu.doanlaptrinhdidong2.ModulesClass.ctdhadapter;
import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbchitietdonhang;
import tdc.edu.doanlaptrinhdidong2.R;

public class timkiem_chitietdonhang extends AppCompatActivity {
    EditText edtmaxe;
    ImageButton imgtimkiem,imgthoat;
    ListView lvShow;
    dbchitietdonhang db;
    ArrayList <chitietdonhang> lsdata;
    ctdhadapter chitiet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timkiem_chitietdonhang);
        setCtroll();
        setEvent();
    }

    private void setEvent() {
        db = new dbchitietdonhang(this);
        imgtimkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int maxe = Integer.parseInt(edtmaxe.getText().toString());
                   lsdata = db.timkiemdonhang(maxe);
                    chitiet = new ctdhadapter(timkiem_chitietdonhang.this,R.layout.chitietdonhang,lsdata);
                    lvShow.setAdapter(chitiet);
                }catch (Exception e){
                    Toast.makeText(timkiem_chitietdonhang.this,"Vui lòng nhập đúng định dạng", Toast.LENGTH_SHORT).show();
                }

            }
        });
        imgthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setCtroll() {
        edtmaxe = findViewById(R.id.edttimkiem_chitietdonhang);
        imgtimkiem = findViewById(R.id.btntimkiem_chitietdonhang);
        imgthoat = findViewById(R.id.btnthoat_timkiemchitietdonhang);
        lvShow = findViewById(R.id.listview_dsketquatimkiemchitietdonhang);
    }
}
