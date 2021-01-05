package com.scn.book.part1.question3;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-08-03
 */
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        int size = stack.size();
        for (int i = 0; i < size ; i++) {
            System.out.println(stack.pop());
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        Integer element = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(element);

    }

    private static Integer getAndRemoveLastElement(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }else {
            Integer element = getAndRemoveLastElement(stack);
            stack.push(result);
            return element;
        }
    }
}
