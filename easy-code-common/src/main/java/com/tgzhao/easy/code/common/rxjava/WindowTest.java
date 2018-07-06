package com.tgzhao.easy.code.common.rxjava;

import com.tgzhao.easy.code.common.utils.DateUtils;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

import java.util.concurrent.TimeUnit;

/**
 * @author tgzhao
 * @since 2018/7/3
 */
public class WindowTest {
    public static void main(String[] args) throws InterruptedException {
        //usage1();

        System.out.println(DateUtils.date());
        Observable.interval(1, TimeUnit.SECONDS).take(12)
                .window(3, TimeUnit.SECONDS)
                .flatMap(new Func1<Observable<Long>, Observable<Long>>() {
                    @Override
                    public Observable<Long> call(Observable<Long> longObservable) {
                        return longObservable.reduce(new Func2<Long, Long, Long>() {
                            @Override
                            public Long call(Long aLong, Long aLong2) {
                                System.out.println(DateUtils.date() + "along + along2 = " + aLong + " + " + aLong2);
                                return aLong + aLong2;
                            }
                        });
                    }
                })
                .startWith((long) 100)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        System.out.println(DateUtils.date() + "after window flat: " + aLong);
                    }
                });

        TimeUnit.SECONDS.sleep(30);
    }

    private static void usage1() throws InterruptedException {
        // interval 没间隔1s生成一个Observable
        // take(12) 限制interval最多生成12个Observable
        // window 将前面的Observable间隔3s分隔成一个Observable
        Observable.interval(1, TimeUnit.SECONDS).take(12)
                .window(3, TimeUnit.SECONDS)
                .subscribe(new Action1<Observable<Long>>() {
                    @Override
                    public void call(Observable<Long> observable) {
                        System.out.println("subdivide begin......");
                        observable.subscribe(new Action1<Long>() {
                            @Override
                            public void call(Long aLong) {
                                System.out.println("Next:" + aLong);
                            }
                        });
                    }
                });

        TimeUnit.SECONDS.sleep(30);

        Integer[]items = {6,7,8,2,3,4,5};

        Observable<Integer> myObservable =  Observable.from(items)
                .startWith(1);
    }
}
