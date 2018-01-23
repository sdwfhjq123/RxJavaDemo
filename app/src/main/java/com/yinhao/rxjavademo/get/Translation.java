package com.yinhao.rxjavademo.get;

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
        Log.i(TAG, "status: " + status);
        Log.i(TAG, "content.from: " + content.from);
        Log.i(TAG, "content.to: " + content.to);
        Log.i(TAG, "content.vendor: " + content.vendor);
        Log.i(TAG, "content.out: " + content.out);
        Log.i(TAG, "content.errNo: " + content.errNo);
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
