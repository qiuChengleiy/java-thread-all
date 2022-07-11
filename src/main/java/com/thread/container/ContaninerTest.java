package com.thread.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/7/4 9:42 AM
 * @description
 */
public class ContaninerTest {
    public static void main1(String[] args) {
        Vector v = new Vector();
        v.add("1");

        Thread t1 = new Thread(() -> {
            v.remove(0);
        });

        Thread t2 = new Thread(() -> {
            v.get(0);
        });

        t1.start();
        t2.start();
    }

    public static void main2(String[] args) {
        ArrayList v = new ArrayList();
        v.add("1");

        Thread t1 = new Thread(() -> {
            v.remove(0);
        });

        Thread t2 = new Thread(() -> {
            v.get(0);
        });

        t1.start();
        t2.start();
    }


    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        System.out.println(list.get(0));
    }
}
