package bawei.com.zhoudao1502s201704010.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * date:2017/4/10
 * author:周道(leovo)
 * funcation:
 */

public class MyFragmentPagerAdpter extends FragmentPagerAdapter {
    private List<Fragment> list_fragment;
    private String[] string;

    public MyFragmentPagerAdpter(FragmentManager fm, List<Fragment> list_fragment, String[] string) {
        super(fm);
        this.list_fragment = list_fragment;
        this.string = string;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return string[position];
    }
}
