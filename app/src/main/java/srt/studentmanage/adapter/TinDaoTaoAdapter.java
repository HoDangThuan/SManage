package srt.studentmanage.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import srt.studentmanage.R;
import srt.studentmanage.model.objects.TinDaoTao;

/**
 * Created by Huu Ty on 14/09/2017.
 */

public class TinDaoTaoAdapter extends ArrayAdapter<TinDaoTao> {
    Activity context;
    int resource;
    List<TinDaoTao> objects;
    public TinDaoTaoAdapter(Activity context, int resource, List<TinDaoTao> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        TextView txtTieuDe, txtNoiDung, txtTacGia, txtNgayViet;
        txtTieuDe = (TextView) row.findViewById(R.id.txtTieuDe);
        txtNoiDung = (TextView) row.findViewById(R.id.txtNoiDung);
        txtTacGia = (TextView) row.findViewById(R.id.txtTacGia);
        txtNgayViet = (TextView) row.findViewById(R.id.txtNgayViet);
        TinDaoTao tdt = this.objects.get(position);
        txtTieuDe.setText(tdt.getTieuDe());
        txtNoiDung.setText(tdt.getNoiDung());
        txtTacGia.setText("Author: "+tdt.getTacGia());
        return row;
    }
}
