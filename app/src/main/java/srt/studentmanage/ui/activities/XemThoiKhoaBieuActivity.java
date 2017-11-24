package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import srt.studentmanage.R;
import srt.studentmanage.adapter.ThoiKhoaBieuAdapter;
import srt.studentmanage.common.Constances;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.model.objects.ThoiKhoaBieu;
import srt.studentmanage.ui.intalize.BaseActivity;

public class XemThoiKhoaBieuActivity extends BaseActivity {

    ListView lvThoiKhoaBieu;
    ArrayList<ThoiKhoaBieu> dsThoiKhoaBieu;
    ThoiKhoaBieuAdapter thoiKhoaBieuAdapter;
    TabHost tabHost;
    String masv;

    @Override
    protected int getLayout() {
        return R.layout.activity_xem_thoi_khoa_bieu;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        masv = intent.getStringExtra(MainActivity.MASV);
        loadData();
        loadTabs();
        loadListView();
    }

    private void loadData() {
        dsThoiKhoaBieu=new ArrayList<ThoiKhoaBieu>();
        dsThoiKhoaBieu.add(new ThoiKhoaBieu(2,"Lập trình DTDD","117LTDD01",7,8,"Đỗ Phú Huy"
                ,"14/08/2017","","A102"));

        dsThoiKhoaBieu.add(new ThoiKhoaBieu(2,"Lập trình C#","117LTC#01",9,10,"Đỗ Phú Quốc"
                ,"14/08/2017","","A106"));
    }

    private void loadListView() {
        int thu;
        for (thu=2;thu<=7;thu++){
            lvThoiKhoaBieu=null;
            thoiKhoaBieuAdapter=null;
            LinearLayout currentLayout=null;
            switch (thu){
                case 2: currentLayout= (LinearLayout) findViewById(R.id.tab1); break;
                case 3: currentLayout= (LinearLayout) findViewById(R.id.tab2); break;
                case 4: currentLayout= (LinearLayout) findViewById(R.id.tab3); break;
                case 5: currentLayout= (LinearLayout) findViewById(R.id.tab4); break;
                case 6: currentLayout= (LinearLayout) findViewById(R.id.tab5); break;
                case 7: currentLayout= (LinearLayout) findViewById(R.id.tab6); break;
            }
            lvThoiKhoaBieu= (ListView) currentLayout.findViewById(R.id.lvThoiKhoaBieu);
            thoiKhoaBieuAdapter =new ThoiKhoaBieuAdapter(XemThoiKhoaBieuActivity.this,R.layout.item_lv_thoi_khoa_bieu,dsThoiKhoaBieu);
            lvThoiKhoaBieu.setAdapter(thoiKhoaBieuAdapter);
        }
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

        tabHost.setCurrentTab(0);
    }

    @Override
    protected void main() {

    }

    private class  HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            RestClient client = new RestClient(Constances.URLService+"sinhvien");
            client.AddParam("masv", masv);
            client.AddParam("mahk","216");
            try {
                client.Execute(RestClient.RequestMethod.GET);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String response = client.getResponse();
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JSONArray array = null;
            try {
                array = new JSONArray(s);

            } catch (JSONException e) {

            }

        }
    }
}
