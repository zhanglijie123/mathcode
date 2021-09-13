package 面试;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Four {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        //在这里创建一个线程或者线程池
        //异步执行下面的方法 TODO

        //方法一 打开注释即可执行
      TaskWithResult task = new TaskWithResult();
        FutureTask<Integer> future = new FutureTask<Integer>(task);
        Thread thread = new Thread(future);
        thread.start();
        Integer result = future.get();
        System.out.println(result);


        //下面是方法二
    /*    TaskWithResult task = new TaskWithResult();
        FutureTask<Integer> future = new FutureTask<Integer>(task);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 2, TimeUnit.MICROSECONDS,
            new ArrayBlockingQueue<Runnable>(2));
        threadPoolExecutor.execute(future);
        Integer result = future.get();*/

    /*    CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return sum();
            }
        });

        Integer result = future.get();*/
/*        CountDownLatch countDownLatch = new CountDownLatch(1);
        ArrayList<Integer> res = new ArrayList<>();
        new Thread(()->{
            res.add(sum());
            countDownLatch.countDown();
        }).start();
        //确保拿到result并输出
        countDownLatch.await();
        System.out.println("异步计算结果为" +res.get(0) );*/
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + "ms");
        //然后退出main

    }

    public static int sum() {
        return fibo(20);
    }

    public static int fibo(int a) {
        if (a < 2) {
            return 1;
        } else {
            return fibo(a - 1) + fibo(a - 2);
        }
    }

    static class TaskWithResult implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return  Four.sum();
        }
    }
}



