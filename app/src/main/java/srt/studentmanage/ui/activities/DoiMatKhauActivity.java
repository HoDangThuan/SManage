package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import srt.studentmanage.R;
import srt.studentmanage.common.Constances;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.ui.intalize.BaseActivity;

public class DoiMatKhauActivity extends BaseActivity {

    private Button btnCapNhat;
    private TextView edit_Mk_Cu,edit_Mk_Moi,edit_Mk_Nhap_Lai,txtThongBao;
    String masv;

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_doi_mat_khau;
    }

    @Override
    protected void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnCapNhat= (Button) findViewById(R.id.btnCapNhat);
        edit_Mk_Cu= (TextView) findViewById(R.id.edit_Mk_Cu);
        edit_Mk_Moi= (TextView) findViewById(R.id.edit_Mk_Moi);
        edit_Mk_Nhap_Lai= (TextView) findViewById(R.id.edit_Mk_Nhap_Lai);
        txtThongBao= (TextView) findViewById(R.id.txtThongBao);
    }
    @Override
    protected void main() {
        Intent intent = getIntent();
        masv = intent.getStringExtra(MainActivity.MASV);
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyCapNhat();
            }


        });
    }
    private void xuLyCapNhat() {
        String mkCu = edit_Mk_Cu.getText().toString();
        String mkNhapLai= edit_Mk_Nhap_Lai.getText().toString();
        String mkMoi= edit_Mk_Moi.getText().toString();
        if(mkMoi.length()<3 || mkMoi.length()>10 ){
            txtThongBao.setText("Mật khẩu phải lớn hơn 3 và ít hơn 10 ký tự ");
        }
        else
        if(mkNhapLai.equals(mkMoi)){
            (new HttpAsyncTask()).execute(mkCu,mkMoi);
        }
        else{
            txtThongBao.setText("Nhập lại mật khẩu không chính xác");
        }
    }

    private class  HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            RestClient client = new RestClient(Constances.URLService+"sinhvien");
            client.AddParam("masv", masv);
            client.AddParam("oldpass",params[0]);
            client.AddParam("newpass", params[1]);
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
                edit_Mk_Moi.setText("");
                edit_Mk_Nhap_Lai.setText("");
                edit_Mk_Cu.setText("");
                txtThongBao.setText("Thay đổi mật khẩu thành công!");
            }
            else
                txtThongBao.setText("Thay đổi mật khẩu thất bại!");
        }
    }
}
