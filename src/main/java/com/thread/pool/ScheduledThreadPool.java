package com.thread.pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/6/20 9:52 AM
 * @description newScheduledThreadPool
 */
public class ScheduledThreadPool {
    public static void main(String[] args) throws Exception {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

        // executor.scheduleAtFixedRate(() -> System.out.println("---->" + new Date().getTime()), 1 , 5, TimeUnit.SECONDS);

        executor.scheduleWithFixedDelay(() -> System.out.println("---->" + new Date().getTime()), 1 , 5, TimeUnit.SECONDS);

    }
}
