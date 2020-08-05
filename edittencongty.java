package tdc.edu.doanlaptrinhdidong2.activityLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import tdc.edu.doanlaptrinhdidong2.ModulesClass.congtyxe;
import tdc.edu.doanlaptrinhdidong2.ModulesDB.dbquanlycongty;
import tdc.edu.doanlaptrinhdidong2.R;

public class edittencongty extends AppCompatActivity {
    EditText tenloai , xuatxu;
    ImageButton btnedit , btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittencongty);
        setControll();
        setEvent();
    }

    private void setEvent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String tenloaixe = bundle.getString("tenloai");
        String xuatxuxe = bundle.getString("xuatxu");
        final int maxe = bundle.getInt("id_tencongty");
        tenloai.setText(tenloaixe);
        xuatxu.setText(xuatxuxe);
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                congtyxe congty = new congtyxe();
                congty.setMaloai(maxe);
                congty.setTenloai(tenloai.getText().toString());
                congty.setXuatxu(xuatxu.getText().toString());

                dbquanlycongty db= new dbquanlycongty(edittencongty.this);
                db.update(congty,maxe);
                Toast.makeText(getApplicationContext(),"update thanh cong",Toast.LENGTH_SHORT).show();
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
    }

    private void setControll() {
        tenloai = findViewById(R.id.edttenloai_tencongty);
        xuatxu = findViewById(R.id.edtxuatxu_tencongty);
        btnedit = findViewById(R.id.imgedittencongty);
        btnback = findViewById(R.id.imgtrovetencongty);
    }
}
