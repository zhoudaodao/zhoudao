package bawei.com.zhoudao20170407;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
     private String path="http://121.42.8.95:8090/AndroidServer/jzxy.json";
    private ListView mLv;
    private Book mBook;
    private MyBaseAdpter mBaseadpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        getServerData();
    }

    private void initview() {
        mLv = (ListView) findViewById(R.id.lv);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "点击条目"+position, Toast.LENGTH_SHORT).show();
            }
        });
        mLv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mBook.getContents().remove(position);
                mBaseadpter.notifyDataSetChanged();
                return true;
            }
        });
    }
    private void getServerData(){
        MyAnsycTask task=new MyAnsycTask();
        task.execute(path);
    }
    private class MyAnsycTask extends AsyncTask<String,Integer,Book>{

        @Override
        protected Book doInBackground(String... params) {
            String url=params[0];
            try {
                URL url1=new URL(url);
                HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestMethod("GET");
                if(connection.getResponseCode()==200){
                    InputStream inputStream = connection.getInputStream();
                    ByteArrayOutputStream bos=new ByteArrayOutputStream();
                    int len=0;
                    byte[] buffer=new byte[1024];
                    while((len=inputStream.read(buffer))!=-1){
                        bos.write(buffer,0,len);
                    }
                    bos.close();
                    inputStream.close();
                    String json = bos.toString("GBK");
                    Gson gson=new Gson();
                    mBook =  gson.fromJson(json, Book.class);
                    return mBook;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Book book) {
            super.onPostExecute(book);
            mBaseadpter = new MyBaseAdpter(book,MainActivity.this);
            mLv.setAdapter(mBaseadpter);
        }
    }
}
