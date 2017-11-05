package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import srt.studentmanage.R;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.common.WebService;
import srt.studentmanage.model.objects.SinhVien;
import srt.studentmanage.ui.intalize.BaseActivity;

public class CapNhatTTCaNhanActivity extends BaseActivity {

    TextView txtCMND, txtATM, txtMaSV, txtHoTen;
    EditText txtNoiSinh, txtDiaChi, txtSoDT, txtMobile, txtEmail;
    @Override
    protected int getLayout() {
        return R.layout.activity_cap_nhat_ttca_nhan;
    }

    @Override
    protected void initViews() {
        txtCMND = (TextView) findViewById(R.id.txtCMND);
        txtATM = (TextView) findViewById(R.id.txtATM);
        txtMaSV = (TextView) findViewById(R.id.txtMaSV);
        txtHoTen = (TextView) findViewById(R.id.txtHoTen);

        txtNoiSinh = (EditText) findViewById(R.id.txtNoiSinh);
        txtDiaChi = (EditText) findViewById(R.id.txtDiaChi);
        txtMobile = (EditText) findViewById(R.id.txtMobile);
        txtSoDT = (EditText) findViewById(R.id.txtSoDT);
        txtEmail = (EditText) findViewById(R.id.txtEmail);

        txtMaSV.setText(SinhVien.currentSV);
        HttpAsyncTask httpAsyncTask= new HttpAsyncTask();
        httpAsyncTask.execute(WebService.URL+"sinhvien");
    }

    @Override
    protected void main() {

    }

    private class  HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            RestClient client = new RestClient(params[0]);
            client.AddParam("masv", SinhVien.currentSV);
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
                s=s.substring(1,s.length()-1);
                JSONObject object = new JSONObject(s);
                txtCMND.setText(object.getString("CMND"));
                txtNoiSinh.setText(object.getString("NoiSinh"));
                txtDiaChi.setText(object.getString("DiaChi"));
                txtATM.setText(object.getString("ATM"));
                txtHoTen.setText(object.getString("HoTen"));
                txtEmail.setText(object.getString("Email"));
                txtMobile.setText(object.getString("Mobile"));
                txtSoDT.setText(object.getString("SDT"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


}
