package com.example.xiaoshixunlianxi;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String url="http://gank.io/api/";
    @GET("data/福利/20/1")
    Observable<ListBeen> initData();
}
