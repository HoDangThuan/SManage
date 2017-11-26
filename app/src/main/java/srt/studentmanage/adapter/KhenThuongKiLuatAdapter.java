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
import srt.studentmanage.model.objects.KhenThuongKiLuat;

/**
 * Created by Admin on 09/11/2017.
 */

public class KhenThuongKiLuatAdapter extends ArrayAdapter<KhenThuongKiLuat> {
    Activity context;
    int resource;
    List<KhenThuongKiLuat> objects;
    public KhenThuongKiLuatAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<KhenThuongKiLuat> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource, null);
        TextView txtContext;
        txtContext= (TextView) row.findViewById(R.id.txtContext);

        KhenThuongKiLuat khenThuongKiLuat=this.objects.get(position);
        txtContext.setText("- Học kỳ "+khenThuongKiLuat.getMaHK()+": " + khenThuongKiLuat.getLoaiKT()
                +" - Lý do: "+ khenThuongKiLuat.getMoTa());
        return row;
    }
}
