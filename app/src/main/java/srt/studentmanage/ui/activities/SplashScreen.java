package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import srt.studentmanage.R;
import srt.studentmanage.ui.intalize.BaseActivity;

public class SplashScreen extends BaseActivity {

    private ProgressBar myProgessBar;
    private int mProgressStatus = 0;
    private final int timeSleep = 150;
    private Handler handler = new Handler();

    @Override
    protected int getLayout() {
        return R.layout.activity_splash_screen;
    }

    @Override
    protected void initViews() {
        myProgessBar = (ProgressBar) findViewById(R.id.progressBar1);
    }

    @Override
    protected void main() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100) {
                    mProgressStatus += 10;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myProgessBar.setProgress(mProgressStatus);
                        }
                    });
                    try {
                        Thread.sleep(timeSleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                openActivity(new Intent(getApplicationContext(),MainActivity.class),true);
            }
        }).start();

    }
}
