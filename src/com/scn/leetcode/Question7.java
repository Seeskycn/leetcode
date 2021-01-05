package com.scn.leetcode;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-07-15
 */
public class Question7 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        long n = 0;
        while (x !=0){
            n = n*10+x%10;
            x = x / 10;
        }
        return (int) n == n ?  (int) n : 0;

    }
}
