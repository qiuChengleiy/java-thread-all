package com.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/6/29 10:01 AM
 * @description 阻塞队列
 */
public class BlockingQueueTest {
    public static void main1(String[] args) {
        // 初始化 容量为3
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.add("1"));
        System.out.println(queue.add("2"));
        System.out.println(queue.add("3"));
        // System.out.println(queue.add("4"));

        System.out.println(queue.remove());
//
//        System.out.println(queue);

        System.out.println(queue.remove("3"));

        System.out.println(queue);
    }


    public static void main2(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.offer("1"));
        System.out.println(queue.offer("2"));
        System.out.println(queue.offer("3"));
        System.out.println(queue.offer("4"));
    }


    public static void main3(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.poll());
    }

    public static void main4(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.take());
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        queue.put("1");
        queue.put("2");
    }
}
