package com.thread.base;

import java.util.concurrent.*;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/5/31 9:46 AM
 * @description
 */
public class CallableTest {

    public static class CallableDemo implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread());
            Thread.sleep(3000);
            return "hello";
        }
    }


    public static void main1(String[] args) throws Exception {
        CallableDemo demo = new CallableDemo();
        String result = demo.call();
        System.out.println(result);
        System.out.println("main");
    }

    public static void main2(String[] args) throws Exception {
        CallableDemo demo = new CallableDemo();
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(demo);

        new Thread(() -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("main");
    }

    public static void main(String[] args) throws Exception {
        CallableDemo demo = new CallableDemo();
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<String> futureTask = new FutureTask<>(demo);
        executor.submit(futureTask);
        System.out.println(futureTask.get());
    }
}
