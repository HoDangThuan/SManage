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
import srt.studentmanage.model.objects.LichThi;


public class LichThiAdapter extends ArrayAdapter<LichThi> {
    Activity context;
    int resource;
    List<LichThi> objects;
    public LichThiAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<LichThi> objects) {
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
        TextView txtTenLHP, txtLopHP, txtTenGV, txtNgayThi, txtGioThi,txtPhongThi;

        txtTenLHP= (TextView) row.findViewById(R.id.txtTenLHP);
        txtLopHP= (TextView) row.findViewById(R.id.txtLopHP);
        txtTenGV= (TextView) row.findViewById(R.id.txtTenGV);
        txtNgayThi= (TextView) row.findViewById(R.id.txtNgayThi);
        txtGioThi= (TextView) row.findViewById(R.id.txtGioThi);
        txtPhongThi= (TextView) row.findViewById(R.id.txtPhongThi);

        LichThi lichThi=this.objects.get(position);
        txtTenLHP.setText(lichThi.getTenLHP());
        txtLopHP.setText(lichThi.getLopHP());
        txtTenGV.setText(lichThi.getTenGV());
        txtNgayThi.setText(lichThi.getNgayThi());
        txtGioThi.setText(lichThi.getGioThi());
        txtPhongThi.setText(lichThi.getPhongThi());
        return row;
    }
}
