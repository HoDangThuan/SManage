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
import srt.studentmanage.model.objects.DiemHocKy;

/**
 * Created by Admin on 09/11/2017.
 */

public class TongKetHocKyAdapter extends ArrayAdapter<DiemHocKy> {
    Activity context;
    int resource;
    List<DiemHocKy> objects;
    public TongKetHocKyAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<DiemHocKy> objects) {
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
        TextView txtMaHK, txtSoTCDK, txtDiemTB, txtDiemRL, txtXepLoai;

        txtMaHK= (TextView) row.findViewById(R.id.txtMaHK);
        txtSoTCDK= (TextView) row.findViewById(R.id.txtSoTCDK);
        txtDiemTB= (TextView) row.findViewById(R.id.txtDiemTB);
        txtDiemRL= (TextView) row.findViewById(R.id.txtDiemRL);
        txtXepLoai= (TextView) row.findViewById(R.id.txtXepLoai);

        DiemHocKy diemHocKy=this.objects.get(position);
        txtMaHK.setText(diemHocKy.getMaHK()+"");
        txtSoTCDK.setText(diemHocKy.getSoTcDk()+"");
        txtDiemTB.setText(diemHocKy.getDiemTB()+"");
        txtDiemRL.setText(diemHocKy.getDiemRL()+"");
        txtXepLoai.setText(diemHocKy.getXepLoai());
        return row;
    }
}
