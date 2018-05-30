package srt.studentmanage.ui.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import srt.studentmanage.R;
import srt.studentmanage.common.Constances;
import srt.studentmanage.common.RestClient;
import srt.studentmanage.ui.intalize.BaseActivity;

public class XemHocPhiActivity extends BaseActivity {

    Spinner spnHocKyHP;
    ArrayList<Integer> dsHocKy = new ArrayList<>();
    private String masv;
    TextView txtMaHK,txtSoTinChi,txtHocPhiNop,txtBHYT,txtBHTT,
            txtDaNopTaiVu,txtDaNopTheATM,txtNgayCapNhat,txtChuThich,txtTongTien;

    @Override
    protected int getLayout() {
        return R.layout.activity_xem_hoc_phi;
    }

    @Override
    protected void initViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtMaHK = (TextView) findViewById(R.id.txtMaHK);
        txtSoTinChi = (TextView) findViewById(R.id.txtSoTinChi);
        txtHocPhiNop = (TextView) findViewById(R.id.txtHocPhiNop);
        txtBHYT = (TextView) findViewById(R.id.txtBHYT);
        txtBHTT = (TextView) findViewById(R.id.txtBHTT);
        txtDaNopTaiVu = (TextView) findViewById(R.id.txtDaNopTaiVu);
        txtDaNopTheATM = (TextView) findViewById(R.id.txtDaNopTheATM);
        txtNgayCapNhat = (TextView) findViewById(R.id.txtNgayCapNhat);
        txtChuThich = (TextView) findViewById(R.id.txtChuThich);
        txtTongTien = (TextView) findViewById(R.id.txtTongTien);

        spnHocKyHP= (Spinner) findViewById(R.id.spnHocKyHP);
        Intent intent = getIntent();
        masv = intent.getStringExtra(MainActivity.MASV);

        XemHocPhiAsyncTask asyncTask = new XemHocPhiAsyncTask();
        asyncTask.execute();
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void loadSpinner() {
        ArrayAdapter<Integer> hocKyAdapter=new ArrayAdapter<Integer>(XemHocPhiActivity.this,R.layout.spinner_item,dsHocKy);
        hocKyAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnHocKyHP.setAdapter(hocKyAdapter);
    }

    protected void main() {
    }

    private class  XemHocPhiAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            RestClient client = new RestClient(Constances.URLService+"sinhvien");
            client.AddParam("masvHP", masv);
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
                final JSONArray arrayHP = new JSONArray(s);
                JSONObject ob=arrayHP.getJSONObject(arrayHP.length()-1);
                txtMaHK.setText("Mã Học Kỳ: "+ob.getInt("MaHocKy"));
                txtSoTinChi.setText(ob.getInt("SoTCDK")+"");
                txtHocPhiNop.setText(ob.getInt("HocPhiPhaiNop")+" (đồng)");
                txtDaNopTheATM.setText(ob.getInt("NopQuaATM")+ " (đồng)");
                txtDaNopTaiVu.setText(ob.getInt("NopTaiTaiVu")+ " (đồng)");
                txtChuThich.setText(ob.getString("ChuThichHocPhi"));
                txtBHYT.setText(ob.getInt("BaoHiemYTe")+ " (đồng)");
                txtBHTT.setText(ob.getInt("BaoHiemThanThe")+ " (đồng)");

                String txtDate= ob.getString("NgayCapNhat");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                Date date = sdf.parse(txtDate);
                txtNgayCapNhat.setText(sdf2.format(date));
                Double tt=  ob.getDouble("HocPhiPhaiNop")+ob.getDouble("BaoHiemYTe")
                            +ob.getDouble("BaoHiemThanThe")
                            -ob.getDouble("NopQuaATM")-ob.getDouble("NopTaiTaiVu");
                txtTongTien.setText(tt.toString().substring(0,tt.toString().length()-2)+" (đồng)");

                for(int i=0;i<arrayHP.length();i++)
                    dsHocKy.add(arrayHP.getJSONObject(i).getInt("MaHocKy"));
                loadSpinner();

                spnHocKyHP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        int mahk = Integer.parseInt(spnHocKyHP.getSelectedItem().toString());
                        for(int i=0;i<arrayHP.length();i++) {
                            try {
                                if(arrayHP.getJSONObject(i).getInt("MaHocKy")==mahk) {
                                    JSONObject ob1=arrayHP.getJSONObject(i);
                                    txtMaHK.setText("Mã Học Kỳ: "+ob1.getInt("MaHocKy"));
                                    txtSoTinChi.setText(ob1.getInt("SoTCDK")+"");
                                    txtHocPhiNop.setText(ob1.getInt("HocPhiPhaiNop")+" (đồng)");
                                    txtDaNopTheATM.setText(ob1.getInt("NopQuaATM")+ " (đồng)");
                                    txtDaNopTaiVu.setText(ob1.getInt("NopTaiTaiVu")+ " (đồng)");
                                    txtChuThich.setText(ob1.getString("ChuThichHocPhi"));
                                    txtBHYT.setText(ob1.getInt("BaoHiemYTe")+ " (đồng)");
                                    txtBHTT.setText(ob1.getInt("BaoHiemThanThe")+ " (đồng)");

                                    String txtDate= ob1.getString("NgayCapNhat");
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                                    Date date = sdf.parse(txtDate);
                                    txtNgayCapNhat.setText(sdf2.format(date));
                                    Double tt=  ob1.getDouble("HocPhiPhaiNop")+ob1.getDouble("BaoHiemYTe")
                                            +ob1.getDouble("BaoHiemThanThe")
                                            -ob1.getDouble("NopQuaATM")-ob1.getDouble("NopTaiTaiVu");
                                    txtTongTien.setText(tt.toString().substring(0,tt.toString().length()-2)+" (đồng)");
                                    i=arrayHP.length();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            } catch (JSONException e) {
               e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
