package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import srt.studentmanage.R;
import srt.studentmanage.adapter.DangKyMonHocAdapter;
import srt.studentmanage.common.Constances;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.model.objects.DangKyMonHoc;
import srt.studentmanage.ui.intalize.BaseActivity;

public class DangKyMonHocActivity extends BaseActivity {

    ListView lvDKMH;
    private String masv;
    ArrayList<DangKyMonHoc> dsDKMH=new ArrayList<>();
    ArrayList<String> dsMaLHP=new ArrayList<>();
    ArrayList<DangKyMonHoc> dsDangKyMonHoc=new ArrayList<>();
    DangKyMonHocAdapter dkmhAdapter;
    Button btnXacNhanDangKy;
    TextView txtMaSV,txtTenSV,txtTenNganh;


    private void loadListView() {
        dkmhAdapter=new DangKyMonHocAdapter(this,R.layout.item_lv_dang_ky_mon_hoc,dsDangKyMonHoc);
        lvDKMH.setAdapter(dkmhAdapter);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected int getLayout() {
        return R.layout.activity_dang_ky_mon_hoc;
    }

    @Override
    protected void initViews() {

        txtMaSV = (TextView) findViewById(R.id.txtMaSV);
        txtTenSV = (TextView) findViewById(R.id.txtTenSV);
        txtTenNganh = (TextView) findViewById(R.id.txtTenNganh);
        btnXacNhanDangKy=(Button) findViewById(R.id.btnXacNhanDangKy);
        Intent intent = getIntent();
        masv = intent.getStringExtra(MainActivity.MASV);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvDKMH= (ListView) findViewById(R.id.lvDKMH);

        DangKyMonHocAsyncTask asyncTask = new DangKyMonHocAsyncTask();
        asyncTask.execute();
        loadListView();
    }

    @Override
    protected void main() {
        loadListView();
        btnXacNhanDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<lvDKMH.getAdapter().getCount();i++)
                    if(((DangKyMonHoc) lvDKMH.getItemAtPosition(i)).isCheckBox()) {
                        dsDKMH.add((DangKyMonHoc) lvDKMH.getItemAtPosition(i));
                        dsMaLHP.add(((DangKyMonHoc) lvDKMH.getItemAtPosition(i)).getTenLHP());
                    }
                int kiemtra=0;
                if(dsDKMH.size()>1)
                    for(int j=0;j<dsDKMH.size();j++)
                        for(int k=j+1;k<dsDKMH.size();k++) {
                            if (dsDKMH.get(j).getThu() == dsDKMH.get(k).getThu() && dsDKMH.get(j).getTutiet() == dsDKMH.get(k).getTutiet())
                                kiemtra = 1;
                            if(dsDKMH.get(j).getMaHP().equals(dsDKMH.get(k).getMaHP()))
                                kiemtra = 1;
                        }
                if(kiemtra==0) {
                    ThucHienDangKyMonHocAsyncTask asyncTask = new ThucHienDangKyMonHocAsyncTask();
                    asyncTask.execute(dsMaLHP.toString());
                }else {
                    Toast.makeText(getBaseContext(), "Trùng TKB, trùng Học Phần!" + dsMaLHP.toString(), Toast.LENGTH_LONG).show();
                    dsDKMH.clear();
                    dsMaLHP.clear();
                }
            }
        });
    }

    private class  DangKyMonHocAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            RestClient client = new RestClient(Constances.URLService+"sinhvien");
            client.AddParam("masvMonHocDK", masv);
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
                JSONArray array=object.getJSONArray("arrMonHoc");
                JSONObject ob;
                String txtDate;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                for(int i=0;i<array.length();i++) {
                    ob=array.getJSONObject(i);
                    txtDate= ob.getString("ngayHieuLuc");
                    Date date = sdf.parse(txtDate);
                    dsDangKyMonHoc.add(new DangKyMonHoc(
                            ob.getString("maHP"),
                            ob.getString("tenHP"),
                            ob.getString("tenLHP"),
                            sdf2.format(date).toString(),
                            ob.getString("giaoVien"),
                            ob.getInt("soTC"),
                            ob.getInt("thu"),
                            ob.getInt("tuTiet"),
                            ob.getInt("denTiet"),
                            ob.getInt("soLuong"),
                            ob.getInt("soDK")
                    ));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private class  ThucHienDangKyMonHocAsyncTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {

            RestClient client = new RestClient(Constances.URLService+"sinhvien");
            client.AddParam("masv", masv);
            client.AddParam("arrMaLHP", params[0]);
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
            if (s.equals("true")){
                Toast.makeText(getBaseContext(),"Đăng ký môn học thành công!"+dsMaLHP.toString(), Toast.LENGTH_LONG).show();
                dsDKMH.clear();
                dsMaLHP.clear();
            }
            else {
                Toast.makeText(getBaseContext(), "Đăng ký thất bại, đảm bảo môn học chưa đăng ký và không trùng TKB!", Toast.LENGTH_LONG).show();
                dsDKMH.clear();
                dsMaLHP.clear();
            }
        }
    }

}