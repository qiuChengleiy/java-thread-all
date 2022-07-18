package com.thread.tool;

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/7/12 9:41 AM
 * @description 限制线程的数量
 */
public class SemaphoreTest {

    public static final class Task implements Runnable {
        private int num;
        private Semaphore semaphore;

        public Task(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                // 获取
                semaphore.acquire();

                System.out.println(String.format("num: %d, 剩余%d个资源, 还有%d个线程在等待", num, semaphore.availablePermits(), semaphore.getQueueLength()));

                System.out.println(System.currentTimeMillis());
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放
                System.out.println("释放资源");
                semaphore.release();
            }
        }
    }


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        IntStream.range(0, 20).forEach(i -> new Thread(new Task(i, semaphore)).start());
    }
}
