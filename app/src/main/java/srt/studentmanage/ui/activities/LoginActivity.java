package srt.studentmanage.ui.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import srt.studentmanage.R;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.model.objects.SinhVien;
import srt.studentmanage.ui.intalize.BaseActivity;

public class LoginActivity extends BaseActivity {

    private LinearLayout loginLayout;
    private ImageView imgLogo;
    private Button btnLogin;
    EditText txtMaSV,txtPass;
    String pass, masv;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        imgLogo= (ImageView) findViewById(R.id.imgLogo);
        loginLayout= (LinearLayout) findViewById(R.id.loginLayout);
        btnLogin= (Button) findViewById(R.id.btnLogin);
        txtMaSV= (EditText) findViewById(R.id.txtMaSV);
        txtPass= (EditText) findViewById(R.id.txtPass);
    }

    @Override
    protected void main() {
        Animation translate= AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.translatelogo);
        imgLogo.startAnimation(translate);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        masv= txtMaSV.getText().toString();
        pass = txtPass.getText().toString();
        LoginAsyncTask loginAsyncTask= new LoginAsyncTask();
        loginAsyncTask.execute("http://192.168.1.234/smanage/api/sinhvien");

//        openActivity(new Intent(LoginActivity.this,MainActivity.class),true);
//        overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
    }

    private void showDialog(String msg){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(msg);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
    }
    private class  LoginAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            RestClient client = new RestClient(params[0]);
            client.AddParam("masv", masv);
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
                String p=object.getString("Pass");
                if (p.equals(pass)){
                    SinhVien sv=new SinhVien();
                    sv.setMaSV(masv);
                    sv.setHoTen(object.getString("HoTen"));
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("SV",sv);
                    intent.putExtra("bundle",bundle);
                    SinhVien.currentSV=masv;
                    openActivity(intent,true);
                    overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
                }else{
                    Toast.makeText(getBaseContext(),"Tai khoan khong dung!",Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
