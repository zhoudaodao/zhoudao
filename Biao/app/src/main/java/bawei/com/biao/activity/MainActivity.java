package bawei.com.biao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bawei.com.biao.R;
import bawei.com.biao.view.RectView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RectView view= (RectView) findViewById(R.id.view);
        view.setOnDownActionListener(new RectView.OnDownActionListener() {

            @Override
            public void OnDown(int x, int y) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
//        Button but= (Button) findViewById(R.id.but);
//        Calendar calendar = Calendar.getInstance();
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        //获取指定年份月份中指定某天是星期几
//        calendar.set(Calendar.DAY_OF_MONTH, day);  //指定日
//        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//        switch (dayOfWeek)
//        {
//            case 1:
//                but.setText("星期日");
//                break;
//            case 2:
//                but.setText("星期一");
//                break;
//            case 3:
//                but.setText("星期二");
//                break;
//            case 4:
//                but.setText("星期三");
//                break;
//            case 5:
//                but.setText("星期四");
//                break;
//            case 6:
//                but.setText("星期五");
//                break;
//            case 7:
//                but.setText("星期六");
//                break;
//        }
    }
}
