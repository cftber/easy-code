package com.tgzhao.easy.code.common.rxjava;

import com.google.common.collect.Lists;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.TimeUnit;

/**
 * @author tgzhao
 * @since 2018/5/12
 */
public class SimpleUsage {
  public static void main(String[] args) {
    Observable.just("one", "two").subscribe(input -> System.out.println(input));

    Observable.from(Lists.newArrayList("aaa", "bbbb")).subscribe(input -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(input);
    });
    System.out.println(Observable.from(Lists.newArrayList("eeeee")).toBlocking().first());
  }
}
