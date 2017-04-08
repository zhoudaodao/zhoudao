package bawei.com.slidingmenutab;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建slidingment
        SlidingMenu slidingMenu=new SlidingMenu(this);
        //设置侧滑方向
        slidingMenu.setMode(SlidingMenu.LEFT);
        //设置侧滑宽度
        slidingMenu.setBehindOffset(200);
        //让侧滑依附到activity上
        slidingMenu.attachToActivity(MainActivity.this,SlidingMenu.SLIDING_CONTENT);
        //设置侧滑布局
        slidingMenu.setMenu(R.layout.menu);
        initFragment();
    }

    private void initFragment() {
        //fragment的管理器
        FragmentManager fragmentManager=getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.menu,new MenuFragment());
        transaction.commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main,new HomeFragment()).commit();
    }
}
