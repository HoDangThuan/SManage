package srt.studentmanage.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import srt.studentmanage.R;
import srt.studentmanage.ui.intalize.BaseActivity;

public class CapNhatTkNganHangActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_cap_nhat_tk_ngan_hang;
    }

    @Override
    protected void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void main() {

    }

}
