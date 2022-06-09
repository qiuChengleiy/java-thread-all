package com.thread.base;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/6/9 10:30 AM
 * @description
 */
public class VolatileTest {
}



class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}





