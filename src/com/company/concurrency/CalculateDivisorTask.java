package com.company.concurrency;

import java.util.concurrent.Callable;

public class CalculateDivisorTask implements Callable<Result> {

    private int min;
    private int max;

    CalculateDivisorTask(int min, int max) {
       this.min = min;
       this.max = max;
    }

    @Override
    public Result call() throws Exception {
        System.out.println("Executing task for "+ min + " " + max);
        int maxNoOfDivisors = 0;
        int number = min;
        for (int i = min; i <max; i++) {
            int divisors = countDivisors(i);
            if(divisors >  maxNoOfDivisors) {
                maxNoOfDivisors = divisors;
                number = i;
            }
        }

        Result result = new Result();
        result.setNoOfDivisors(maxNoOfDivisors);
        result.setNumber(number);
        System.out.println("Finished executing task for "+ min + " " + max);
        return result;
    }

    private int countDivisors(int number) {
        int noOfDivisors = 0;
        for (int j = 2; j <= number/2; j++) {
            if (number % j == 0) {
                noOfDivisors++;
            }
        }
        return noOfDivisors;
    }

}
