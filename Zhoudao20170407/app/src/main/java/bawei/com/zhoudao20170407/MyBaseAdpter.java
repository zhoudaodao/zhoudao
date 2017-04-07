package bawei.com.zhoudao20170407;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * date:2017/4/7
 * author:周道(leovo)
 * funcation:
 */

public class MyBaseAdpter extends BaseAdapter {
    private Book book;
    private Context context;

    public MyBaseAdpter(Book book, Context context) {
        this.book = book;
        this.context = context;
    }

    @Override
    public int getCount() {
        return book.getContents().size();
    }

    @Override
    public Object getItem(int position) {
        return book.getContents().get(position);
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
            v.tv1= (TextView) convertView.findViewById(R.id.tv1);
            v.tv2= (TextView) convertView.findViewById(R.id.tv2);
            convertView.setTag(v);
        }else{
            v= (ViewHolder) convertView.getTag();
        }
        v.tv1.setText(book.getContents().get(position).getName());
        v.tv2.setText(book.getContents().get(position).getSort()+"");
        return convertView;
    }
    class ViewHolder{
        TextView tv1,tv2;
    }
}
