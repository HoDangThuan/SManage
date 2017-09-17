package srt.studentmanage.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import srt.studentmanage.R;

public class DoiMatKhauActivity extends AppCompatActivity {

    private Button btnCapNhat;
    private TextView txtMK_Cu,txtMK_Moi,txtNhapLai,txtThongBao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);

        addControl();
        addEvent();
    }

    private void addEvent(){
       btnCapNhat.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               xuLyCapNhat();
           }

           private void xuLyCapNhat() {
               String mkNhapLai= (String) txtNhapLai.getText().toString();
               String mkMoi= (String) txtMK_Moi.getText().toString();
               if(mkMoi.length()<5 || mkMoi.length()>10 || mkNhapLai.length()<5 ||mkNhapLai.length()>10 ){
                   txtThongBao.setText("Mật khẩu phải lớn hơn 5 và ít hơn 10 ký tự ");
               }
               else
                    if(mkNhapLai.equals(mkMoi)){
                        txtThongBao.setText(" ");
                    }
                    else{
                        txtThongBao.setText("Nhập lại mật khẩu không chính xác");
                    }

           }
       });
    }



    private void addControl() {
        btnCapNhat= (Button) findViewById(R.id.btnCapNhat);
        txtMK_Cu= (TextView) findViewById(R.id.txtMK_Cu);
        txtMK_Moi= (TextView) findViewById(R.id.txtMK_Moi);
        txtNhapLai= (TextView) findViewById(R.id.txtNhapLai);
        txtThongBao= (TextView) findViewById(R.id.txtThongBao);
    }
}
