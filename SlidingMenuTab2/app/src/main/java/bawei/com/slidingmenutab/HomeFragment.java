package bawei.com.slidingmenutab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2017/4/8
 * author:周道(leovo)
 * funcation:
 */

public class HomeFragment extends Fragment{
    private TabLayout tab;
    private ViewPager vp;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,null);
         initView(view);
        return view;
    }

    private void initView(View view) {
        tab = (TabLayout) view.findViewById(R.id.tab);
        vp = (ViewPager) view.findViewById(R.id.vp);
        titles.add("NO:1");
        titles.add("NO:2");
        titles.add("NO:3");
        titles.add("NO:4");
        titles.add("NO:5");

        NewsFragment newsFragment1 = new NewsFragment();
        NewsFragment newsFragment2 = new NewsFragment();
        NewsFragment newsFragment3 = new NewsFragment();
        NewsFragment newsFragment4 = new NewsFragment();
        NewsFragment newsFragment5 = new NewsFragment();
        fragments.add(newsFragment1);
        fragments.add(newsFragment2);
        fragments.add(newsFragment3);
        fragments.add(newsFragment4);
        fragments.add(newsFragment5);
        //设置tablayout模式
        tab.setTabMode(TabLayout.MODE_FIXED);
        //添加tab标签 数据源
        tab.addTab(tab.newTab().setText(titles.get(0)));
        tab.addTab(tab.newTab().setText(titles.get(1)));
        tab.addTab(tab.newTab().setText(titles.get(2)));
        tab.addTab(tab.newTab().setText(titles.get(3)));
        tab.addTab(tab.newTab().setText(titles.get(4)));

//创建适配器
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getActivity().getSupportFragmentManager());
        vp.setAdapter(adapter);
        //将tablayout跟viewpager关联
        tab.setupWithViewPager(vp);
        tab.setTabsFromPagerAdapter(adapter);
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        //获取page对应的title
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
