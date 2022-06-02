package com.thread.base;

import java.util.concurrent.locks.LockSupport;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/6/2 9:50 AM
 * @description
 */
public class ThreadStateTest {
    public static void main1(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });

        System.out.println(t.getState());

        t.start();

        System.out.println(t.getState());

        try {
            t.start();
        } catch(IllegalThreadStateException e)  {
            System.out.println(t.getState());
        } finally {
            System.out.println(t.getState());
        }
    }

    public static void main2(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Thread t = new Thread(() -> {
            try {
                bank.doSomething("a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t1 = new Thread(() -> {
            try {
                bank.doSomething("b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();
        t1.start();

        Thread.sleep(1000);
        System.out.println("t----->" + t.getState());
        System.out.println("t1---->" + t1.getState());

        Thread.sleep(3000);
        System.out.println("t----->" + t.getState());
        System.out.println("t1---->" + t1.getState());

        Thread.sleep(3000);
        System.out.println("t----->" + t.getState());
        System.out.println("t1---->" + t1.getState());
    }


    public static void main3(String[] args) throws InterruptedException {
//        Thread t = new Thread(() -> {
//           System.out.println("a");
//        });

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b");
        });

//        t.start();
        t1.start();
        t1.join(60);

        System.out.println(t1.getState());
    }

    public static void main5(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
           System.out.println("a");
        });

        Thread t1 = new Thread(() -> {
            System.out.println("b");
        });

        t.start();
        t1.start();
        t1.join();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
           // LockSupport.parkNanos(3000*6000*4000L);
            LockSupport.parkUntil(System.currentTimeMillis() + 10* 1000L);
            System.out.println("a");
        });

        t.start();
        Thread.sleep(6000);
        System.out.println(t.getState());
    }
}


class Bank {
    public void doSomething(String name) throws InterruptedException {
        synchronized(this) {
            if("a".equals(name)) {
                this.wait(3000);
            }
            System.out.println(name);
        }
    }

    public void doSomething1(String name) throws InterruptedException {
        System.out.println(name);
    }
}
























