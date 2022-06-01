package com.thread.base;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/6/1 4:03 PM
 * @description
 */
public class ThreadGroupTest {
    public static void main1(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getThreadGroup().getName());
        }).start();
        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }

    public static void main2(String[] args) {
        new Thread(() -> {
            System.out.println("default level: {}" + Thread.currentThread().getPriority());
        }).start();
    }

    public static void main3(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hello " +  Thread.currentThread().getPriority());
            System.out.println("default level: {}" + Thread.currentThread().getPriority());
        });
        t.setPriority(3);

        Thread t1 = new Thread(() -> {
            System.out.println("hello " +  Thread.currentThread().getPriority());
            System.out.println("default level: {}" + Thread.currentThread().getPriority());
        });
        t1.setPriority(7);

        Thread t2 = new Thread(() -> {
            System.out.println("hello " +  Thread.currentThread().getPriority());
            System.out.println("default level: {}" + Thread.currentThread().getPriority());
        });
        t2.setPriority(10);


        t.start();
        t1.start();
        t2.start();
    }

    public static void main4(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hello " +  Thread.currentThread().getPriority());
            System.out.println("default level: {}" + Thread.currentThread().getPriority());
        });
        t.setDaemon(true); // 默认为false
        t.setPriority(10);

        Thread t1 = new Thread(() -> {
            System.out.println("hello " +  Thread.currentThread().getPriority());
            System.out.println("default level: {}" + Thread.currentThread().getPriority());
        });
        t1.setPriority(7);

        t.start();
        t1.start();
    }

    public static void main5(String[] args) {
        // 指定 name 为 g1的线程组
        ThreadGroup group = new ThreadGroup("g1");
        group.setMaxPriority(4);

        Thread t = new Thread(group, () -> {
            System.out.println("hello " +  Thread.currentThread().getPriority());
            System.out.println("default level: {}" + Thread.currentThread().getPriority());
        }, "t0");
        t.setPriority(10);
        t.start();
    }

    public static void main6(String[] args) throws InterruptedException {
        // 指定 name 为 g1的线程组
        ThreadGroup group = new ThreadGroup("g1");
        group.setMaxPriority(4);

        Thread t = new Thread(group, () -> {
            System.out.println("hello " +  Thread.currentThread().getPriority());
            System.out.println("default level: {}" + Thread.currentThread().getPriority());
        }, "t0");
        t.setPriority(10);
        t.start();

        // 复制线程组
        System.out.println(group.activeCount());
        Thread[] list = new Thread[group.activeCount()];
        group.enumerate(list);

        Thread.sleep(3000);
        System.out.println(list[0].getName());

    }

    public static void main(String[] args) {
        // 指定 name 为 g1的线程组
        ThreadGroup group = new ThreadGroup("g1") {
            // 统一异常捕获
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage()); // t0: 我出错了
            }
        };
        group.setMaxPriority(4);

        Thread t = new Thread(group, () -> {
            System.out.println("hello " +  Thread.currentThread().getPriority());
            System.out.println("default level: {}" + Thread.currentThread().getPriority());
            throw new RuntimeException("我出错了");
        }, "t0");
        t.setPriority(10);
        t.start();
    }

}
