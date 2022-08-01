package com.thread.tool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/8/1 09:13
 * @description
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);

        IntStream.range(0, 10).forEach(i -> {
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("worker 1------> " + i);
                    cyclicBarrier.await();

                    Thread.sleep(2000);
                    System.out.println("worker 2------> " + i);
                    cyclicBarrier.await();


                    Thread.sleep(2000);
                    System.out.println("worker 3------> " + i);
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        });

        System.out.println("completed !");
    }
}
