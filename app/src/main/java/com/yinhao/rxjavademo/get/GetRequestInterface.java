package com.yinhao.rxjavademo.get;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hp on 2018/1/22.
 */

public interface GetRequestInterface {

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<Translation> getCall();
}
