package srt.studentmanage.ui.intalize;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Admin on 08/21/2017.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayout();

    protected abstract void initViews();

    protected abstract void main();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initViews();
        main();
    }
    

    protected void openActivity(Intent intent, boolean finish){

        startActivity(intent);
        if (finish){
            finish();

        }
        //overridePendingTransition();
    }
}
