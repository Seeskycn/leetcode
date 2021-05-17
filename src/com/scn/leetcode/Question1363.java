package com.scn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-05-13
 */
public class Question1363 {

    public static void main(String[] args) {

    }

    public static String largestMultipleOfThree(int[] digits) {

        int[] count = new int[9];

        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            count[digits[i]]++;
            sum += digits[i];
        }
        if (sum % 3 == 1) {
            int i = 1;
            while (i < count.length) {

            }

        }
        return "";

    }
}
