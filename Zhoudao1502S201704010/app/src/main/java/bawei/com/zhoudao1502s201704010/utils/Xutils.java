package bawei.com.zhoudao1502s201704010.utils;

import android.content.Context;
import android.widget.ListView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import bawei.com.zhoudao1502s201704010.MyUrl;
import bawei.com.zhoudao1502s201704010.adapter.Mybaseadpter;
import bawei.com.zhoudao1502s201704010.bean.NewsInfo;

/**
 * date:2017/4/10
 * author:周道(leovo)
 * funcation:
 */

public class Xutils {
    public static void get(String url,  final ListView lv, final Context context) {
        RequestParams params = new RequestParams(MyUrl.url);
        params.addQueryStringParameter("uri", url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                NewsInfo newsInfo = gson.fromJson(result, NewsInfo.class);
                lv.setAdapter(new Mybaseadpter(newsInfo,context));
                //解析result
            }

            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });
    }
}
