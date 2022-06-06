package com.thread.base;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.Semaphore;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/6/6 9:54 AM
 * @description
 */
public class SyncTest {
    public static void main2(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }

    public static final Object lock = new Object();

    public static void main1(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main4(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println("1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("2");
                try {
                    Thread.sleep(1000);
                    lock.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main5(String[] args) throws InterruptedException {
        new Thread(new A.ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new A.ThreadB()).start();
    }

    public static void main6(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader);

        Thread t1 = new Thread(() -> {
            int rec = 0;
            try {
                while ((rec = reader.read()) != -1) {
                    System.out.print("\nt1 接收到 ----->" + (char)rec);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                writer.write("hello 我是 t2");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> local = new ThreadLocal<>();
        Thread t1 = new Thread(() -> {
            local.set("t1");
            System.out.println(local.get());
        });

        Thread t2 = new Thread(() -> {
            local.set("t2");
            System.out.println(local.get());
        });

        t1.start();
        t2.start();
    }

}


class A {
    private static volatile int num = 0;
    // private static int num = 0;

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (num < 5) {
                if(num == 4) {
                    System.out.println("threadA: " + num);
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (num < 5) {
                System.out.println("threadB: " + num);
                num = num + 1;
            }
        }
    }

}