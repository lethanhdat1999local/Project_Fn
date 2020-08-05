package tdc.edu.doanlaptrinhdidong2.activityLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import tdc.edu.doanlaptrinhdidong2.ModulesClass.congtyxe;
import tdc.edu.doanlaptrinhdidong2.ModulesClass.tencongtyadapter;
import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbquanlycongty;
import tdc.edu.doanlaptrinhdidong2.R;

public class tencongtyactivity extends AppCompatActivity {
    EditText etdxuatxu,edtloai;
    ImageButton btnthem,btnthoat,btntimkiem;
    ListView lvResult;
    ArrayList <congtyxe> danhsachcongty;
    tencongtyadapter tencongtyadapter;
    dbquanlycongty dbquanlycongty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tencongtyactivity);
        setControll();
        setEvent();
        dbquanlycongty = new dbquanlycongty(this);
        danhsachcongty = dbquanlycongty.layDuLieu();
        setAdapter();
    }
    private void setEvent() {
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenloai = edtloai.getText().toString();
                String xuatxu  =  etdxuatxu.getText().toString();
                congtyxe congty = new congtyxe(tenloai,xuatxu);
                if(congty!=null){
                    dbquanlycongty.Them(congty);
                }
                updateInfor();
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btntimkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tencongtyactivity.this,timkiem_tencongty.class);
                startActivity(intent);
            }
        });
    }
    private void updateInfor(){
        danhsachcongty.clear();
        danhsachcongty.addAll(dbquanlycongty.layDuLieu());
        setAdapter();
    }
    private void setAdapter(){
        if(tencongtyadapter==null){
            tencongtyadapter = new tencongtyadapter(this,R.layout.tencongty,danhsachcongty);
            lvResult.setAdapter(tencongtyadapter);
        }else{
            tencongtyadapter.notifyDataSetChanged();
        }
    }
    private void setControll() {
        edtloai = findViewById(R.id.edttenloaitencongty);
        etdxuatxu = findViewById(R.id.edtxuatxutencongty);
        btnthem = findViewById(R.id.btnthemtencongty);
        btnthoat = findViewById(R.id.btnexittencongty);
        lvResult = findViewById(R.id.listviewtencongty);
        btntimkiem = findViewById(R.id.btntimkiemtencongty);
    }
}
