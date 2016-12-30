package com.challenges.main;

import java.util.Scanner;

/**
 * Utopian tree,A tree increases doubles its size in spring,increase it by one
 * in summer. if initial size is one then what will be the tree size after the
 * cycles. 1 mean spring,2 means spring then summer, hence in odd summer will be
 * extra in even both cycles will be of same number
 * 
 * @author Abhijeet
 *
 */
public class UtopianTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            // number of test cases
            int n = in.nextInt();
            while (n > 0) {
                int t = in.nextInt();
                System.out.println(((1 << ((t >> 1) + 1)) - 1) << t % 2);
                n--;
            }
        } finally {
            in.close();
        }
    }
}
