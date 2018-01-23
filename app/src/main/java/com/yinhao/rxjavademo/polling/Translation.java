package com.yinhao.rxjavademo.polling;

import android.util.Log;

/**
 * Created by hp on 2018/1/22.
 */

public class Translation {
    private static final String TAG = "Translation";
    private int status;
    private Content content;

    public static class Content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;

    }

    //定义 输出返回数据 的方法
    public void show() {
        //定义 输出返回数据 的方法
        Log.d(TAG, "RxJava: " + content.out);
    }

    @Override
    public String toString() {
        return "Content{" +
                "from='" + content.from + '\'' +
                ", to='" + content.to + '\'' +
                ", vendor='" + content.vendor + '\'' +
                ", out='" + content.out + '\'' +
                ", errNo=" + content.errNo +
                '}';
    }
}
