package com.scn.book.part1.question2;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-07-31
 */
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPop = new Stack<>();
        stackPush = new Stack<>();
    }

    private void pushToPop(){
        if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    private void add(Integer num){
        stackPush.push(num);
        pushToPop();
    }

    private Integer poll(){
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("no data");
        }
        pushToPop();
        return stackPop.pop();
    }

    private Integer peeK(){
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("no data");
        }
        pushToPop();
        return stackPop.peek();
    }
}
