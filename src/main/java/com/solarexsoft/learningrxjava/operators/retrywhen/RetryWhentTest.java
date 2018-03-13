package com.solarexsoft.learningrxjava.operators.retrywhen;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

import java.util.concurrent.TimeUnit;

/**
 * Created by houruhou on 13/03/2018.
 */
public class RetryWhentTest {
    public static void main(String[] args) {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                System.out.println("emitting");
                Thread.sleep(1000);
                int i = 2/0;
                e.onError(new Throwable("always fail"));
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
                        System.out.println(throwable);
                        return Observable.just(1).timer(1, TimeUnit.SECONDS);
                    }
                });
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onsubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("oncomplete");
            }
        });
        /*
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                System.out.println("发射");
                e.onError(new Throwable("错误"));
            }
        }, BackpressureStrategy.BUFFER).retryWhen(new Function<Flowable<Throwable>, Publisher<?>>() {
            @Override
            public Publisher<?> apply(Flowable<Throwable> throwableFlowable) throws Exception {
                return throwableFlowable.flatMap(new Function<Throwable, Publisher<?>>() {
                    @Override
                    public Publisher<?> apply(Throwable throwable) throws Exception {
                        System.out.println(throwable);
                        return Flowable.just("1").delay(1, TimeUnit.SECONDS);
                    }
                });
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onsubscribe");
                s.request(10);
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("oncomplete");
            }
        });*/
    }
}
