package com.solarexsoft.learningrxjava;

import com.google.gson.Gson;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
//        Observable.just(null)
//                .subscribe(System.out::println, Throwable::printStackTrace);
        System.out.println("-----------------");
        String str = "this is a test to statistics the frequency of the charactes";
        List<Character> collect = str.chars().mapToObj(s -> (char) s).collect(Collectors.toList());
        Observable.fromIterable(collect)
                .filter(s -> !s.equals(' '))
                .groupBy(s -> s)
                .subscribe(s -> s.count().subscribe(it -> System.out.println(s.getKey() + "\t" + it)));


    }
}
