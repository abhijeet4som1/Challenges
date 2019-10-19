package com.challenges.main;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue<Integer> firstQueue;
    private Queue<Integer> secondQueue;

    public StackWithTwoQueues(){
        firstQueue = new LinkedList<>();
        secondQueue = new LinkedList<>();
    }

    public boolean push(Integer item){
        if(firstQueue.isEmpty()){
            return secondQueue.add(item);
        } else {
            return firstQueue.add(item);
        }
    }

    public Integer pop(){
        if(firstQueue.isEmpty()){
            if(secondQueue.isEmpty()){
                return -1;
            }
            while(secondQueue.size() > 1){
                firstQueue.add(secondQueue.poll());
            }
            return secondQueue.poll();
        } else {
            while(firstQueue.size() > 1){
                secondQueue.add(firstQueue.poll());
            }
            return firstQueue.poll();
        }
    }

    public static void main(String[] args) {
        StackWithTwoQueues stack = new StackWithTwoQueues();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("After all push:"+stack.firstQueue + " second:"+stack.secondQueue);

        System.out.println("After first pop:"+stack.pop()+" first:"+stack.firstQueue+" second:"+stack.secondQueue);
        stack.push(40);
        System.out.println("After second push:"+stack.firstQueue + " second:"+stack.secondQueue);
        System.out.println("After second pop:"+stack.pop()+" first:"+stack.firstQueue+" second:"+stack.secondQueue);
        System.out.println("After third pop:"+stack.pop()+" first:"+stack.firstQueue+" second:"+stack.secondQueue);
        System.out.println("After fourth pop:"+stack.pop()+" first:"+stack.firstQueue+" second:"+stack.secondQueue);
        System.out.println("After fifth pop:"+stack.pop()+" first:"+stack.firstQueue+" second:"+stack.secondQueue);
    }
}
