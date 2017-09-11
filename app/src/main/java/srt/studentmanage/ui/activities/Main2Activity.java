package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import srt.studentmanage.R;
import srt.studentmanage.ui.intalize.BaseActivity;

public class Main2Activity extends BaseActivity {

    ImageButton btnXemTKB,btnXemDiem;
    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initViews() {
        btnXemTKB= (ImageButton) findViewById(R.id.btnXemTKB);
        btnXemDiem= (ImageButton) findViewById(R.id.btnXemDiem);
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


    }

}
