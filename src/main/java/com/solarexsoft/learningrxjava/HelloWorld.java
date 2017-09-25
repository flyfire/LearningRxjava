package com.solarexsoft.learningrxjava;

import io.reactivex.Flowable;

/**
 * Created by houruhou on 25/09/2017.
 */
public class HelloWorld {
    public static void main(String[] args){
        Flowable.just("hello,world").subscribe(System.out::println);
    }
}
