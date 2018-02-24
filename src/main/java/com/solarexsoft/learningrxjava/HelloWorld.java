package com.solarexsoft.learningrxjava;

import com.google.gson.Gson;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by houruhou on 25/09/2017.
 */
public class HelloWorld {
    public static void main(String[] args) {
        Flowable.just("hello,world").subscribe(System.out::println);
        Flowable.just(1, 2,3,4,5, 6)
                //.scan((a,b) -> a+b)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        return integer + integer2;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
        Flowable.just(1,2,3,4,5)
                .scan((a,b) -> a+b)
                .subscribe(System.out::println);
        Flowable.just(1,2,3,4,5)
                .scan(100, (a,b) -> a+b)
                .subscribe(System.out::println);
        Flowable.just(4,100,5,3,2,98,70)
                .scan((a,b) -> a>b?b:a)
                .subscribe(System.out::println);
        Flowable.just("a", "aaaaa", "aa", "aaaaaaaaaaa", "aaa", "aaaa")
                .scan((a,b) -> a.length()>b.length()?a:b)
                .subscribe(System.out::println);
        Flowable.just(1,2,3,4,5)
                .groupBy((a) -> a<3?"A":"B")
                .subscribe(new Consumer<GroupedFlowable<String, Integer>>() {
                    @Override
                    public void accept(GroupedFlowable<String, Integer> stringIntegerGroupedFlowable) throws Exception {
                        stringIntegerGroupedFlowable.subscribe(new Consumer<Integer>() {
                            @Override
                            public void accept(Integer integer) throws Exception {
                                System.out.println(stringIntegerGroupedFlowable.getKey() + "\t" + integer);
                            }
                        });
                    }
                });
    }
}
