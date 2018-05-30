package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import srt.studentmanage.R;
import srt.studentmanage.adapter.HocPhanChuaTLAdapter;
import srt.studentmanage.common.Constances;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.model.objects.HocPhanChuaTL;
import srt.studentmanage.ui.intalize.BaseActivity;

public class XemHPCTLActivity extends BaseActivity {

    ListView lvHPCTL;
    private String masv;
    ArrayList<HocPhanChuaTL> dsHPCTL= new ArrayList<>();
    HocPhanChuaTLAdapter hpCTLAdapter;
    TextView txtMaSV,txtTenSV,txtTenNganh;


    private void loadListView() {
        hpCTLAdapter=new HocPhanChuaTLAdapter(this,R.layout.item_lv_hocphan_chuatichluy,dsHPCTL);
        lvHPCTL.setAdapter(hpCTLAdapter);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected int getLayout() {
        return R.layout.activity_xem_hocphan_chuatichluy;
    }

    @Override
    protected void initViews() {
        txtMaSV = (TextView) findViewById(R.id.txtMaSV);
        txtTenSV = (TextView) findViewById(R.id.txtTenSV);
        txtTenNganh = (TextView) findViewById(R.id.txtTenNganh);
        Intent intent = getIntent();
        masv = intent.getStringExtra(MainActivity.MASV);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvHPCTL= (ListView) findViewById(R.id.lvHPCTL);

        XemHPCTLAsyncTask asyncTask = new XemHPCTLAsyncTask();
        asyncTask.execute();
        loadListView();
    }

    @Override
    protected void main() {
        loadListView();
    }

    private class  XemHPCTLAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            RestClient client = new RestClient(Constances.URLService+"sinhvien");
            client.AddParam("masvHPCTL", masv);
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
                JSONObject object=new JSONObject(s);
                txtMaSV.setText(masv);
                txtTenSV.setText(object.getString("tenSV"));
                txtTenNganh.setText(object.getString("tenNganh"));

                JSONArray array=object.getJSONArray("arrHP");
                JSONObject ob;
                for(int i=0;i<array.length();i++) {
                    ob=array.getJSONObject(i);
                    dsHPCTL.add(new HocPhanChuaTL(
                            ob.getString("maHP"),
                            ob.getString("tenHP"),
                            ob.getString("soTC"),
                            ob.getString("loaiHP"),
                            ob.getString("ghiChu_maLHP")
                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}