package com.tgzhao.easy.code.common.rxjava;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * @author tgzhao
 * @since 2018/7/5
 */
public class HystrixUsage {
    public static void main(String[] args) {
        Observable<String> observable = PublishSubject.create();

    }
}
