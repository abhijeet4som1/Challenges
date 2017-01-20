package com.challenges.main;

import java.util.Scanner;

/**
 * To find sum of number divisible by either 3 or 5 within a range.
 * 
 * @author Abhijeet
 *
 */
public class SumOfNoDivBY3and5 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            long numOfcases = in.nextLong();
            while (numOfcases > 0) {
                System.out.println(findSumWithInRange(in.nextLong()));
                numOfcases--;
            }
        }
    }

    private static long findSumWithInRange(long nextInt) {
        long sum = 0;
        // sum of number divisible by 3
        sum += getSumWithInRange(nextInt, 3);
        sum += getSumWithInRange(nextInt, 5);
        sum -= getSumWithInRange(nextInt, 15);
        return sum;
    }

    private static long getSumWithInRange(long range, int divisor) {
        if (range >= divisor) {
            long divi = (range - 1) / divisor;
            return divisor * ((divi * (divi + 1)) >> 1);
        } else {
            return 0;
        }
    }

}
