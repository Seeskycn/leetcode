package com.scn.book.part1.question1;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-07-31
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(Integer num){
        if(stackMin.isEmpty()){
            stackMin.push(num);
        }else{
           if(num<=this.getMin()){
               stackMin.push(num);
           }
        }
        stackData.push(num);
    }

    public Integer pop(){
        Integer dataHead = stackData.pop();
        if(dataHead == getMin()){
            stackMin.pop();
        }
        return dataHead;
    }

    public Integer getMin(){
        return stackMin.peek();
    }
}
