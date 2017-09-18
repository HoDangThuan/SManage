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

import java.util.ArrayList;

import srt.studentmanage.R;
import srt.studentmanage.adapter.KhenThuongKiLuatAdapter;
import srt.studentmanage.adapter.TongKetHocKyAdapter;
import srt.studentmanage.model.objects.DiemHocKy;
import srt.studentmanage.model.objects.KhenThuongKiLuat;


public class TongKetDiemFragment extends Fragment {
    ListView lvTongKetTheoHocKy, lvSuKienKhenThuongKiLuat;
    ArrayList<DiemHocKy> dsDiemHocKy;
    ArrayList<KhenThuongKiLuat> dsKhenThuongKiLuat;
    TongKetHocKyAdapter tongKetHocKyAdapter;
    KhenThuongKiLuatAdapter khenThuongKiLuatAdapter;
    View v;
    public TongKetDiemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_tong_ket_diem,container,false);
        loadListViewXemDiemHocKy();
        loadListViewKhenThuongKiLuat();
        return v;
    }

    private void loadListViewKhenThuongKiLuat() {
        lvSuKienKhenThuongKiLuat= (ListView) v.findViewById(R.id.lvSuKienKhenThuongKiLuat);
        dsKhenThuongKiLuat=new ArrayList<>();
        dsKhenThuongKiLuat.add(new KhenThuongKiLuat("- Học kỳ 115: Thư khen thưởng của Hiệu trưởng - Lý do: Thành tích học tập khá trong học kỳ 115"));
        dsKhenThuongKiLuat.add(new KhenThuongKiLuat("- Học kỳ 116: Thư khen thưởng của Hiệu trưởng - Lý do: Thành tích học tập khá trong học kỳ 115"));
        khenThuongKiLuatAdapter=new KhenThuongKiLuatAdapter(getActivity(),R.layout.item_lv_su_kien_khen_thuong_ki_luat,dsKhenThuongKiLuat);
        lvSuKienKhenThuongKiLuat.setAdapter(khenThuongKiLuatAdapter);
    }

    private void loadListViewXemDiemHocKy() {
        lvTongKetTheoHocKy= (ListView) v.findViewById(R.id.lvTongKetTheoHocKy);
        dsDiemHocKy=new ArrayList<>();
        dsDiemHocKy.add(new DiemHocKy(115,17,3.89,1,"Bình thường",""));
        dsDiemHocKy.add(new DiemHocKy(116,17,3.89,1,"Bình thường",""));
        dsDiemHocKy.add(new DiemHocKy(117,17,3.89,1,"Bình thường",""));
        tongKetHocKyAdapter=new TongKetHocKyAdapter(getActivity(),R.layout.item_lv_tong_ket_theo_hoc_ky,dsDiemHocKy);
        lvTongKetTheoHocKy.setAdapter(tongKetHocKyAdapter);
    }
}
