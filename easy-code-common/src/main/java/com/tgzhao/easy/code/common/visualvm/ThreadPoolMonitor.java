package com.tgzhao.easy.code.common.visualvm;

import com.tgzhao.easy.code.common.comm.NamedThreadFactory;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tgzhao on 18/5/19.
 */
public class ThreadPoolMonitor {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(10, 30, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5),
                new NamedThreadFactory("MonitorTest"));

        int pointer = 0;
        while (true) {
            tpe.execute(() -> {
                try {
                    int slpSecond = new Random().nextInt(5);
                    TimeUnit.SECONDS.sleep(slpSecond);
                    System.out.println(Thread.currentThread().getName() + "  " + slpSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

            if (pointer++ < 100) {
                TimeUnit.MILLISECONDS.sleep(100);
            } else {
                TimeUnit.SECONDS.sleep(1);
            }
        }


    }
}
