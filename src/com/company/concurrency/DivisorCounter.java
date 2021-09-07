package com.company.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DivisorCounter {

    public static void main(String[] args) {
        countDivisors(10);
    }

    private static void countDivisors(int numberOfThreads) {
        System.out.println("Start calculation");
        long startTime = System.currentTimeMillis();
        List<Future<Result>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        int range = 10000/numberOfThreads;
        int start = 0;
        int end = range;
        for(int i = 0; i< numberOfThreads; i ++) {
            Future<Result> resultFuture = executorService.submit(new CalculateDivisorTask(start, end));
            futures.add(resultFuture);
            start = end + 1;
            end += range;
        }

        int maxDivisorCount = 0;
        int numberWithMostDivisors = 0;
        for(Future<Result> future: futures) {
            try {
                Result result = future.get();
                if(maxDivisorCount < result.getNoOfDivisors()) {
                    maxDivisorCount = result.getNoOfDivisors();
                    numberWithMostDivisors = result.getNumber();
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Max number of divisors " + maxDivisorCount + " number " + numberWithMostDivisors);
        System.out.println("Stop calculation. Execution time:"+ (System.currentTimeMillis() - startTime));
        executorService.shutdown();
    }

}
