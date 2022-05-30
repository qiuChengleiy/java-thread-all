package com.thread.base;

import java.util.stream.IntStream;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/5/27 9:52 AM
 * @description
 */
public class ThreadMore {
    public static void main1(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hello");

            Thread t1 = new Thread(() -> {
                System.out.println("hello2");
            });
            System.out.println(t1.currentThread());
            t1.start();
        });
        System.out.println(t.currentThread());
        t.start();
    }

    public static void main2(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            Thread.yield();
            System.out.println("hello1");
        });

        Thread t1 = new Thread(() -> {
            System.out.println("hello2");
        });

        Thread t2= new Thread(() -> {
            System.out.println("hello3");
        });


        t.start();
        t1.start();
        t2.start();

        Thread.sleep(2000);
    }

    public static void main3(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello1");
        });
        t.join();

        Thread t1 = new Thread(() -> {
            System.out.println("hello2");
        });
        t1.join();

        Thread t2= new Thread(() -> {
            System.out.println("hello3");
        });


        t.start();
        t1.start();
        t2.start();

    }

    public static void main(String[] args) throws InterruptedException {
        IntStream.range(0, 10).forEach(i -> {
            Thread t = new Thread(() -> {
                System.out.println("hello" + i);
            });
            try {
                t.join();
                t.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
