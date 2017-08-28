package srt.studentmanage.adapter;

import android.app.Activity;
import android.content.Context;
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
import srt.studentmanage.model.objects.ThoiKhoaBieu;

/**
 * Created by Admin on 08/28/2017.
 */

public class ThoiKhoaBieuAdapter extends ArrayAdapter<ThoiKhoaBieu> {
    Activity context;
    int resource;
    List<ThoiKhoaBieu> objects;
    public ThoiKhoaBieuAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<ThoiKhoaBieu> objects) {
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
        TextView txtTiet, txtTenMonHoc, txtGiangVien, txtNgayHieuLuc, txtGhiChu, txtPhong, txtLop;

        txtGhiChu= (TextView) row.findViewById(R.id.txtGhiChu);
        txtTenMonHoc= (TextView) row.findViewById(R.id.txtTenMonHoc);
        txtGiangVien= (TextView) row.findViewById(R.id.txtGiangVien);
        txtNgayHieuLuc= (TextView) row.findViewById(R.id.txtNgayHieuLuc);
        txtPhong= (TextView) row.findViewById(R.id.txtPhong);
        txtLop= (TextView) row.findViewById(R.id.txtLop);
        txtTiet= (TextView) row.findViewById(R.id.txtTiet);

        ThoiKhoaBieu tkb=this.objects.get(position);
        txtTiet.setText("Tiết\n"+tkb.getTuTiet()+"-"+tkb.getDenTiet());
        txtTenMonHoc.setText(tkb.getTenMonHoc());
        txtGiangVien.setText("GV "+tkb.getGiangVien());
        txtPhong.setText("Phòng: "+tkb.getPhong());
        txtLop.setText("Lớp: "+tkb.getLopHP());
        txtGhiChu.setText("Ghi chú: "+tkb.getGhiChu());
        txtNgayHieuLuc.setText("NHL: "+tkb.getNgayHL());

        return row;
    }
}
