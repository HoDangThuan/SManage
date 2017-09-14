package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import srt.studentmanage.R;
import srt.studentmanage.ui.intalize.BaseActivity;

public class Main2Activity extends BaseActivity {

    ImageButton btnXemTKB,btnXemDiem, btnXemTinDaoTao;
    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initViews() {
        btnXemTKB= (ImageButton) findViewById(R.id.btnXemTKB);
        btnXemDiem= (ImageButton) findViewById(R.id.btnXemDiem);
        btnXemTinDaoTao =(ImageButton) findViewById(R.id.btnXemTinDaoTao);
    }

    @Override
    protected void main() {
        btnXemTKB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(new Intent(Main2Activity.this,XemThoiKhoaBieuActivity.class),false);
                overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
            }
        });

        btnXemDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(new Intent(Main2Activity.this,XemDiemActivity.class),false);
                overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
            }
        });
        btnXemTinDaoTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, XemTinDaoTaoActivity.class);
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
            }
        });

    }

}
