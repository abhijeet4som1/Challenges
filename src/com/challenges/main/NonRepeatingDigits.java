package com.challenges.main;

import java.util.HashSet;
import java.util.Set;

public class NonRepeatingDigits {
    
    public static void main(String[] args) {
        Set<Integer> num=new HashSet<>();
        for(int i=1;i<=156;i++){
            if(!has_duplicate_digits(i))
            num.add(i);
        }
        
        System.out.println(num.size());
    }
    
    public static boolean has_duplicate_digits(int n) {
        Set<Integer> num=new HashSet<>();
        while(n>0){
            int lastDigit=n%10;
            if(num.contains(lastDigit)){
                return true;
            }else{
                num.add(lastDigit);
                n=n/10;
            }
        }
        return false;
    }
}
