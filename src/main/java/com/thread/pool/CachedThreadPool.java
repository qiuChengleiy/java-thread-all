package com.thread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/6/20 9:25 AM
 * @description newCachedThreadPool
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        IntStream.range(0, 50).forEach(i -> {
//            executor.execute(() -> {
//                System.out.println(i);
//            });

            Future<Integer> future = executor.submit(() -> i);
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }
}
