package srt.studentmanage.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import srt.studentmanage.R;
import srt.studentmanage.adapter.LichThiAdapter;
import srt.studentmanage.model.objects.LichThi;
import srt.studentmanage.ui.intalize.BaseActivity;

public class XemLichThiActivity extends BaseActivity {

    ListView lvLichThi;
    ArrayList<LichThi> dsLichThi;
    LichThiAdapter lichThiAdapter;


    private void loadListView() {
        dsLichThi=new ArrayList<>();
        dsLichThi.add(new LichThi("116JAVA202","Lap trinh java","Nguyen Van Lanh","14/10/2017","7h00","A202"));
        dsLichThi.add(new LichThi("116JAVA202","Lap trinh java","Nguyen Van Lanh","14/10/2017","7h00","A203"));
        dsLichThi.add(new LichThi("116TDC202","Tin dai cuong","Tran Buu Dung","16/10/2017","7h00","A215"));
        lichThiAdapter=new LichThiAdapter(this,R.layout.item_lv_xem_lich_thi,dsLichThi);
        lvLichThi.setAdapter(lichThiAdapter);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected int getLayout() {
        return R.layout.activity_xem_lich_thi;
    }

    @Override
    protected void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvLichThi= (ListView) findViewById(R.id.lvLichThi);
    }

    @Override
    protected void main() {
        loadListView();
    }
}