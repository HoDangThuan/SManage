package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import srt.studentmanage.R;
import srt.studentmanage.common.Constances;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.ui.intalize.BaseActivity;

public class CapNhatTkNganHangActivity extends BaseActivity {

    TextView txtMaSV, txtTenSV, txtNgaySinh, txtNoiSinh, txtDiaChi, txtSDT,txtEmail,txtCMND,txtMobile;
    EditText etxtSTK;
    String masv,pass;
    Button btnCapNhat;
    @Override
    protected int getLayout() {
        return R.layout.activity_cap_nhat_tk_ngan_hang;
    }

    @Override
    protected void initViews() {

        txtMaSV = (TextView) findViewById(R.id.txtMaSV);
        txtTenSV = (TextView) findViewById(R.id.txtTenSV);
        txtNgaySinh = (TextView) findViewById(R.id.txtNgaySinh);
        txtNoiSinh = (TextView) findViewById(R.id.txtNoiSinh);
        txtDiaChi = (TextView) findViewById(R.id.txtDiaChi);
        txtSDT = (TextView) findViewById(R.id.txtSDT);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtCMND = (TextView) findViewById(R.id.txtCMND);
        txtMobile = (TextView) findViewById(R.id.txtMobile);
        etxtSTK = (EditText) findViewById(R.id.etxtSTK);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        Intent intent = getIntent();
        masv = intent.getStringExtra(MainActivity.MASV);
        pass = intent.getStringExtra(MainActivity.PASS);
        HttpAsyncTask httpAsyncTask= new HttpAsyncTask();
        httpAsyncTask.execute();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void main() {
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stk = etxtSTK.getText().toString();
                CapNhatSTKAsyncTask asyncTask = new CapNhatSTKAsyncTask();
                asyncTask.execute(stk);
            }
        });

    }

    private class  HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            RestClient client = new RestClient(Constances.URLService+"sinhvien");
            client.AddParam("masv", masv);
            client.AddParam("pass", pass);
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
                txtMaSV.setText(masv);
                JSONObject object = new JSONObject(s);
                txtCMND.setText(object.getString("CMND"));
                String txtDate= object.getString("NgaySinh");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                Date date = sdf.parse(txtDate);
                txtNgaySinh.setText(sdf2.format(date));
                txtNoiSinh.setText(object.getString("NoiSinh"));
                txtDiaChi.setText(object.getString("DiaChi"));
                etxtSTK.setText(object.getString("ATM"));
                txtTenSV.setText(object.getString("HoTen"));
                txtEmail.setText(object.getString("Email"));
                txtMobile.setText(object.getString("Mobile"));
                txtSDT.setText(object.getString("SDT"));
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private class  CapNhatSTKAsyncTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {

            RestClient client = new RestClient(Constances.URLService+"sinhvien");
            client.AddParam("masv", masv);
            client.AddParam("pass", pass);
            client.AddParam("stk", params[0]);
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
                Toast.makeText(getBaseContext(),"Cập nhật thông tin thành công!", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(getBaseContext(),"Cập nhật thông tin thất bại, xin thử lại sau!", Toast.LENGTH_LONG).show();
        }
    }

}
