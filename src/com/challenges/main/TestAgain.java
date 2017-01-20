package com.challenges.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestAgain {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int numberToSearch = in.nextInt();
            int size = in.nextInt();
            Map<Integer, Boolean> binmap = new HashMap<>();
            int number, temp;
            while (size > 0) {
                number = in.nextInt();
                temp = numberToSearch - number;
                // checking for condition
                if (temp >= 0 && binmap.getOrDefault(temp, false)) {
                    System.out.println(1);
                    return;
                }
                binmap.put(number, true);
                size--;
            }
            System.out.println(0);
        }

    }

}
