package com.yinhao.rxjavademo.merge;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.yinhao.rxjavademo.R;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 2018/1/25.
 */

public class ZipAcitivity extends AppCompatActivity {
    private static final String TAG = "ZipAcitivity";

    // 定义Observable接口类型的网络请求对象
    Observable<Translation1> observable1;
    Observable<Translation2> observable2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// 步骤1：创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
                .build();

        // 步骤2：创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);

        // 步骤3：采用Observable<...>形式 对 2个网络请求 进行封装
        observable1 = request.getCall().subscribeOn(Schedulers.io()); // 新开线程进行网络请求1
        observable2 = request.getCall_2().subscribeOn(Schedulers.io());// 新开线程进行网络请求2
        // 即2个网络请求异步 & 同时发送
        Observable.zip(observable1, observable2, new BiFunction<Translation1, Translation2, String>() {
            @Override
            public String apply(Translation1 translation1, Translation2 translation2) throws Exception {

                return translation1.show() + "&" + translation2.show();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        // 结合显示2个网络请求的数据结果
                        Log.d(TAG, "最终接收到的数据是：" + s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "登录失败");
                    }
                });
    }
}
