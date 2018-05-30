package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import srt.studentmanage.R;
import srt.studentmanage.adapter.LichThiAdapter;
import srt.studentmanage.common.Constances;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.model.objects.LichThi;
import srt.studentmanage.ui.intalize.BaseActivity;

public class XemLichThiActivity extends BaseActivity {

    ListView lvLichThi;
    private String masv;
    ArrayList<LichThi> dsLichThi=new ArrayList<>();
    LichThiAdapter lichThiAdapter;
    TextView txtMaSV,txtTenSV,txtTenNganh;


    private void loadListView() {
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
        txtMaSV = (TextView) findViewById(R.id.txtMaSV);
        txtTenSV = (TextView) findViewById(R.id.txtTenSV);
        txtTenNganh = (TextView) findViewById(R.id.txtTenNganh);
        Intent intent = getIntent();
        masv = intent.getStringExtra(MainActivity.MASV);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvLichThi= (ListView) findViewById(R.id.lvLichThi);

        XemLichThiAsyncTask asyncTask = new XemLichThiAsyncTask();
        asyncTask.execute();
        loadListView();
    }

    @Override
    protected void main() {
        loadListView();
    }

    private class  XemLichThiAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            RestClient client = new RestClient(Constances.URLService+"sinhvien");
            client.AddParam("masvLT", masv);
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
                JSONArray array=object.getJSONArray("lichThi");
                JSONObject ob;
                String txtDate;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                for(int i=0;i<array.length();i++) {
                    ob=array.getJSONObject(i);
                    txtDate= ob.getString("ngayThi");
                    Date date = sdf.parse(txtDate);
                    dsLichThi.add(new LichThi(
                            ob.getString("tenLHP"),
                            ob.getString("tenHP"),
                            ob.getString("tenGV"),
                            sdf2.format(date).toString(),
                            ob.getString("gioThi"),
                            ob.getString("phongThi")
                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}