package srt.studentmanage.ui.activities;

import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

import srt.studentmanage.R;
import srt.studentmanage.adapter.ThoiKhoaBieuAdapter;
import srt.studentmanage.model.objects.ThoiKhoaBieu;
import srt.studentmanage.ui.intalize.BaseActivity;

public class XemThoiKhoaBieuActivity extends BaseActivity {

    ListView lvThoiKhoaBieu;
    ArrayList<ThoiKhoaBieu> dsThoiKhoaBieu;
    ThoiKhoaBieuAdapter thoiKhoaBieuAdapter;
    TabHost tabHost;
    @Override
    protected int getLayout() {
        return R.layout.activity_xem_thoi_khoa_bieu;
    }

    @Override
    protected void initViews() {
        loadTabs();
        loadListView();
    }

    private void loadListView() {
        lvThoiKhoaBieu= (ListView) findViewById(R.id.lvThoiKhoaBieu);
        dsThoiKhoaBieu=new ArrayList<ThoiKhoaBieu>();
        dsThoiKhoaBieu.add(new ThoiKhoaBieu(2,"Lập trình DTDD","117LTDD01",7,8,"Đỗ Phú Huy"
                ,"14/08/2017","","A102"));

        dsThoiKhoaBieu.add(new ThoiKhoaBieu(2,"Lập trình C#","117LTC#01",9,10,"Đỗ Phú Quốc"
                ,"14/08/2017","","A106"));

        thoiKhoaBieuAdapter =new ThoiKhoaBieuAdapter(XemThoiKhoaBieuActivity.this,R.layout.item_lv_thoi_khoa_bieu,dsThoiKhoaBieu);
        lvThoiKhoaBieu.setAdapter(thoiKhoaBieuAdapter);
    }

    private void loadTabs() {
        tabHost= (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec spec;

        spec=tabHost.newTabSpec("t1");
        spec.setIndicator("Thứ 2");
        spec.setContent(R.id.tab1);
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("t2");
        spec.setIndicator("Thứ 3");
        spec.setContent(R.id.tab2);
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("t3");
        spec.setIndicator("Thứ 4");
        spec.setContent(R.id.tab3);
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("t4");
        spec.setIndicator("Thứ 5");
        spec.setContent(R.id.tab4);
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("t5");
        spec.setIndicator("Thứ 6");
        spec.setContent(R.id.tab5);
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("t6");
        spec.setIndicator("Thứ 7");
        spec.setContent(R.id.tab6);
        tabHost.addTab(spec);
    }

    @Override
    protected void main() {
    }

}
