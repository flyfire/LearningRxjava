package com.solarexsoft.learningrxjava.operators.retrywhen;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.solarexsoft.learningrxjava.model.Translation;
import com.solarexsoft.learningrxjava.net.NetworkRequest;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * Created by houruhou on 13/03/2018.
 */
public class RetryWhen {
    static int maxConnectCount = 10;
    static int currentRetryCount = 0;
    static int waitRetryTIme = 0;

    public static void main(String[] args) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Observable<Translation> observable = retrofit.create(NetworkRequest.class).getCall();
        observable.retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
                        System.out.println(currentRetryCount);
                        System.out.println(throwable);
                        if (currentRetryCount < maxConnectCount) {
                            currentRetryCount++;
                            waitRetryTIme = 1000 + currentRetryCount * 1000;
                            System.out.println(currentRetryCount + " --> " + waitRetryTIme);
                            return Observable.timer(waitRetryTIme, TimeUnit.MILLISECONDS);
                        } else {
                            return Observable.error(new Throwable("重试次数已超过设置次数"));
                        }
                    }
                });
            }
        }).subscribe(new Observer<Translation>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Translation translation) {
                System.out.println(translation);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
        /*.subscribe(new Consumer<Translation>() {
            @Override
            public void accept(Translation translation) throws Exception {
                System.out.println(translation);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("onComplete");
            }
        });*/
    }
}
