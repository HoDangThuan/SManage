package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import srt.studentmanage.R;
import srt.studentmanage.adapter.ThoiKhoaBieuAdapter;
import srt.studentmanage.common.Constances;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.model.objects.ThoiKhoaBieu;
import srt.studentmanage.ui.intalize.BaseActivity;

public class XemThoiKhoaBieuActivity extends BaseActivity {

    ListView lvThoiKhoaBieu;
    ArrayList<ThoiKhoaBieu> tkb2,tkb3,tkb4,tkb5,tkb6, tkb7;
    ThoiKhoaBieuAdapter thoiKhoaBieuAdapter;
    TabHost tabHost;
    String masv;
    TextView txtHocKi;

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
        txtHocKi = (TextView) findViewById(R.id.txtHocKi);
        loadTabs();
        loadData();

    }

    private void loadData() {
        tkb2 = new ArrayList<ThoiKhoaBieu>();
        tkb3 = new ArrayList<ThoiKhoaBieu>();
        tkb4 = new ArrayList<ThoiKhoaBieu>();
        tkb5 = new ArrayList<ThoiKhoaBieu>();
        tkb6 = new ArrayList<ThoiKhoaBieu>();
        tkb7 = new ArrayList<ThoiKhoaBieu>();
        HttpAsyncTask asyncTask = new HttpAsyncTask();
        asyncTask.execute();
    }

    private void loadListView() {
        int thu;
        for (thu=2;thu<=7;thu++){
            lvThoiKhoaBieu=null;
            thoiKhoaBieuAdapter=null;
            LinearLayout currentLayout=null;
            ArrayList<ThoiKhoaBieu> temp=null;
            switch (thu){
                case 2: currentLayout= (LinearLayout) findViewById(R.id.tab1);
                    temp = new ArrayList<>(tkb2); break;
                case 3: currentLayout= (LinearLayout) findViewById(R.id.tab2);
                    temp = new ArrayList<>(tkb3); break;
                case 4: currentLayout= (LinearLayout) findViewById(R.id.tab3);
                    temp = new ArrayList<>(tkb4); break;
                case 5: currentLayout= (LinearLayout) findViewById(R.id.tab4);
                    temp = new ArrayList<>(tkb5); break;
                case 6: currentLayout= (LinearLayout) findViewById(R.id.tab5);
                    temp = new ArrayList<>(tkb6); break;
                case 7: currentLayout= (LinearLayout) findViewById(R.id.tab6);
                    temp = new ArrayList<>(tkb7); break;
            }
            lvThoiKhoaBieu= (ListView) currentLayout.findViewById(R.id.lvThoiKhoaBieu);
            thoiKhoaBieuAdapter =new ThoiKhoaBieuAdapter(XemThoiKhoaBieuActivity.this
                    ,R.layout.item_lv_thoi_khoa_bieu,temp);
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
            client.AddParam("masvtkb", masv);
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
            try {
                JSONObject root = new JSONObject(s);
                txtHocKi.setText("Học kì "+root.getString("MaHK"));
                JSONArray array = root.getJSONArray("TKB");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                for (int i = 0; i<array.length(); i++){
                    JSONObject obj = array.getJSONObject(i);

                    ThoiKhoaBieu tkb = new ThoiKhoaBieu(obj.getInt("Thu")
                            ,obj.getString("TenHP"),obj.getString("MaLHP"), obj.getInt("TuTiet")
                            ,obj.getInt("DenTiet"),obj.getString("GiaoVien"), sdf2.format(sdf.parse(obj.getString("NgayHL")))
                            ,obj.getString("GhiChu"), obj.getString("Phong"));
                    switch (obj.getInt("Thu")){
                        case 2: tkb2.add(tkb); break;
                        case 3: tkb3.add(tkb); break;
                        case 4: tkb4.add(tkb); break;
                        case 5: tkb5.add(tkb); break;
                        case 6: tkb6.add(tkb); break;
                        case 7: tkb7.add(tkb); break;
                    }
                }
                loadListView();
            } catch (Exception e) {

            }
        }
    }
}
