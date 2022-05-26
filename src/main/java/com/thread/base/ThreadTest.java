package com.thread.base;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/5/26 9:29 AM
 * @description
 */
public class ThreadTest {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("hello 2");
        }

    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("hello 1");
        myThread.start();
    }
}
