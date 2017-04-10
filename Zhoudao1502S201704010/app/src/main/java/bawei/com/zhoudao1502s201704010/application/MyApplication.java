package bawei.com.zhoudao1502s201704010.application;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * date:2017/4/10
 * author:周道(leovo)
 * funcation:
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true); //是否输出debug日志，开启debug会影响性能。
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(480,800).build();
        ImageLoader.getInstance().init(configuration);
    }
}
