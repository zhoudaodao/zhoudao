package bawei.com.zuoye0415.Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by leovo on 2017/2/23.
 */

public class StreamUtils {
    public static String utils(InputStream inputStream) throws IOException {
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        byte[] buffer=new byte[1024];
        int len=0;
        while((len=inputStream.read(buffer))!=-1){
            bos.write(buffer,0,len);
        }
        bos.close();
        inputStream.close();
        String json=bos.toString();
        return json;
    }
}
