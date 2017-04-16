package bawei.com.zuoye0415.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bawei.com.zuoye0415.bean.New1;
import bawei.com.zuoye0415.R;

/**
 * date:2017/4/15
 * author:周道(leovo)
 * funcation:
 */

public class Baseadpter1 extends BaseAdapter {
    private List<New1.DataBean> mNew1;
    private Context context;

    public Baseadpter1(List<New1.DataBean> new1, Context context) {
        mNew1 = new1;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mNew1.size();
    }

    @Override
    public Object getItem(int position) {
        return mNew1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder v;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.baseadpter1,null);
            v=new ViewHolder();
            v.tv1= (TextView) convertView.findViewById(R.id.tv1);
            v.tv2= (TextView) convertView.findViewById(R.id.tv2);
            v.tv3= (TextView) convertView.findViewById(R.id.tv3);
            convertView.setTag(v);
        }else{
            v= (ViewHolder) convertView.getTag();
        }
        v.tv1.setText(mNew1.get(position).getTitle());
        v.tv2.setText(mNew1.get(position).getApply());
        v.tv3.setText(mNew1.get(position).getBuy_price());
        return convertView;
    }
    class ViewHolder{
        TextView tv1,tv2,tv3;
    }
}
