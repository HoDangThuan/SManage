package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import srt.studentmanage.R;
import srt.studentmanage.adapter.PagerXemDiemAdapter;
import srt.studentmanage.common.Constances;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.model.objects.BangDiem;
import srt.studentmanage.model.objects.DiemHocKy;
import srt.studentmanage.model.objects.DiemHocPhan;
import srt.studentmanage.model.objects.KhenThuongKiLuat;
import srt.studentmanage.ui.intalize.BaseActivity;

public class XemDiemActivity extends BaseActivity {

    private ViewPager pager;
    private TabLayout tabLayout;
    private String masv;
    private BangDiem bangDiem;
    @Override
    protected int getLayout() {
        return R.layout.activity_xem_diem;
    }

    @Override
    protected void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        masv = intent.getStringExtra(MainActivity.MASV);
    }

    public BangDiem getBangDiem() {
        return bangDiem;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    protected void main() {
        XemDiemAsyncTask asyncTask = new XemDiemAsyncTask();
        asyncTask.execute();
    }

    private class  XemDiemAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            RestClient client = new RestClient(Constances.URLService+"sinhvien");
            client.AddParam("masvbd", masv);
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
                JSONObject root = new JSONObject(s);
                bangDiem = new BangDiem();
                bangDiem.setDiemTB(root.getDouble("DiemTB"));
                bangDiem.setSoTCTichLuy(root.getInt("SoTCTichLuy"));
                bangDiem.setXepHang(root.getString("XepHang"));

                JSONArray diemHocKies = root.getJSONArray("BangDiem");
                ArrayList<DiemHocKy> listDHK = new ArrayList<>();
                for (int i = 0; i<diemHocKies.length(); i++){
                    JSONObject diemHocKy = diemHocKies.getJSONObject(i);
                    DiemHocKy dhk = new DiemHocKy();
                    dhk.setMaHK(diemHocKy.getInt("HocKy"));
                    dhk.setSoTcDk(diemHocKy.getInt("SoTCDK"));
                    dhk.setDiemTB(diemHocKy.getDouble("DiemTB"));
                    try {
                        dhk.setDiemRL(diemHocKy.getDouble("DiemRL"));
                    }catch (JSONException e){
                        dhk.setDiemRL(-1);
                    }
                    dhk.setXepLoai(diemHocKy.getString("XepLoai"));
                    dhk.setGhiChu(diemHocKy.getString("GhiChu"));

                    JSONArray diems = diemHocKy.getJSONArray("Diem");
                    ArrayList<DiemHocPhan> listDiemHP = new ArrayList<>();
                    for (int j = 0; j<diems.length(); j++){
                        JSONObject diemHP = diems.getJSONObject(j);
                        DiemHocPhan dhp = new DiemHocPhan();
                        dhp.setMaHP(diemHP.getString("MaHP"));
                        dhp.setTenHP(diemHP.getString("TenHP"));
                        dhp.setSoTc(diemHP.getInt("SoTC"));
                        dhp.setGhiChu(diemHP.getString("GhiChu"));
                        dhp.setDiemSo(diemHP.getDouble("Diem"));
                        dhp.setDiemChu(diemHP.getString("DiemChu"));
                        dhp.setTichLuy(diemHP.getInt("TichLuy")==1?true:false);
                        listDiemHP.add(dhp);
                    }

                    dhk.setDiemHocPhan(listDiemHP);

                    JSONArray khenThuongKyLuats = diemHocKy.getJSONArray("KhenThuongKyLuat");
                    ArrayList<KhenThuongKiLuat> listKTKL = new ArrayList<>();
                    for (int t = 0; t< khenThuongKyLuats.length(); t++){
                        JSONObject khenThuongKyLuat = khenThuongKyLuats.getJSONObject(t);
                        KhenThuongKiLuat ktkl = new KhenThuongKiLuat();
                        ktkl.setMoTa(khenThuongKyLuat.getString("MoTa"));
                        ktkl.setMaHK(diemHocKy.getInt("HocKy"));
                        ktkl.setLoaiKT(khenThuongKyLuat.getString("LoaiKhenThuong"));
                        listKTKL.add(ktkl);
                    }

                    dhk.setKhenThuongKiLuats(listKTKL);

                    listDHK.add(dhk);
                }
                bangDiem.setDiemHocKies(listDHK);
                pager = (ViewPager) findViewById(R.id.view_pager);
                tabLayout = (TabLayout) findViewById(R.id.tab_layout);
                FragmentManager manager = getSupportFragmentManager();
                PagerXemDiemAdapter adapter = new PagerXemDiemAdapter(manager);
                pager.setAdapter(adapter);
                tabLayout.setupWithViewPager(pager);
                pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                tabLayout.setTabsFromPagerAdapter(adapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
