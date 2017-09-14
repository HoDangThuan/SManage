package srt.studentmanage.ui.activities;

import android.widget.ListView;

import java.util.ArrayList;

import srt.studentmanage.R;
import srt.studentmanage.adapter.TinDaoTaoAdapter;
import srt.studentmanage.model.objects.TinDaoTao;
import srt.studentmanage.ui.intalize.BaseActivity;

public class XemTinDaoTaoActivity extends BaseActivity {
    ListView lvTinDaoTao;
    ArrayList<TinDaoTao> dsTinDaoTao;
    @Override
    protected int getLayout() {
        return R.layout.activity_xem_tin_dao_tao;
    }

    @Override
    protected void initViews() {
        loadData();
        loadListView();
    }
    void loadData(){
        dsTinDaoTao= new ArrayList<>();
        for(int i = 0; i<= 10; i++){
            TinDaoTao tdt = new TinDaoTao(1,"Thông báo nghỉ học tránh bão"
                    ,"Tất cả sinh viên toàn trường được nghỉ để tránh cơn bão số 10 đổ bộ vào miền Trung.","Nguyễn Văn Lành");
            dsTinDaoTao.add(tdt);
        }
    }
    void loadListView(){
        lvTinDaoTao = (ListView) findViewById(R.id.lvTinDaoTao);
        TinDaoTaoAdapter adapter = new TinDaoTaoAdapter(this, R.layout.item_lv_tin_dao_tao,dsTinDaoTao);
        adapter.notifyDataSetChanged();
        lvTinDaoTao.setAdapter(adapter);

    }
    @Override
    protected void main() {

    }
}
