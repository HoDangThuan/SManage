package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import srt.studentmanage.R;
import srt.studentmanage.ui.intalize.BaseActivity;

public class Main2Activity extends BaseActivity {

    ImageButton btnXemTKB;
    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initViews() {
        btnXemTKB= (ImageButton) findViewById(R.id.btnXemTKB);
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
    }

}
