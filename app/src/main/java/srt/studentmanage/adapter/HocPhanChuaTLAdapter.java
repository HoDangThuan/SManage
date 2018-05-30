package srt.studentmanage.adapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import srt.studentmanage.R;
import srt.studentmanage.model.objects.HocPhanChuaTL;


public class HocPhanChuaTLAdapter extends ArrayAdapter<HocPhanChuaTL> {
    Activity context;
    int resource;
    List<HocPhanChuaTL> objects;
    public HocPhanChuaTLAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<HocPhanChuaTL> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        TextView txtMaHP, txtLopHP, txtSoTC, txtLoaiMH, txtGhiChu;

        txtMaHP= (TextView) row.findViewById(R.id.txtMaHP);
        txtLopHP= (TextView) row.findViewById(R.id.txtTenHP);
        txtSoTC= (TextView) row.findViewById(R.id.txtSoTC);
        txtLoaiMH= (TextView) row.findViewById(R.id.txtLoaiMH);
        txtGhiChu= (TextView) row.findViewById(R.id.txtGhiChu);

        HocPhanChuaTL hpctl=this.objects.get(position);
        txtMaHP.setText(hpctl.getMaHP());
        txtLopHP.setText(hpctl.getTenHP());
        txtSoTC.setText(hpctl.getSoTC());
        txtLoaiMH.setText(hpctl.getLoaiMH());
        txtGhiChu.setText(hpctl.getGhiChu());
        return row;
    }
}
