package com.thread.tool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author qcl
 * @version 1.0
 * @date 2022/8/15 10:53
 * @description
 */
public class ForkJoinTest {

    // 首先继承 RecursiveTask 并重写compute方法
    public static class TaskDemo extends RecursiveTask<Integer> {

        private Integer i = 0;

        private Integer num;

        public TaskDemo(Integer num) {
            this.num = num;
        }

        @Override
        protected Integer compute() {
            // 判断任务是否拆分到合适数量
            if(num > 20) {
                // 任务拆分完成后进行计算
                for(int index=0; index < 200; index++) {
                    i ++;
                }
                return i;
            }else {
                // 拆分成两个任务
                TaskDemo t1 = new TaskDemo(num + 1);
                t1.fork();

                TaskDemo t2 = new TaskDemo(num + 2);
                t2.fork();

                return t1.join() + t2.join();
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long start = System.currentTimeMillis();
        // 创建线程池
        ForkJoinPool pool = new ForkJoinPool();

        // 捕获返回的最终结果
        ForkJoinTask<Integer> taskFuture = pool.submit(new TaskDemo(0));
        Integer result = taskFuture.get();
        System.out.println("最终结果 >>>> " + result);
        Long end = System.currentTimeMillis();
        System.out.println("耗时 >>> " + (end -start) + "ms");
    }
}
