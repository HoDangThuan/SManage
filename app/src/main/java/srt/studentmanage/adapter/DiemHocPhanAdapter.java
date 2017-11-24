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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import srt.studentmanage.R;
import srt.studentmanage.model.objects.DiemHocPhan;

/**
 * Created by Admin on 08/31/2017.
 */

public class DiemHocPhanAdapter extends ArrayAdapter<DiemHocPhan> {
    Activity context;
    int resource;
    List<DiemHocPhan> objects;
    public DiemHocPhanAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<DiemHocPhan> objects) {
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
        TextView txtMahpAndTenhp, txtLopHP, txtSoTC, txtGhiChu, txtDiem;
        ImageView imgTichLuy;

        txtMahpAndTenhp= (TextView) row.findViewById(R.id.txtMahpAndTenhp);
        txtLopHP= (TextView) row.findViewById(R.id.txtLopHP);
        txtSoTC= (TextView) row.findViewById(R.id.txtSoTC);
        txtGhiChu= (TextView) row.findViewById(R.id.txtGhiChu);
        txtDiem= (TextView) row.findViewById(R.id.txtDiem);
        imgTichLuy= (ImageView) row.findViewById(R.id.imgTichLuy);

        DiemHocPhan diemHocPhan=this.objects.get(position);
        txtMahpAndTenhp.setText(diemHocPhan.getMaHP()+"-"+diemHocPhan.getTenHP());
        txtLopHP.setText("Lớp HP: "+diemHocPhan.getLopHP());
        txtSoTC.setText("Số TC: "+diemHocPhan.getSoTc());
        txtGhiChu.setText("Ghi chú: "+diemHocPhan.getGhiChu());
        txtDiem.setText(diemHocPhan.getDiemSo()+" - "+diemHocPhan.getDiemChu());
        if (!diemHocPhan.isTichLuy())
            imgTichLuy.setVisibility(View.INVISIBLE);
        return row;
    }
}
