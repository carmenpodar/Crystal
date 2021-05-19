package com.company.prime;

public class Main {

    private static final String EXECUTION_LOG = "Execution time of method %s is %d";

    public static void main(String[] args) {
        //print all prime numbers from 0 to a given number
       printPrimeNumberToMax(100);
    }

    public static void printPrimeNumberToMax(int max) {
        long start = System.currentTimeMillis();
        for (int i = 2; i < max; i++) {
            long startPrime = System.nanoTime();
            boolean primeNumber = isPrimeNumber(i);
            long endPrime = System.nanoTime();
            System.out.printf(EXECUTION_LOG, "prime", endPrime - startPrime);
            if (primeNumber) {
                System.out.println(i);
            }
        }
        long end = System.currentTimeMillis();
        System.out.printf(EXECUTION_LOG, "primeToMax", end - start);
    }

    public static boolean isPrimeNumber(int number) {
        for (int j = 2; j <= number/2; j++) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }

}
