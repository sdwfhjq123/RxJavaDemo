package com.yinhao.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String[] mDatas = new String[]{"1", "2", "3", "4"};

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text_view);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantValue.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestServices requestServices = retrofit.create(RequestServices.class);
        Call<StringBean> call = requestServices.getString();
        call.enqueue(new Callback<StringBean>() {
            @Override
            public void onResponse(Call<StringBean> call, Response<StringBean> response) {
                StringBean body = response.body();
                Log.i(TAG, "onResponse: " + body.getId());
                Log.i(TAG, "onResponse: " + body.getLogin());
            }

            @Override
            public void onFailure(Call<StringBean> call, Throwable t) {

            }
        });
    }
}
