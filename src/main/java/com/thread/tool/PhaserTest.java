package com.thread.tool;

import java.util.concurrent.Phaser;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/8/8 09:54
 * @description
 */
public class PhaserTest {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(10);

        for (int i=0; i<10; i++){
            new Thread(() -> {
                try {
                    long millis = System.currentTimeMillis();

                    System.out.println(millis + "--1-->当前处于"+phaser.getPhase()+"阶段");
                    Thread.sleep(1000);

                    // wait
                    phaser.arriveAndAwaitAdvance();

                    System.out.println(millis + "---2--->当前处于"+phaser.getPhase()+"阶段");
                    Thread.sleep(1000);

                    // wait
                    phaser.arriveAndAwaitAdvance();


                    System.out.println(millis + "---3--->当前处于"+phaser.getPhase()+"阶段");
                    Thread.sleep(1000);

                    // wait
                    phaser.arriveAndAwaitAdvance();



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("主线程");
    }
}
