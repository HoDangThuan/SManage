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
import srt.studentmanage.adapter.TongKetHocKyAdapter;
import srt.studentmanage.model.objects.DiemHocKy;


public class TongKetDiemFragment extends Fragment {
    ListView lvTongKetTheoHocKy;
    ArrayList<DiemHocKy> dsDiemHocKy;
    TongKetHocKyAdapter tongKetHocKyAdapter;
    View v;
    public TongKetDiemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_tong_ket_diem,container,false);
        loadListView();
        return v;
    }

    private void loadListView() {
        lvTongKetTheoHocKy= (ListView) v.findViewById(R.id.lvTongKetTheoHocKy);
        dsDiemHocKy=new ArrayList<>();
        dsDiemHocKy.add(new DiemHocKy(115,17,3.89,1,"Bình thường",""));
        dsDiemHocKy.add(new DiemHocKy(116,17,3.89,1,"Bình thường",""));
        dsDiemHocKy.add(new DiemHocKy(117,17,3.89,1,"Bình thường",""));
        tongKetHocKyAdapter=new TongKetHocKyAdapter(getActivity(),R.layout.item_lv_tong_ket_theo_hoc_ky,dsDiemHocKy);
        lvTongKetTheoHocKy.setAdapter(tongKetHocKyAdapter);
    }
}
