package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import srt.studentmanage.R;
import srt.studentmanage.ui.intalize.BaseActivity;

public class MainActivity extends BaseActivity {

    ImageButton btnXemTKB,btnXemDiem, btnXemTinDaoTao, btnCapNhatNganHang,btnXemLichThi;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        btnXemTKB= (ImageButton) findViewById(R.id.btnXemTKB);
        btnXemDiem= (ImageButton) findViewById(R.id.btnXemDiem);
        btnXemTinDaoTao =(ImageButton) findViewById(R.id.btnXemTinDaoTao);
        btnCapNhatNganHang = (ImageButton) findViewById(R.id.btnCapNhatNganHang);
        btnXemLichThi = (ImageButton) findViewById(R.id.btnXemLichThi);
    }

    @Override
    protected void main() {
        btnXemTKB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(new Intent(MainActivity.this,XemThoiKhoaBieuActivity.class),false);
                overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
            }
        });

        btnXemDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(new Intent(MainActivity.this,XemDiemActivity.class),false);
                overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
            }
        });
        btnXemTinDaoTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, XemTinDaoTaoActivity.class);
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
            }
        });

        btnCapNhatNganHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CapNhatTkNganHangActivity.class);
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
            }
        });
        btnXemLichThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, XemLichThiActivity.class);
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
            }
        });


    }

}
