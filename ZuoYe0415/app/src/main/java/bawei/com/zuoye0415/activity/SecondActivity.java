package bawei.com.zuoye0415.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import bawei.com.zuoye0415.bean.New1;
import bawei.com.zuoye0415.R;
import bawei.com.zuoye0415.Utils.StreamUtils;
import bawei.com.zuoye0415.adpter.Baseadpter1;

/**
 * date:2017/4/15
 * author:周道(leovo)
 * funcation:
 */

public class SecondActivity extends AppCompatActivity {
    private ListView mLv;
    private String mUrl;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    New1 new1= (New1) msg.obj;
                    List<New1.DataBean> data = new1.getData();
                    mLv.setAdapter(new Baseadpter1(data, SecondActivity.this));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        Log.d("ss",mUrl);
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
            URL url = new URL(mUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                String html = StreamUtils.utils(inputStream);
                Gson gson = new Gson();
                New1 new1 = gson.fromJson(html, New1.class);
                Message message = Message.obtain(handler, 0, new1);
                message.sendToTarget();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}