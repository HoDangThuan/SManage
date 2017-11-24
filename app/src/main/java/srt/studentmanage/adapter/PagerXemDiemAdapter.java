package srt.studentmanage.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import srt.studentmanage.ui.fragments.BangDiemFragment;
import srt.studentmanage.ui.fragments.TongKetDiemFragment;

/**
 * Created by Admin on 08/30/2017.
 */

public class PagerXemDiemAdapter extends FragmentStatePagerAdapter {
    public PagerXemDiemAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new BangDiemFragment();
                break;
            case 1:
                frag = new TongKetDiemFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Bảng điểm";
                break;
            case 1:
                title = "Tổng kết";
                break;
        }
        return title;
    }
}
