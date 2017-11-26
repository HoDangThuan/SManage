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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import srt.studentmanage.R;
import srt.studentmanage.adapter.DiemHocPhanAdapter;
import srt.studentmanage.model.objects.BangDiem;
import srt.studentmanage.model.objects.DiemHocKy;
import srt.studentmanage.model.objects.DiemHocPhan;
import srt.studentmanage.ui.activities.XemDiemActivity;


public class BangDiemFragment extends Fragment {

    ListView lvDiemHocPhan;
    ArrayList<DiemHocPhan> dsDiemHocPhan;
    DiemHocPhanAdapter diemHocPhanAdapter;
    View v;

    Spinner spnHocKy;
    ArrayList<Integer> dsHocKy = new ArrayList<>();
    BangDiem bangDiem;
    public BangDiemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_bang_diem,container,false);
        spnHocKy= (Spinner) v.findViewById(R.id.spnHocKy);
        lvDiemHocPhan= (ListView) v.findViewById(R.id.lvDiemHocPhan);
        XemDiemActivity activity = (XemDiemActivity) getActivity();
        this.bangDiem = activity.getBangDiem();
        spnHocKy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int mahk = Integer.parseInt(spnHocKy.getSelectedItem().toString());
                loadListView(mahk);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        loadSpinner();
        return v;
    }

    private void loadSpinner() {
        dsHocKy=new ArrayList<>();
        for (DiemHocKy dhk : bangDiem.getDiemHocKies()){
            dsHocKy.add(dhk.getMaHK());
        }

        ArrayAdapter<Integer> hocKyAdapter=new ArrayAdapter<Integer>(getActivity(),R.layout.spinner_item,dsHocKy);
        hocKyAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnHocKy.setAdapter(hocKyAdapter);
    }

    private void loadListView(int maHK) {

        for (DiemHocKy dhk : bangDiem.getDiemHocKies()){
            if (dhk.getMaHK() == maHK){
                dsDiemHocPhan = new ArrayList<>(dhk.getDiemHocPhan());
                break;
            }
        }
        diemHocPhanAdapter=new DiemHocPhanAdapter(getActivity(),R.layout.item_lv_xem_diem,dsDiemHocPhan);
        lvDiemHocPhan.setAdapter(diemHocPhanAdapter);
    }
}
