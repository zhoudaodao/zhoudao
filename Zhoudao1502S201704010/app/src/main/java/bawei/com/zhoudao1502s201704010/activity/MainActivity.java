package bawei.com.zhoudao1502s201704010.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import bawei.com.zhoudao1502s201704010.adapter.MyFragmentPagerAdpter;
import bawei.com.zhoudao1502s201704010.R;
import bawei.com.zhoudao1502s201704010.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager mVp;
    private List<Fragment> fragments=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        initview();
        addFragment();
        setTabPager();
    }

    private void setTabPager() {
        MyFragmentPagerAdpter mypageradpter=new MyFragmentPagerAdpter(MainActivity.this.getSupportFragmentManager(),fragments,new String[]{"头条","社会","国内","娱乐","体育","军事","科技","财经","时尚","国际"});
        mVp.setAdapter(mypageradpter);
        mTablayout.setupWithViewPager(mVp);
    }

    private void addFragment() {
        fragments.add(UserFragment.getFragment("tt"));
        fragments.add(UserFragment.getFragment("shehui"));
        fragments.add(UserFragment.getFragment("gn"));
        fragments.add(UserFragment.getFragment("yl"));
        fragments.add(UserFragment.getFragment("ty"));
        fragments.add(UserFragment.getFragment("js"));
        fragments.add(UserFragment.getFragment("kj"));
        fragments.add(UserFragment.getFragment("cj"));
        fragments.add(UserFragment.getFragment("ss"));
        fragments.add(UserFragment.getFragment("gj"));
    }

    private void initview() {
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mVp = (ViewPager) findViewById(R.id.vp);
    }
}
