package bawei.com.zhoudao1502s201704010.utils;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * date:2017/4/10
 * author:周道(leovo)
 * funcation:
 */

public class ImageUtils {
    public static DisplayImageOptions geyoptions(int ImageId){
      DisplayImageOptions options=new DisplayImageOptions.Builder().showImageOnLoading(ImageId).showImageForEmptyUri(ImageId).build();
        return options;
    }
}
