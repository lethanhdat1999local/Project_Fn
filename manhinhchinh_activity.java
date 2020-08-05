package tdc.edu.doanlaptrinhdidong2.activityLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import tdc.edu.doanlaptrinhdidong2.R;

public class manhinhchinh_activity extends AppCompatActivity {
    ImageView imgduaxe ;
    Button btnThemsanpham,btnTatcasanpham , btntencongty,btnchitiethoadon;
    AnimationDrawable animationDrawable = null;
    Animation animation = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchinh_activity);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnThemsanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnThemsanpham.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(manhinhchinh_activity.this,AddNew_activity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        btnTatcasanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTatcasanpham.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(manhinhchinh_activity.this,allProducts_activity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        btntencongty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(manhinhchinh_activity.this,tencongtyactivity.class);
                startActivity(intent);
            }
        });
        btnchitiethoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(manhinhchinh_activity.this,chitietdonhangactivity.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        btnThemsanpham = findViewById(R.id.btnthemsanphammanhinhchinh);
        btnTatcasanpham = findViewById(R.id.btntatcasanphammanhinhchinh);
        btntencongty = findViewById(R.id.btntencongtymanhinhchinh);
        btnchitiethoadon = findViewById(R.id.btnchitiethoadonmanhinhchinh);
        imgduaxe = findViewById(R.id.imgduaxe);
        imgduaxe.setBackgroundResource(R.drawable.duaxef1);
        animationDrawable = (AnimationDrawable) imgduaxe.getBackground();
        animationDrawable.start();
        animation = AnimationUtils.loadAnimation(manhinhchinh_activity.this,R.anim.goactivity);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuthemsanpham:
                Intent intent = new Intent(manhinhchinh_activity.this,AddNew_activity.class);
                startActivity(intent);
                break;
            case R.id.menutatcasanpham:
                Intent intent1 = new Intent(manhinhchinh_activity.this,allProducts_activity.class);
                startActivity(intent1);
                break;
            case R.id.menuhome:
//                Intent intent2 = new Intent(this,manhinhchinh_activity.class);
//                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent2);
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
