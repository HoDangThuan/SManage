package srt.studentmanage.ui.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import srt.studentmanage.R;
import srt.studentmanage.common.Constances;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.common.Until;
import srt.studentmanage.model.objects.SinhVien;
import srt.studentmanage.ui.intalize.BaseActivity;

public class MainActivity extends BaseActivity {


    ImageButton btnXemTKB,btnXemDiem, btnXemTinDaoTao,btnDoiMatKhau, btnCapNhatNganHang,
            btnXemLichThi, btnXemThongTin, btnXemHocPhi, btnDangKyMonHoc,btnTB_LopCD,
            btnHocPhanChuaTichLuy;
    String masv;
    String pass;
    SinhVien currentSV=null;
    Dialog dialog;
    Menu menu;

    public static final String PASS = "pass";
    public static final String MASV= "masv";
    public static final int REQUEST_CODE_INPUT=113;
    public static final int RESULT_CODE=115;

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        btnXemTKB= (ImageButton) findViewById(R.id.btnXemTKB);
        btnXemDiem= (ImageButton) findViewById(R.id.btnXemDiem);
        btnXemTinDaoTao =(ImageButton) findViewById(R.id.btnXemTinDaoTao);
        btnCapNhatNganHang = (ImageButton) findViewById(R.id.btnCapNhatNganHang);
        btnXemLichThi = (ImageButton) findViewById(R.id.btnXemLichThi);
        btnDoiMatKhau= (ImageButton) findViewById(R.id.btnDoiMatKhau);
        btnXemThongTin= (ImageButton) findViewById(R.id.btnXemThongTin);
        btnXemHocPhi= (ImageButton) findViewById(R.id.btnXemHocPhi);
        btnDangKyMonHoc= (ImageButton) findViewById(R.id.btnDangKyMonHoc);
        btnTB_LopCD= (ImageButton) findViewById(R.id.btnTB_LopCD);
        btnHocPhanChuaTichLuy= (ImageButton) findViewById(R.id.btnHocPhanChuaTichLuy);
    }
//151250533269
    @Override
    protected void main() {
        btnXemTKB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSV==null){
                    Until.showAlertDialog(MainActivity.this,"Chưa đăng nhập");
                    return;
                }
                Intent intent = new Intent(MainActivity.this,XemThoiKhoaBieuActivity.class);
                intent.putExtra(MASV,currentSV.getMaSV());
                openActivity(intent,false);
                overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
            }
        });

        btnXemDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSV == null) {
                    Until.showAlertDialog(MainActivity.this, "Chưa đăng nhập");
                    return;
                }
                Intent intent = new Intent(MainActivity.this, XemDiemActivity.class);
                intent.putExtra(MASV, currentSV.getMaSV());
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2, R.anim.animation_activity_1);
            }
        });
        btnXemTinDaoTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, XemTinDaoTaoActivity.class);
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2, R.anim.animation_activity_1);
            }
        });
        btnTB_LopCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, XemThongBaoLopCDActivity.class);
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2, R.anim.animation_activity_1);
            }
        });
        btnDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSV == null) {
                    Until.showAlertDialog(MainActivity.this, "Chưa đăng nhập");
                    return;
                }
                Intent intent = new Intent(MainActivity.this, DoiMatKhauActivity.class);
                intent.putExtra(MASV, currentSV.getMaSV());
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2, R.anim.animation_activity_1);
            }
        });
        btnCapNhatNganHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSV == null) {
                    Until.showAlertDialog(MainActivity.this, "Chưa đăng nhập");
                    return;
                }
                Intent intent = new Intent(MainActivity.this, CapNhatTkNganHangActivity.class);
                intent.putExtra(MASV, currentSV.getMaSV());
                intent.putExtra(PASS, currentSV.getPass());
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2, R.anim.animation_activity_1);
            }
        });
        btnXemThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSV == null) {
                    Until.showAlertDialog(MainActivity.this, "Chưa đăng nhập");
                    return;
                }
                Intent intent = new Intent(MainActivity.this, CapNhatTTCaNhanActivity.class);
                intent.putExtra(PASS, currentSV.getPass());
                intent.putExtra(MASV, currentSV.getMaSV());
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2, R.anim.animation_activity_1);
            }
        });
        btnXemHocPhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (currentSV == null) {
                Until.showAlertDialog(MainActivity.this, "Chưa đăng nhập");
                return;
            }
            Intent intent = new Intent(MainActivity.this, XemHocPhiActivity.class);
            intent.putExtra(MASV, currentSV.getMaSV());
            openActivity(intent, false);
            overridePendingTransition(R.anim.animation_activity_2, R.anim.animation_activity_1);
            }
        });
        btnXemLichThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSV == null) {
                    Until.showAlertDialog(MainActivity.this, "Chưa đăng nhập");
                    return;
                }
                Intent intent = new Intent(MainActivity.this, XemLichThiActivity.class);
                intent.putExtra(MASV, currentSV.getMaSV());
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2, R.anim.animation_activity_1);
            }
        });
        btnHocPhanChuaTichLuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSV == null) {
                    Until.showAlertDialog(MainActivity.this, "Chưa đăng nhập");
                    return;
                }
                Intent intent = new Intent(MainActivity.this, XemHPCTLActivity.class);
                intent.putExtra(MASV, currentSV.getMaSV());
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2, R.anim.animation_activity_1);
            }
        });
        btnDangKyMonHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSV == null) {
                    Until.showAlertDialog(MainActivity.this, "Chưa đăng nhập");
                    return;
                }
                Intent intent = new Intent(MainActivity.this, DangKyMonHocActivity.class);
                intent.putExtra(MASV, currentSV.getMaSV());
                openActivity(intent, false);
                overridePendingTransition(R.anim.animation_activity_2, R.anim.animation_activity_1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnLogin:
                if (item.getTitle().equals("Đăng nhập")) dialogLogin();
                else logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void  logout(){
        currentSV=null;
        setTitle("");
        Toast.makeText(getBaseContext(),"Đăng xuất thành công!",Toast.LENGTH_LONG).show();
        MenuItem loginMenuItem = menu.findItem(R.id.mnLogin);
        loginMenuItem.setTitle("Đăng nhập");
        loginMenuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
    }
    private void dialogLogin(){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_login);
        final EditText editName = (EditText) dialog.findViewById(R.id.editAccount);
        final EditText editPass = (EditText) dialog.findViewById(R.id.editPassword);
        Button btnCancer = (Button) dialog.findViewById(R.id.btnCancer);
        Button btnLogin = (Button) dialog.findViewById(R.id.btnLogin);
        btnCancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                masv= editName.getText().toString();
                pass = editPass.getText().toString();
                LoginAsyncTask loginAsyncTask= new LoginAsyncTask();
                loginAsyncTask.execute(Constances.URLService+"sinhvien");

            }
        });
        dialog.show();
    }

    private class  LoginAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            RestClient client = new RestClient(params[0]);
            client.AddParam("masv", masv);
            client.AddParam("pass",pass);
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
            if (s.isEmpty()){
                Toast.makeText(getBaseContext(),"Tài khoản không đúng!",Toast.LENGTH_LONG).show();
                return;
            }
            JSONObject object = null;
            try {
                object = new JSONObject(s);
                currentSV = new SinhVien(masv,pass);
                Toast.makeText(getBaseContext(),"Đăng nhập thành công!",Toast.LENGTH_LONG).show();
                setTitle(object.getString("HoTen"));
                dialog.dismiss();
                MenuItem loginMenuItem = menu.findItem(R.id.mnLogin);
                loginMenuItem.setTitle("Đăng xuất");
                loginMenuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
            } catch (JSONException e) {
                Toast.makeText(getBaseContext(),"Tài khoản không đúng!",Toast.LENGTH_LONG).show();
            }

        }
    }
}
