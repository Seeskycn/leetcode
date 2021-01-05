package com.scn.book.part1.question5;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-08-07
 */
public class StackOrder {

    public static void stackSort(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            if (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
