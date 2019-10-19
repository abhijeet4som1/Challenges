package com.challenges.main;

import java.util.*;

public class NumberOfPlatform {

    private static int getNumberOfPlatForm(Integer[] arr, Integer[] dep){
        Iterator<Integer> arrSet = new TreeSet<>(Arrays.asList(arr)).iterator();
        Set<Integer> depSet = new TreeSet<>(Arrays.asList(dep));

        Integer arrTime = arrSet.next();
        int result = 0;
        int currCount = 0;
        for(Integer depTime: depSet){
            System.out.println("Arr:"+arrTime+" depTime:"+depTime);
            while(arrTime < depTime){
                currCount++;
                if(currCount > result){
                    result = currCount;
                }
                if(arrSet.hasNext()){
                    arrTime=arrSet.next();
                } else {
                    return result;
                }
                System.out.println("Arr:"+arrTime+" depTime:"+depTime);
            }
            currCount--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Number of Platform:"+ getNumberOfPlatForm(new Integer[]{900,  940, 950,  1100, 1500, 1800},
                new Integer[]{910, 1200, 1120, 1130, 1900, 2000}));
    }
}
