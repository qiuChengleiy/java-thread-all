package com.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/6/20 10:11 AM
 * @description newSingleThreadExecutor
 */
public class SingleThreadPool {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        IntStream.range(0, 50).forEach(i -> {
            executor.execute(() -> {
                System.out.println(i);
            });
        });

    }
}
