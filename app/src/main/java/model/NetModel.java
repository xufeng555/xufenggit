package model;

import com.example.xiaoshixunlianxi.ApiService;
import com.example.xiaoshixunlianxi.ListBeen;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetModel {

    public void getData(final CallBack callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<ListBeen> observable = retrofit.create(ApiService.class).initData();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListBeen>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListBeen listBeen) {
                        List<ListBeen.ResultsBean> results = listBeen.getResults();
                        callBack.setSueecss(results);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.setFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface CallBack{
        void setSueecss(List<ListBeen.ResultsBean> list);
        void setFail(String str);
    }
}
