package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import srt.studentmanage.R;
import srt.studentmanage.model.objects.SinhVien;
import srt.studentmanage.ui.intalize.BaseActivity;

public class MainActivity extends BaseActivity {

    ImageButton btnXemTKB,btnXemDiem, btnXemTinDaoTao,btnDoiMatKhau, btnXemThongTin, btnXemHocPhi;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        btnXemTKB= (ImageButton) findViewById(R.id.btnXemTKB);
        btnXemDiem= (ImageButton) findViewById(R.id.btnXemDiem);
        btnXemTinDaoTao =(ImageButton) findViewById(R.id.btnXemTinDaoTao);
        btnDoiMatKhau= (ImageButton) findViewById(R.id.btnDoiMatKhau);
        btnXemThongTin= (ImageButton) findViewById(R.id.btnXemThongTin);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        SinhVien sv = (SinhVien) bundle.getSerializable("SV");
        setTitle(sv.getHoTen());
        btnXemHocPhi= (ImageButton) findViewById(R.id.btnXemHocPhi);
    }
//151250533269
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
        btnDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(new Intent(MainActivity.this,DoiMatKhauActivity.class),false);
                overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
            }
        });

        btnXemThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(new Intent(MainActivity.this,CapNhatTTCaNhanActivity.class),false);
                overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
            }
        });
        btnXemHocPhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(new Intent(MainActivity.this,XemHocPhiActivity.class),false);
                overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
            }
        });
    }

}
