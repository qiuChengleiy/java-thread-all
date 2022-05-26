package com.thread.base;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/5/26 10:06 AM
 * @description
 */
public class RunnableTest {
    public static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("hello 2");
        }

    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        System.out.println("hello 1");

        new Thread(() -> {
            System.out.println("hello3");
        }).start();
    }
}
