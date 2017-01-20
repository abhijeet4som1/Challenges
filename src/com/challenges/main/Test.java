package com.challenges.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String words = in.nextLine();
            Set<String> wordsToSearch = new HashSet<>(Arrays.asList(words.split(" ")));
            Map<Integer, Integer> hotelWordCount = new HashMap<>();
            // numberOfLines
            int n = in.nextInt();
            Integer hotelId;
            String review;
            while (n > 0) {
                hotelId = in.nextInt();
                in.nextLine();
                review = in.nextLine();
                increaseCount(hotelId, review.split(" "), wordsToSearch, hotelWordCount);
                n--;
            }
            System.out.println(hotelWordCount);
            hotelWordCount.entrySet().stream().sorted((e1, e2) -> {
                if (e1.getValue() == e2.getValue()) {
                    return e1.getKey() - e2.getKey();
                } else {
                    return e2.getValue() - e1.getValue();
                }
            }).forEachOrdered(e -> System.out.print(e.getKey() + " "));
        }
    }

    public static void increaseCount(int hotelId, String[] words, Set<String> wordsToSearch,
            Map<Integer, Integer> hotelWordCount) {
        Arrays.asList(words).parallelStream().forEach(word -> {
            if (wordsToSearch.contains(word)) {
                hotelWordCount.put(hotelId, hotelWordCount.getOrDefault(hotelId, 0) + 1);
            }
        });
    }

}
