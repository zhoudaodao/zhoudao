package com.example.administrator.mytothcheven;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView mian_list;
    private long firstClick;
    private long lastClick;
    private int count;
    private ScrollView mian_scroll;
    private HorizontalScrollView main_hor;
    private TextView mian_te;
    private View contentView;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //mMPopWindow.dismiss();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //设置MotionEvent的点击事件
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (firstClick != 0 && System.currentTimeMillis() - firstClick > 300) {
                    count = 0;
                }
                count++;
                if (count == 1) {
                    firstClick = System.currentTimeMillis();
                    Log.e("-------", "触摸时按下");
                } else if (count == 2) {
                    lastClick = System.currentTimeMillis();
                    // 两次点击小于300ms 也就是连续点击
                    if (lastClick - firstClick < 300) {// 判断是否是执行了双击事件
                        Log.e("-------", "双击破跑");
                    }
                }
                break;
            /*// Toast.makeText(this, "手指按下", Toast.LENGTH_SHORT).show();

                // 手指按下
                break;*/
            case MotionEvent.ACTION_MOVE:
                Log.e("-------", "触摸时移动");
                break;
            //  Toast.makeText(this, "手指移动", Toast.LENGTH_SHORT).show();
            // 手指移动
            case MotionEvent.ACTION_UP:
                // Toast.makeText(this, "手指抬起", Toast.LENGTH_SHORT).show();
                Log.e("-------", "触摸时抬起");
                // 手指抬起
                break;
        }
        return super.onTouchEvent(event);
    }

    private void initView() {
        //滚动
        mian_scroll = (ScrollView) findViewById(R.id.mian_scroll);
        mian_scroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    //可以监听到ScrollView的滚动事件
                    Log.e("-------", "滚动事件的触发");
                }
                return false;
            }
        });
        //滑动
        main_hor = (HorizontalScrollView) findViewById(R.id.main_hor);
        main_hor.setOnTouchListener(new MyGestureListener(this));
        //长按PopupWindow
        mian_te = (TextView) findViewById(R.id.mian_te);
        mian_te.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showPopupWindow();
                return true;
            }
        });
    }

    /**
     * 滑动
     * 继承GestureListener，重写left和right方法
     */
    private class MyGestureListener extends GestureListener {
        public MyGestureListener(Context context) {
            super(context);
        }

        @Override
        public boolean left() {
            Log.e("test", "向左滑啦，好吗啦");
            return super.left();
        }

        @Override
        public boolean right() {
            Log.e("test", "向右滑，对的");
            return super.right();
        }
    }

    private void showPopupWindow() {

        contentView = View.inflate(MainActivity.this, R.layout.pop_lay, null);
        //实例化一个对象
        popupWindow = new PopupWindow(contentView,1000,1000);
        //设置 popupWindow弹框的触屏属性
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        //得到它的宽和高
        int popupWidth = popupWindow.getWidth();
        int popupHeight = popupWindow.getHeight();
        int width = mian_te.getWidth();
        int height = mian_te.getHeight();
        popupWindow.showAsDropDown(mian_te, (width - popupWidth) / 2, -(popupHeight + height));

    }

}
