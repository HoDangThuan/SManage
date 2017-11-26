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

public class CapNhatTTCaNhanActivity extends BaseActivity {

    TextView txtCMND, txtATM, txtMaSV, txtHoTen, txtNgaySinh;
    EditText editNoiSinh, editDiaChi, editSoDT, editMobile, editEmail;
    String masv,pass;
    Button btnCapNhatTT;
    @Override
    protected int getLayout() {
        return R.layout.activity_cap_nhat_ttca_nhan;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtCMND = (TextView) findViewById(R.id.txtCMND);
        txtATM = (TextView) findViewById(R.id.txtATM);
        txtMaSV = (TextView) findViewById(R.id.txtMaSV);
        txtHoTen = (TextView) findViewById(R.id.txtHoTen);
        txtNgaySinh = (TextView) findViewById(R.id.txtNgaySinh);
        editNoiSinh = (EditText) findViewById(R.id.txtNoiSinh);
        editDiaChi = (EditText) findViewById(R.id.txtDiaChi);
        editMobile = (EditText) findViewById(R.id.txtMobile);
        editSoDT = (EditText) findViewById(R.id.txtSoDT);
        editEmail = (EditText) findViewById(R.id.txtEmail);
        btnCapNhatTT = (Button) findViewById(R.id.btnCapNhatTT);
        Intent intent = getIntent();
        masv = intent.getStringExtra(MainActivity.MASV);
        pass = intent.getStringExtra(MainActivity.PASS);

        txtMaSV.setText(masv);
        HttpAsyncTask httpAsyncTask= new HttpAsyncTask();
        httpAsyncTask.execute();
    }

    @Override
    protected void main() {
        btnCapNhatTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noiSinh = editNoiSinh.getText().toString();
                String diaChi = editDiaChi.getText().toString();
                String sdt = editSoDT.getText().toString();
                String email = editEmail.getText().toString();
                String mobile = editMobile.getText().toString();
                CapNhatTTAsyncTask asyncTask = new CapNhatTTAsyncTask();
                asyncTask.execute(noiSinh,diaChi,sdt,email,mobile);
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
                JSONObject object = new JSONObject(s);
                txtCMND.setText(object.getString("CMND"));
                String txtDate= object.getString("NgaySinh");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                Date date = sdf.parse(txtDate);
                txtNgaySinh.setText(sdf2.format(date));
                editNoiSinh.setText(object.getString("NoiSinh"));
                editDiaChi.setText(object.getString("DiaChi"));
                txtATM.setText(object.getString("ATM"));
                txtHoTen.setText(object.getString("HoTen"));
                editEmail.setText(object.getString("Email"));
                editMobile.setText(object.getString("Mobile"));
                editSoDT.setText(object.getString("SDT"));
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


    }

    private class  CapNhatTTAsyncTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {

            RestClient client = new RestClient(Constances.URLService+"sinhvien");
            client.AddParam("masv", masv);
            client.AddParam("pass", pass);
            client.AddParam("noisinh", params[0]);
            client.AddParam("diachi", params[1]);
            client.AddParam("sdt", params[2]);
            client.AddParam("email", params[3]);
            client.AddParam("mobile", params[4]);
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
