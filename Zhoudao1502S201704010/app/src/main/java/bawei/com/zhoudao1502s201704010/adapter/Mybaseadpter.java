package bawei.com.zhoudao1502s201704010.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import bawei.com.zhoudao1502s201704010.bean.NewsInfo;
import bawei.com.zhoudao1502s201704010.R;
import bawei.com.zhoudao1502s201704010.utils.ImageUtils;

/**
 * date:2017/4/10
 * author:周道(leovo)
 * funcation:
 */

public class Mybaseadpter extends BaseAdapter {
    private NewsInfo newsinfo;
    private Context context;

    public Mybaseadpter(NewsInfo newsinfo, Context context) {
        this.newsinfo = newsinfo;
        this.context = context;
    }

    @Override
    public int getCount() {
        return newsinfo.getResult().getData().size();
    }

    @Override
    public Object getItem(int position) {
        return newsinfo.getResult().getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder v;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.baseadpter,null);
            v=new ViewHolder();
            v.iv= (ImageView) convertView.findViewById(R.id.iv);
            v.tv1= (TextView) convertView.findViewById(R.id.tv1);
            v.tv2= (TextView) convertView.findViewById(R.id.tv2);
            convertView.setTag(v);
        }else{
            v= (ViewHolder) convertView.getTag();
        }
        v.tv1.setText(newsinfo.getResult().getData().get(position).getTitle());
        v.tv2.setText(newsinfo.getResult().getData().get(position).getAuthor_name());
        ImageLoader.getInstance().displayImage(newsinfo.getResult().getData().get(position).getThumbnail_pic_s(),v.iv, ImageUtils.geyoptions(R.mipmap.ic_launcher));
        return convertView;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv1,tv2;
    }
}
