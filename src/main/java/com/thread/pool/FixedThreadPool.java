package com.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/6/20 9:39 AM
 * @description newFixedThreadPool
 */
public class FixedThreadPool {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        IntStream.range(0, 50).forEach(i -> {
            executor.execute(() -> {
                System.out.println(i);
            });
        });

    }
}
