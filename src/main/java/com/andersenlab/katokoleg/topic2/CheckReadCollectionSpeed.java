package com.andersenlab.katokoleg.topic2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class CheckReadCollectionSpeed {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        fillList(syncList);
        fillList(copyOnWriteArrayList);
        System.out.println("SynchronizedList: ");
        checkTime(syncList);
        System.out.println("CopyOnWriteArrayList: ");
        checkTime(copyOnWriteArrayList);
    }

    public static void fillList(List<Integer> list) {
        for (int i = 0; i < 100; i++) {
            list.add(100);
        }
    }

    public static void checkTime(List<Integer> checkList) throws ExecutionException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Long> thread1 = ex.submit(new ListRunner(countDownLatch, 0, 50, checkList));
        Future<Long> thread2 = ex.submit(new ListRunner(countDownLatch, 0, 50, checkList));
        countDownLatch.countDown();

        System.out.println("Thread 1: " + thread1.get() / 1000);
        System.out.println("Thread 2: " + thread2.get() / 1000);
    }

    public static class ListRunner implements Callable<Long> {

        private CountDownLatch countDownLatch;
        private Integer min;
        private Integer max;
        private List<Integer> list;

        public ListRunner(CountDownLatch countDownLatch, Integer min, Integer max, List<Integer> list) {
            this.countDownLatch = countDownLatch;
            this.min = min;
            this.max = max;
            this.list = list;
        }

        @Override
        public Long call() throws Exception {
            countDownLatch.await();
            long startTime = System.nanoTime();
            for (int i = min; i < max; i++) {
                list.get(i);
            }
            long finishTime = System.nanoTime();
            return finishTime - startTime;
        }
    }
}

