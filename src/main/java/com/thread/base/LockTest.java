package com.thread.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/6/14 9:20 AM
 * @description
 */
public class LockTest {
    private static Lock lock = new ReentrantLock();

    private static  int count = 0;

    private static void add() {
        try {
            //加锁
            lock.lock();
            count++;
            //重入锁
            reduce1();
        } finally {
            // 记得释放锁
            lock.unlock();
            System.out.println(count);
        }
    }

    private static void reduce(){
        // 加锁
        lock.lock();
        count--;
        // 释放锁
        lock.unlock();
    }

    private static void reduce1(){
        if(lock.tryLock()) {
            try {
                count--;
            }finally {
                // 释放锁
                lock.unlock();
            }
        }else {
            System.out.println("no");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(LockTest::add).start();
        }
    }
}
