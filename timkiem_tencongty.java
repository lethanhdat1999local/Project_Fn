package tdc.edu.doanlaptrinhdidong2.activityLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import tdc.edu.doanlaptrinhdidong2.ModulesClass.congtyxe;
import tdc.edu.doanlaptrinhdidong2.ModulesClass.tencongtyadapter;
import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbquanlycongty;
import tdc.edu.doanlaptrinhdidong2.R;

public class timkiem_tencongty extends AppCompatActivity {
    EditText edtkey;
    ImageButton btnsearch,btnthoat;
    ListView showresult;
    dbquanlycongty db;
    ArrayList <congtyxe> listdanhsach;
    tencongtyadapter  tencongtyadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timkiem_tencongty);
        setControll();
        setEvent();
    }

    private void setEvent() {
        db = new dbquanlycongty(this);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = edtkey.getText().toString().trim();
                listdanhsach = db.timkiem(key);
                tencongtyadapter = new tencongtyadapter(timkiem_tencongty.this,R.layout.tencongty,listdanhsach);
                showresult.setAdapter(tencongtyadapter);
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setControll() {
        edtkey = findViewById(R.id.edttimkiem_tencongty);
        btnsearch = findViewById(R.id.btntimkiem_timkiemtencongty);
        showresult = findViewById(R.id.listview_dsketquatimkiemtencongty);
        btnthoat = findViewById(R.id.btnthoat_timkiemtencongty);
    }
}
