package bawei.com.zuoye0415.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import bawei.com.zuoye0415.bean.NewsInfo;
import bawei.com.zuoye0415.R;
import bawei.com.zuoye0415.Utils.StreamUtils;
import bawei.com.zuoye0415.adpter.baseadpter;

public class MainActivity extends AppCompatActivity {
    private ListView mLv;
    private List<String> list=new ArrayList<>();
    private String url1="http://appapi.kangzhi.com/app/kzdrugs/drugs_cate?uid=";
    private Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    NewsInfo newsinfo = (NewsInfo) msg.obj;
                    List<NewsInfo.DataBean> data = newsinfo.getData();
                    mLv.setAdapter(new baseadpter(data,MainActivity.this));
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// configure the SlidingMenu
        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.color.colorAccent);

        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.left_menu);
        getslidingmenu();
        list.add("http://appapi.kangzhi.com/app/kzdrugs/index?uid=1476860172&catid=&sort=default&page=1");
        list.add("http://appapi.kangzhi.com/app/kzdrugs/index?uid=1476860172&catid=%E4%B8%AD%E8%8D%AF&sort=default&page=1");
        list.add("http://appapi.kangzhi.com/app/kzdrugs/index?uid=1476860172&catid=%E8%A5%BF%E8%8D%AF&sort=default&page=1");
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("url",list.get(position));
                startActivity(intent);
            }
        });
    }

    private void getslidingmenu() {
        View view=View.inflate(MainActivity.this,R.layout.left_menu,null);
        mLv = (ListView) findViewById(R.id.lv);
        new Thread(new Runnable() {
            @Override
            public void run() {
                initData();
            }
        }).start();
    }
    private void initData() {
        try {
            URL url=new URL(url1);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            if(connection.getResponseCode()==200){
                InputStream inputStream = connection.getInputStream();
                String html= StreamUtils.utils(inputStream);
                Gson gson=new Gson();
                NewsInfo newsInfo = gson.fromJson(html, NewsInfo.class);
                Message message=Message.obtain(handler,0,newsInfo);
                message.sendToTarget();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
