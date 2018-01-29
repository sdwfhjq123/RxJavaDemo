package com.yinhao.rxjavademo.throttle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.jakewharton.rxbinding2.view.RxView;
import com.yinhao.rxjavademo.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 功能防抖
 */
public class ThrottleActivity extends AppCompatActivity {
    private static final String TAG = "ThrottleActivity";

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_throttle);
        mButton = (Button) findViewById(R.id.button);

        RxView.clicks(mButton)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object value) {
                        Log.d(TAG, "发送了网络请求");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
