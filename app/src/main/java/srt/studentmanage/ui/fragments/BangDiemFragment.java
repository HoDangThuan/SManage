package srt.studentmanage.ui.fragments;

import android.content.Context;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import srt.studentmanage.R;
import srt.studentmanage.adapter.DiemHocPhanAdapter;
import srt.studentmanage.model.objects.DiemHocPhan;


public class BangDiemFragment extends Fragment {

    ListView lvDiemHocPhan;
    ArrayList<DiemHocPhan> dsDiemHocPhan;
    DiemHocPhanAdapter diemHocPhanAdapter;
    View v;

    Spinner spnHocKy;
    ArrayList<Integer> dsHocKy;
    public BangDiemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_bang_diem,container,false);
        loadListView();
        loadSpinner();
        return v;
    }

    private void loadSpinner() {
        dsHocKy=new ArrayList<>();
        dsHocKy.add(117);
        dsHocKy.add(217);
        dsHocKy.add(317);
        spnHocKy= (Spinner) v.findViewById(R.id.spnHocKy);
        ArrayAdapter<Integer> hocKyAdapter=new ArrayAdapter<Integer>(getActivity(),R.layout.spinner_item,dsHocKy);
        hocKyAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnHocKy.setAdapter(hocKyAdapter);
    }

    private void loadListView() {
        lvDiemHocPhan= (ListView) v.findViewById(R.id.lvDiemHocPhan);
        dsDiemHocPhan=new ArrayList<>();
        dsDiemHocPhan.add(new DiemHocPhan("5020021","100NN000","Ngoại Ngữ cơ bản",3,117,"DR",4.9,true,""));
        dsDiemHocPhan.add(new DiemHocPhan("5020290","115GDTC117","Giáo dục thể chất I",2,117,"B",7.9,false,""));
        dsDiemHocPhan.add(new DiemHocPhan("5020021","115LTC01","Lập trình cơ bản với C",3,117,"A",1,true,""));
        diemHocPhanAdapter=new DiemHocPhanAdapter(getActivity(),R.layout.item_lv_xem_diem,dsDiemHocPhan);
        lvDiemHocPhan.setAdapter(diemHocPhanAdapter);
    }
}
