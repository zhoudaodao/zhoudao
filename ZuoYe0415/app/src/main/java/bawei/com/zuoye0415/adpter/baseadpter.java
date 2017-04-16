package bawei.com.zuoye0415.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bawei.com.zuoye0415.bean.NewsInfo;
import bawei.com.zuoye0415.R;

/**
 * date:2017/4/15
 * author:周道(leovo)
 * funcation:
 */

public class baseadpter extends BaseAdapter {
    private List<NewsInfo.DataBean> data;
    private Context context;

    public baseadpter(List<NewsInfo.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
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
            v.tv1= (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(v);
        }else{
            v= (ViewHolder) convertView.getTag();
        }
        v.tv1.setText(data.get(position).getName());
        return convertView;
    }
    class ViewHolder{
        TextView tv1;
    }
}
