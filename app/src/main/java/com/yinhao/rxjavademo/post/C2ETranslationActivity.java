package com.yinhao.rxjavademo.post;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.yinhao.rxjavademo.R;
import com.yinhao.rxjavademo.get.GetRequestInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 2018/1/22.
 */

public class C2ETranslationActivity extends AppCompatActivity {

    public static String BASE_URL = "http://fanyi.youdao.com/";

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
        com.yinhao.rxjavademo.post.GetRequestInterface requestInterface = retrofit.create(com.yinhao.rxjavademo.post.GetRequestInterface.class);
        //对发送接口进行封装
        Call<Translation1> call = requestInterface.getCall("I love you");

        call.enqueue(new Callback<Translation1>() {
            @Override
            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                String tgt = response.body().getTranslateResult().get(0).get(0).getTgt();
                mTextView.setText(tgt);
            }

            @Override
            public void onFailure(Call<Translation1> call, Throwable t) {

            }
        });
    }
}
