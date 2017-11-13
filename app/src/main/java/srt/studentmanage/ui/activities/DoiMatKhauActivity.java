package srt.studentmanage.ui.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.InputStream;

import srt.studentmanage.R;
import srt.studentmanage.common.WebService;
import srt.studentmanage.model.objects.SinhVien;
import srt.studentmanage.ui.intalize.BaseActivity;

public class DoiMatKhauActivity extends BaseActivity {

    private Button btnCapNhat;
    private TextView txtMK_Cu,txtMK_Moi,txtNhapLai,txtThongBao;

    @Override
    protected int getLayout() {
        return R.layout.activity_doi_mat_khau;
    }

    @Override
    protected void initViews() {
        btnCapNhat= (Button) findViewById(R.id.btnCapNhat);
        txtMK_Cu= (TextView) findViewById(R.id.txtMK_Cu);
        txtMK_Moi= (TextView) findViewById(R.id.txtMK_Moi);
        txtNhapLai= (TextView) findViewById(R.id.txtNhapLai);
        txtThongBao= (TextView) findViewById(R.id.txtThongBao);
    }
    @Override
    protected void main() {
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyCapNhat();
            }


        });
    }
    private void xuLyCapNhat() {
        String mkNhapLai= (String) txtNhapLai.getText().toString();
        String mkMoi= (String) txtMK_Moi.getText().toString();
        if(mkMoi.length()<3 || mkMoi.length()>10 || mkNhapLai.length()<5 ||mkNhapLai.length()>10 ){
            txtThongBao.setText("Mật khẩu phải lớn hơn 3 và ít hơn 10 ký tự ");
        }
        else
        if(mkNhapLai.equals(mkMoi)){
//            HttpAsyncTask httpAsyncTask=new HttpAsyncTask();
//            httpAsyncTask.execute("http://192.168.1.234/smanage/api/sinhvien",txtMK_Cu.getText().toString(),txtMK_Moi.getText().toString());
        }
        else{
            txtThongBao.setText("Nhập lại mật khẩu không chính xác");
        }



    }

    private class  HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            InputStream inputStream = null;
            String result = "";

            try {
                // 1. create HttpClient
                HttpClient httpclient = new DefaultHttpClient();
                HttpPut httpPUT = new
                        HttpPut(params[0]);
                String json = "";
                // 3. build jsonObject
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("masv", "151250533269");
                jsonObject.put("oldpass",params[1]);
                jsonObject.put("newpass",params[2]);

                json = jsonObject.toString();
                StringEntity se = new StringEntity(json);
                httpPUT.setEntity(se);
                httpPUT.setHeader("Accept", "application/json");
                httpPUT.setHeader("Content-type", "application/json");
                HttpResponse httpResponse = httpclient.execute(httpPUT);
                inputStream = httpResponse.getEntity().getContent();
                result = WebService.convertInputStreamToString(inputStream);
            } catch (Exception e) {
                Log.d("InputStream", e.getLocalizedMessage());
            }
            return  result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getBaseContext(),s,Toast.LENGTH_LONG).show();
        }
    }
}
