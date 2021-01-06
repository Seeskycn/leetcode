package com.scn.leetcode;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-06
 */
public class Question20 {
//    '('，')'，'{'，'}'，'['，']'

    public boolean isValid(String s) {
        if(s == null && s.length()%2 !=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                Character peek = stack.peek();
                if(match(peek,c)){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }

        }
        return stack.isEmpty();
    }

    private boolean match(Character peek, char c) {
        switch (peek){
            case '(':
                return ')' == c;

            case '{':
                return '}'==c;
            case '[':
                return ']'==c;
            default:
                return false;
        }
    }

}
