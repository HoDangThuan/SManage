package srt.studentmanage.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import srt.studentmanage.R;
import srt.studentmanage.adapter.KhenThuongKiLuatAdapter;
import srt.studentmanage.adapter.TongKetHocKyAdapter;
import srt.studentmanage.model.objects.BangDiem;
import srt.studentmanage.model.objects.DiemHocKy;
import srt.studentmanage.model.objects.KhenThuongKiLuat;
import srt.studentmanage.ui.activities.XemDiemActivity;


public class TongKetDiemFragment extends Fragment {
    ListView lvTongKetTheoHocKy, lvSuKienKhenThuongKiLuat;
    TextView txtDiemTrungBinhChung, txtSoTcTichLuy, txtXepHang;
    ArrayList<DiemHocKy> dsDiemHocKy = new ArrayList<>();
    ArrayList<KhenThuongKiLuat> dsKhenThuongKiLuat = new ArrayList<>();
    TongKetHocKyAdapter tongKetHocKyAdapter;
    KhenThuongKiLuatAdapter khenThuongKiLuatAdapter;
    View v;
    BangDiem bangDiem;
    public TongKetDiemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_tong_ket_diem,container,false);
        lvSuKienKhenThuongKiLuat= (ListView) v.findViewById(R.id.lvSuKienKhenThuongKiLuat);
        lvTongKetTheoHocKy= (ListView) v.findViewById(R.id.lvTongKetTheoHocKy);
        txtDiemTrungBinhChung = (TextView) v.findViewById(R.id.txtDiemTrungBinhChung);
        txtSoTcTichLuy = (TextView) v.findViewById(R.id.txtSoTcTichLuy);
        txtXepHang = (TextView) v.findViewById(R.id.txtXepHang);
        XemDiemActivity activity = (XemDiemActivity) getActivity();
        this.bangDiem = activity.getBangDiem();
        txtDiemTrungBinhChung.setText(bangDiem.getDiemTB()+"");
        txtSoTcTichLuy.setText(bangDiem.getSoTCTichLuy()+"");
        txtXepHang.setText(bangDiem.getXepHang());
        for (DiemHocKy dhk:bangDiem.getDiemHocKies()){
            dsDiemHocKy.add(dhk);
            for (KhenThuongKiLuat ktkl: dhk.getKhenThuongKiLuats()){
                dsKhenThuongKiLuat.add(ktkl);
            }
        }
        loadListViewXemDiemHocKy();
        loadListViewKhenThuongKiLuat();
        return v;
    }

    private void loadListViewKhenThuongKiLuat() {

        khenThuongKiLuatAdapter=new KhenThuongKiLuatAdapter(getActivity()
                ,R.layout.item_lv_su_kien_khen_thuong_ki_luat,dsKhenThuongKiLuat);
        lvSuKienKhenThuongKiLuat.setAdapter(khenThuongKiLuatAdapter);
    }

    private void loadListViewXemDiemHocKy() {
        tongKetHocKyAdapter=new TongKetHocKyAdapter(getActivity(),R.layout.item_lv_tong_ket_theo_hoc_ky,dsDiemHocKy);
        lvTongKetTheoHocKy.setAdapter(tongKetHocKyAdapter);
    }
}
