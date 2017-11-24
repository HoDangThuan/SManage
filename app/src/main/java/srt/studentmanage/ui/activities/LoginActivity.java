package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import srt.studentmanage.R;
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
        openActivity(new Intent(LoginActivity.this,MainActivity.class),true);
        overridePendingTransition(R.anim.animation_activity_2,R.anim.animation_activity_1);
    }

}
