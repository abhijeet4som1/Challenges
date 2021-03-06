package com.challenges.main;

import java.util.stream.IntStream;

public class ArrayRotation {

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 20, 30, 40, 50, 60, 70 };
        rotateArray(arr, arr.length, 2);
        IntStream.of(arr).forEach(n -> System.out.print(n + " "));
    }

    public static void rotateArray(int[] arr, int n, int r) {
        int gcd = findGcd(r, n);
        System.out.println("gcd:"+gcd);
        int j, k, temp;
        for (int i = 0; i < gcd; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + r;
                System.out.println("k:"+k+" j:"+j+" r:"+r);
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                System.out.println("swapping indexes: j-"+arr[j]+" k-"+arr[k]+" i-"+i);
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    public static int findGcd(int n1, int n2) {
        while (n1 != n2) {
            if (n1 > n2)
                n1 = n1 - n2;
            else
                n2 = n2 - n1;
        }
        return n1;
    }

}
