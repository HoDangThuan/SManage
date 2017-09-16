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
    public static class ViewHolder {
        TextView txtTieuDe;
        TextView txtNoiDung;
        TextView txtTacGia;
        TextView txtNgayViet;
    }
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
        View row = convertView;
//        TextView txtTieuDe, txtNoiDung, txtTacGia, txtNgayViet;
        if (row== null){
            row=inflater.inflate(this.resource,null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.txtTieuDe = (TextView) row.findViewById(R.id.txtTieuDe);
            viewHolder.txtNoiDung = (TextView) row.findViewById(R.id.txtNoiDung);
            viewHolder.txtTacGia = (TextView) row.findViewById(R.id.txtTacGia);
            viewHolder.txtNgayViet = (TextView) row.findViewById(R.id.txtNgayViet);
            row.setTag(viewHolder);
        }
        ViewHolder viewHolder = (ViewHolder) row.getTag();
        TinDaoTao tdt = this.objects.get(position);
        viewHolder.txtTieuDe.setText(tdt.getTieuDe());
        viewHolder.txtNoiDung.setText(tdt.getNoiDung());
        viewHolder.txtTacGia.setText("Author: "+tdt.getTacGia());
        return row;
    }
}
