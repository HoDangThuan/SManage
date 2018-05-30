package srt.studentmanage.adapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import srt.studentmanage.R;
import srt.studentmanage.model.objects.DangKyMonHoc;


public class DangKyMonHocAdapter extends ArrayAdapter<DangKyMonHoc>{
      public static class ViewHolder {
        TextView txtMaHP, txtTenHP, txtTenLHP, txtSoTC,txtThu,txtTuTiet,
                txtDenTiet,txtGhiChu,txtGiangVien,txtSoLuong,txtDaDK;
        CheckBox checkBoxChon;
    }
    Activity context;
    int resource;
    List<DangKyMonHoc> objects;
    public DangKyMonHocAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<DangKyMonHoc> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    public List<DangKyMonHoc> getObjects() {
        return objects;
    }
    @Override
    public int getCount(){
        return objects.size();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=this.context.getLayoutInflater();
        View row = convertView;
        ViewHolder viewHolder = null;

        if (row== null){
            row=inflater.inflate(this.resource,null);

            viewHolder=new ViewHolder();

            viewHolder.txtMaHP = (TextView) row.findViewById(R.id.txtMaHP);
            viewHolder.txtTenHP = (TextView) row.findViewById(R.id.txtTenHP);
            viewHolder.txtTenLHP = (TextView) row.findViewById(R.id.txtTenLHP);
            viewHolder.txtThu = (TextView) row.findViewById(R.id.txtThu);
            viewHolder.txtTuTiet = (TextView) row.findViewById(R.id.txtTuTiet);
            viewHolder.txtDenTiet = (TextView) row.findViewById(R.id.txtDenTiet);
            viewHolder.txtGhiChu = (TextView) row.findViewById(R.id.txtGhiChu);
            viewHolder.txtGiangVien = (TextView) row.findViewById(R.id.txtGiangVien);
            viewHolder.txtSoLuong = (TextView) row.findViewById(R.id.txtSoLuong);
            viewHolder.txtDaDK = (TextView) row.findViewById(R.id.txtDaDK);
            viewHolder.txtSoTC = (TextView) row.findViewById(R.id.txtSoTC);
            viewHolder.checkBoxChon = (CheckBox) row.findViewById(R.id.checkBoxChon);

            row.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) row.getTag();
        }

        final DangKyMonHoc dangKyMonHoc = this.objects.get(position);
        viewHolder.txtMaHP.setText(dangKyMonHoc.getMaHP());
        viewHolder.txtTenHP.setText(dangKyMonHoc.getTenHP());
        viewHolder.txtTenLHP.setText(dangKyMonHoc.getTenLHP());
        viewHolder.txtGhiChu.setText(dangKyMonHoc.getGhiChu());
        viewHolder.txtGiangVien.setText(dangKyMonHoc.getGiangVien());
        viewHolder.txtSoTC.setText(dangKyMonHoc.getSoTC()+"");
        viewHolder.txtThu.setText(dangKyMonHoc.getThu()+"");
        viewHolder.txtTuTiet.setText(dangKyMonHoc.getTutiet()+"");
        viewHolder.txtDenTiet.setText(dangKyMonHoc.getDentiet()+"");
        viewHolder.txtSoLuong.setText(dangKyMonHoc.getSisoMax()+"");
        viewHolder.txtDaDK.setText(dangKyMonHoc.getSoDK()+"");
        viewHolder.checkBoxChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangKyMonHoc.setCheckBox(!dangKyMonHoc.isCheckBox());
            }
        });

        return row;
    }
}
