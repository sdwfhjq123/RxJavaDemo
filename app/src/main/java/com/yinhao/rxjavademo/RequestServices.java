package com.yinhao.rxjavademo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by hp on 2018/1/19.
 */

public interface RequestServices {

    //请求方式为GET，参数为basil2style，因为没有变量所以下面getString方法也不需要参数
    @GET("basil2style")
    //定义返回的方法，返回的响应体使用了ResponseBody
    Call<StringBean> getString();
    // 注解里传入 网络请求 的部分URL地址
    // Retrofit把网络请求的URL分成了两部分：一部分放在Retrofit对象里，另一部分放在网络请求接口里
    // 如果接口里的url是一个完整的网址，那么放在Retrofit对象里的URL可以忽略
    // getCall()是接受网络请求数据的方法


}
