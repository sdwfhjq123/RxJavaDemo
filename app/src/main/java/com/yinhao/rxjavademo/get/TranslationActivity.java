package com.yinhao.rxjavademo.get;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.yinhao.rxjavademo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 2018/1/22.
 */

public class TranslationActivity extends AppCompatActivity {

    public static String BASE_URL = "http://fy.iciba.com";

    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text_view);

        // 使用Retrofit封装的方法
        request();
    }

    private void request() {

        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //创建网络接口的实例
        GetRequestInterface requestInterface = retrofit.create(GetRequestInterface.class);
        //对发送接口进行封装
        Call<Translation> call = requestInterface.getCall();
        //发送网络请求(异步)
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                //步骤7：处理返回的数据结果
                response.body().show();
                String result = response.body().toString();
                mTextView.setText(result);
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {

            }
        });
    }
}
