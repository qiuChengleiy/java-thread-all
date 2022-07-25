package com.thread.tool;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/7/25 09:44
 * @description
 */
public class CountDownLaunchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        IntStream.range(0, 10).forEach(i -> {
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("worker ------> " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            }).start();
        });
        countDownLatch.await();
        System.out.println("completed !");
    }
}
