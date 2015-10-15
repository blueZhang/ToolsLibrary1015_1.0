package com.bluezhang.bitmapdisplay_1012_class.imagesutil;

/**
 * Author: blueZhang
 * DATE:2015/10/13
 * Time: 23:48
 * AppName:BlueZhang1013ExpendableListViewClass
 * PckageName:com.bluezhang.bitmapdisplay_1012_class.imagesutil
 */

import android.content.Context;
import android.widget.ImageView;
import com.bluezhang.bitmapdisplay_1012_class.cache.FileCache;
import com.bluezhang.bitmapdisplay_1012_class.tasks.AsyncDrawable;
import com.bluezhang.bitmapdisplay_1012_class.tasks.ImageLoadTask;

/**
 * 使用MD5加密之后并且进行了二次采样
 */
public class MD5ImageDownload {

    /**
     * 使用MD5机密之后的URL，进行二次采样之后返回bitmap对象并
     * 给ImageView设置加载的图片
     * @param context 上下文的对象
     * @param url URL
     * @param imageView 需要设置的ImageView对象昂、
     * @param width  进行二次采样需要的宽度
     * @param height 进行二次采样需要的宽度
     */

    public static void loadImageFromUrl(Context context,String url,ImageView imageView,int width,int height){
        FileCache.newInstance(context);
        ImageLoadTask task ;
        task = new ImageLoadTask(imageView,width,height);
        /**
         * 参考：@see:file:///E:/SDK/adt-bundle-windows-x86_64-20140321/sdk/docs/training/displaying-bitmaps/process-bitmap.html
         *
         */
        AsyncDrawable drawable = new AsyncDrawable(
                context.getResources(),
                null,
                task
        );
        imageView.setImageDrawable(drawable);
        task.execute(url);

    }


}
