package bawei.com.biao.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Calendar;

import static android.R.attr.x;
import static android.R.attr.y;

/**
 * date:2017/5/5
 * author:周道(leovo)
 * funcation:
 */

public class RectView extends View{
    private OnDownActionListener mDown = null;
    private int width;
    private int height;
    private Paint  paint ;
    private Paint mPaintbut;

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int x, y;
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {
//            x = (int) event.getX();
//            y = (int) event.getY();
//            if (mDown != null) {
//                mDown.OnDown(x, y);
//            }
//            return true;
//        }
//        return super.onTouchEvent(event);
//    }
//
//    public void setOnDownActionListener(OnDownActionListener down) {
//        mDown = down;
//    }
//
//    public interface OnDownActionListener {
//        public void OnDown(int x, int y);
//    }
    public RectView(Context context) {
        super(context);
    }

    public RectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(30);

        mPaintbut = new Paint();
        mPaintbut.setColor(Color.YELLOW);
    }

    public RectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(new Rect(width / 2-220, height / 2 - 100, width / 2-100, height / 2-40 ),mPaintbut);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //获取指定年份月份中指定某天是星期几
        calendar.set(Calendar.DAY_OF_MONTH, day);  //指定日
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek)
        {
            case 1:
                canvas.drawText("星期日", width / 2-210, height / 2 - 60, paint);
                break;
            case 2:
                canvas.drawText("星期一", width / 2-210, height / 2 - 60, paint);
                break;
            case 3:
                canvas.drawText("星期二", width / 2-210, height / 2 - 60, paint);
                break;
            case 4:
                canvas.drawText("星期三", width / 2-210, height / 2 - 60, paint);
                break;
            case 5:
                canvas.drawText("星期四", width / 2-210, height / 2 - 60, paint);
                break;
            case 6:
                canvas.drawText("星期五", width / 2-210, height / 2 - 60, paint);
                break;
            case 7:
                canvas.drawText("星期六", width / 2-210, height / 2 - 60, paint);
                break;
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (mDown != null) {
                mDown.OnDown(width / 2 - 210, height / 2 - 60);
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void setOnDownActionListener(OnDownActionListener down) {
        mDown = down;
    }

    public interface OnDownActionListener {
        public void OnDown(int x, int y);
    }
}
