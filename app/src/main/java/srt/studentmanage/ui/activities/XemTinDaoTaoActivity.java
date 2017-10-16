package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import srt.studentmanage.R;
import srt.studentmanage.adapter.TinDaoTaoAdapter;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.model.objects.SinhVien;
import srt.studentmanage.model.objects.TinDaoTao;
import srt.studentmanage.ui.intalize.BaseActivity;

public class XemTinDaoTaoActivity extends BaseActivity {
    ListView lvTinDaoTao;
    ArrayList<TinDaoTao> dsTinDaoTao=new ArrayList<TinDaoTao>();
    TinDaoTaoAdapter adapter;
    @Override
    protected int getLayout() {
        return R.layout.activity_xem_tin_dao_tao;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadListView();
    }
    void loadListView(){
        lvTinDaoTao = (ListView) findViewById(R.id.lvTinDaoTao);
        adapter = new TinDaoTaoAdapter(this, R.layout.item_lv_tin_dao_tao,dsTinDaoTao);
        adapter.notifyDataSetChanged();
        lvTinDaoTao.setAdapter(adapter);

        HttpAsyncTask httpAsyncTask=new HttpAsyncTask();
        httpAsyncTask.execute("http://192.168.1.234/smanage/api/tindaotao");
    }
    @Override
    protected void main() {
        lvTinDaoTao.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), ChiTietDaoTaoActivity.class);
                Bundle thongTin = new Bundle();
                thongTin.putSerializable("tindaotao", dsTinDaoTao.get(i));
                intent.putExtra("bundle",thongTin);
                openActivity(intent,false);

//                Toast.makeText(getApplicationContext(),"Vị trí", Toast.LENGTH_LONG).show();
            }
        });


    }

    private class  HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            RestClient client = new RestClient(params[0]);
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
            s = s.substring(1, s.length() - 1);
            dsTinDaoTao.clear();
            try {
                JSONArray arr = new JSONArray(s);
                for (int i=0;i<arr.length();i++){
                    JSONObject o=arr.getJSONObject(i);
                    TinDaoTao t= new TinDaoTao(o.getInt("MaTin"),o.getString("TieuDe"), o.getString("NoiDung"),
                            o.getString("Author"));
                    dsTinDaoTao.add(t);
                }
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            adapter.notifyDataSetChanged();

        }
    }
}
