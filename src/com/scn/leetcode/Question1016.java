package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-05-13
 */
public class Question1016 {

    public static void main(String[] args) {

    }
    public boolean queryString(String S, int N) {
        for (int i = 0; i < N; i++) {
            if (!S.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
