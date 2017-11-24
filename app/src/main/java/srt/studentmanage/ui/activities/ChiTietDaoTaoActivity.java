package srt.studentmanage.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import srt.studentmanage.R;
import srt.studentmanage.model.objects.TinDaoTao;
import srt.studentmanage.ui.intalize.BaseActivity;

public class ChiTietDaoTaoActivity extends BaseActivity {

    TextView txtTieuDe,txtNoiDung, txtAuthor;
    @Override
    protected int getLayout() {
        return R.layout.activity_chi_tiet_dao_tao;
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtTieuDe= (TextView) findViewById(R.id.txtTieuDe);
        txtNoiDung= (TextView) findViewById(R.id.txtNoiDung);
        txtAuthor= (TextView) findViewById(R.id.txtAuthor);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        TinDaoTao t = (TinDaoTao) bundle.getSerializable("tindaotao");
        txtTieuDe.setText(t.getTieuDe());
        txtAuthor.setText(t.getTacGia());
        txtNoiDung.setText(t.getNoiDung());
    }

    @Override
    protected void main() {

    }

}
