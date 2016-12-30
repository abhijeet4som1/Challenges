package com.challenges.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMinPrice {

    private List<Integer> priceList;
    private int startIndex;

    public ProductMinPrice() {
        // to start with index 1 added default value 0;
        priceList = new ArrayList<>(25);
        priceList.add(0);
        startIndex = -1;
    }

    public void addDataInList(int start, int end, int price) {
        if (start > 0 && start <= end && price >= 0) {
            if (startIndex < 1 || start < startIndex) {
                startIndex = start;
            }
            while (priceList.size() < start) {
                priceList.add(0);
            }
            while (start <= end) {
                if (start >= priceList.size()) {
                    priceList.add(price);
                } else if (price < priceList.get(start) || 0 == priceList.get(start)) {
                    priceList.set(start, price);
                }
                start++;
            }
        }
    }

    public void getMinimumPriceByTime() {
        int i, end = priceList.size() - 1;
        StringBuilder result = new StringBuilder("");
        for (i = startIndex; i < end; i++) {
            if (priceList.get(i) != priceList.get(i + 1)) {
                result.append(startIndex).append(" ").append(i).append(" ").append(priceList.get(i)).append("\n");
                startIndex = i + 1;
            }
        }
        result.append(startIndex).append(" ").append(i).append(" ").append(priceList.get(i));
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            // get number of sellers
            int n = in.nextInt();
            if (n >= 3 && n <= 10000) {
                ProductMinPrice t = new ProductMinPrice();
                while (n > 0) {
                    t.addDataInList(in.nextInt(), in.nextInt(), in.nextInt());
                    n--;
                }
                // get result
                t.getMinimumPriceByTime();
            } else {
                System.out.println("NA");
            }
        } finally {
            // closing resource
            in.close();
        }
    }

}
