package com.yinhao.rxjavademo.register;

import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by hp on 2018/1/23.
 */

public class Translation2 {
    private int status;
    private content content;

    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public void show() {

        Log.d(TAG, "show: "+content.out);
    }
}
