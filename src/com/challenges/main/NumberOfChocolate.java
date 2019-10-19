package com.challenges.main;

import java.util.Scanner;

public class NumberOfChocolate {
    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            if (t >= 1) {
                while (t > 0) {
                    System.out.println(getMaxChocolate(in.nextInt(), in.nextInt(), in.nextInt()));
                    if (t > 1)
                        in.nextLine();
                    t--;
                }
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    private static int getMaxChocolate(int money, int costOfChoclate, int numOfWrappers) {
        int result = money / costOfChoclate;
        int totalWrapp = result, chFrmw;
        while (totalWrapp >= numOfWrappers) {
            chFrmw = totalWrapp / numOfWrappers;
            totalWrapp = totalWrapp % numOfWrappers + chFrmw;
            result += chFrmw;
        }
        return result;
    }
}
