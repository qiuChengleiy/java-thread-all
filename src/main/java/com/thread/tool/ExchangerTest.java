package com.thread.tool;

import java.util.concurrent.Exchanger;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/7/18 9:58 AM
 * @description
 */
public class ExchangerTest {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            try {
                System.out.println("1："
                        + exchanger.exchange("这是来自线程2的数据"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            try {
                System.out.println("2："
                        + exchanger.exchange("这是来自线程1的数据"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
