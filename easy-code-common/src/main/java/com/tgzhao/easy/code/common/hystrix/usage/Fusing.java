package com.tgzhao.easy.code.common.hystrix.usage;

import com.netflix.hystrix.HystrixRequestLog;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.tgzhao.easy.code.common.comm.NamedThreadFactory;
import com.tgzhao.easy.code.common.hystrix.demo.GetOrderCommand;
import com.tgzhao.easy.code.common.hystrix.demo.Order;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tgzhao on 18/5/19.
 */
public class Fusing {
    private final ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5, 5, TimeUnit.DAYS, new SynchronousQueue<Runnable>(),
            new NamedThreadFactory("hystrixTest"), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {


    }

    public void runSimulatedRequestOnThread() {
        pool.execute(new Runnable() {

            @Override
            public void run() {
                HystrixRequestContext context = HystrixRequestContext.initializeContext();
                try {
                    Order previouslySavedOrder = new GetOrderCommand(100).execute();

                    System.out.println("Request => " + HystrixRequestLog.getCurrentRequest().getExecutedCommandsAsString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    context.shutdown();
                }
            }

        });
    }
}
