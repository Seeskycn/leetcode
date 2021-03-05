package com.scn.leetcode;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-26
 */
public class Question402 {

    public static void main(String[] args) {
        System.out.println(removeKdigits("14023", 1));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            if(stack.isEmpty()){
                stack.push(num.charAt(i));
                continue;
            }else {
                Character peek = stack.peek();
                if(peek > num.charAt(i)){
                    stack.pop();
                    stack.push(num.charAt(i));
                    k--;
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return "";
    }
}
