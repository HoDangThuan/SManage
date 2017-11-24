package srt.studentmanage.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import srt.studentmanage.R;
import srt.studentmanage.adapter.PagerXemDiemAdapter;
import srt.studentmanage.ui.intalize.BaseActivity;

public class XemDiemActivity extends BaseActivity {

    private ViewPager pager;
    private TabLayout tabLayout;
    @Override
    protected int getLayout() {
        return R.layout.activity_xem_diem;
    }

    @Override
    protected void initViews() {
        pager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        FragmentManager manager = getSupportFragmentManager();
        PagerXemDiemAdapter adapter = new PagerXemDiemAdapter(manager);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);
    }

    @Override
    protected void main() {

    }

}
