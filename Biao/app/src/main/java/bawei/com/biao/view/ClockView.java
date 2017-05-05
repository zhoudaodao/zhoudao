package bawei.com.biao.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

/**
 * date:2017/5/5
 * author:周道(leovo)
 * funcation:
 */

public class ClockView extends View {
    private int width;
    private int height;
    private Paint mPaintLine;
    private Paint mPaintCircle;
    private Paint mPaintHour;
    private Paint mPaintMinute;
    private Paint mPaintSec;
    private Paint mPaintText;
    private Calendar mCalendar;
//    private Paint mPaintbut;
//    private Paint  paint ;
    public static final int NEED_INVALIDATE = 0X23;
    //每隔一秒，在handler中调用一次重新绘制方法
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case NEED_INVALIDATE:
                    mCalendar = Calendar.getInstance();
                    invalidate();//告诉UI主线程重新绘制
                    handler.sendEmptyMessageDelayed(NEED_INVALIDATE,1000);
                    break;
                default:
                    break;
            }
        }
    };
    public ClockView(Context context) {
        super(context);
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mCalendar = Calendar.getInstance();

        mPaintLine = new Paint();
        mPaintLine.setColor(Color.BLUE);
        mPaintLine.setStrokeWidth(10);

        mPaintCircle = new Paint();
        mPaintCircle.setColor(Color.GREEN);//设置颜色
        mPaintCircle.setStrokeWidth(10);//设置线宽
        mPaintCircle.setAntiAlias(true);//设置是否抗锯齿
        mPaintCircle.setStyle(Paint.Style.STROKE);//设置绘制风格

        mPaintText = new Paint();
        mPaintText.setColor(Color.BLUE);
        mPaintText.setStrokeWidth(10);
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setTextSize(40);

        mPaintHour = new Paint();
        mPaintHour.setStrokeWidth(15);
        mPaintHour.setColor(Color.BLUE);

        mPaintMinute = new Paint();
        mPaintMinute.setStrokeWidth(10);
        mPaintMinute.setColor(Color.BLUE);

        mPaintSec = new Paint();
        mPaintSec.setStrokeWidth(5);
        mPaintSec.setColor(Color.BLUE);
//
//        mPaintbut = new Paint();
//        mPaintbut.setColor(Color.YELLOW);
//
//        paint = new Paint();
//        paint.setColor(Color.RED);
//        paint.setTextSize(30);
        handler.sendEmptyMessage(NEED_INVALIDATE);//向handler发送一个消息，让它开启重绘
    }

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
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
//        canvas.drawRect(new Rect(width / 2-220, height / 2 - 100, width / 2-100, height / 2-40 ),mPaintbut);
//        Calendar calendar = Calendar.getInstance();
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        //获取指定年份月份中指定某天是星期几
//        calendar.set(Calendar.DAY_OF_MONTH, day);  //指定日
//        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//        switch (dayOfWeek)
//        {
//            case 1:
//                canvas.drawText("星期日", width / 2-210, height / 2 - 60, paint);
//                break;
//            case 2:
//                canvas.drawText("星期一", width / 2-210, height / 2 - 60, paint);
//                break;
//            case 3:
//                canvas.drawText("星期二", width / 2-210, height / 2 - 60, paint);
//                break;
//            case 4:
//                canvas.drawText("星期三", width / 2-210, height / 2 - 60, paint);
//                break;
//            case 5:
//                canvas.drawText("星期四", width / 2-210, height / 2 - 60, paint);
//                break;
//            case 6:
//                canvas.drawText("星期五", width / 2-210, height / 2 - 60, paint);
//                break;
//            case 7:
//                canvas.drawText("星期六", width / 2-210, height / 2 - 60, paint);
//                break;
//        }
        int circleRadius = 320;
        //画出大圆
        canvas.drawCircle(width / 2, height / 2, circleRadius, mPaintCircle);
        //画出圆中心
        canvas.drawCircle(width / 2, height / 2, 20, mPaintCircle);
        //依次旋转画布，画出每个刻度和对应数字
        for (int i = 1; i <= 12; i++) {
            canvas.save();//保存当前画布
            canvas.rotate(360/12*i,width/2,height/2);
            //左起：起始位置x坐标，起始位置y坐标，终止位置x坐标，终止位置y坐标，画笔(一个Paint对象)
            canvas.drawLine(width / 2, height / 2 - circleRadius, width / 2, height / 2 - circleRadius + 30, mPaintCircle);
            //左起：文本内容，起始位置x坐标，起始位置y坐标，画笔
            canvas.drawText(+i+"", width / 2, height / 2 - circleRadius + 70, mPaintText);
            canvas.restore();//
        }

        int minute = mCalendar.get(Calendar.MINUTE);//得到当前分钟数
        int hour = mCalendar.get(Calendar.HOUR);//得到当前小时数
        int sec = mCalendar.get(Calendar.SECOND);//得到当前秒数

        float minuteDegree = minute/60f*360;//得到分针旋转的角度
        canvas.save();
        canvas.rotate(minuteDegree, width / 2, height / 2);
        canvas.drawLine(width / 2, height / 2 - 250, width / 2, height / 2 + 40, mPaintMinute);
        canvas.restore();

        float hourDegree = (hour*60+minute)/12f/60*360;//得到时钟旋转的角度
        canvas.save();
        canvas.rotate(hourDegree, width / 2, height / 2);
        canvas.drawLine(width / 2, height / 2 - 200, width / 2, height / 2 + 30, mPaintHour);
        canvas.restore();

        float secDegree = sec/60f*360;//得到秒针旋转的角度
        canvas.save();
        canvas.rotate(secDegree,width/2,height/2);
        canvas.drawLine(width/2,height/2-300,width/2,height/2+40,mPaintSec);
        canvas.restore();

    }
}