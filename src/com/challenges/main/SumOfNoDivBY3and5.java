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
            long numberOfTerm = (range - 1) / divisor;
            long result1 = divisor * ((numberOfTerm * (numberOfTerm + 1)) >> 1);

            //n/2(2a+(n-1)d) since a = d
            long result2 = (numberOfTerm*(divisor+divisor * numberOfTerm))/2;
            System.out.println("res1:"+result1+" res2:"+result2);
            return result1;
        } else {
            return 0;
        }
    }

}
