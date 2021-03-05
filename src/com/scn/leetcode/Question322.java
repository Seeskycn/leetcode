package com.scn.leetcode;

import java.util.Arrays;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-25
 */
public class Question322 {

    public static void main(String[] args) {

        int[] ints = {186,419,83,408};
        System.out.println(coinChange(ints,6249));
    }
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return getResult(coins,amount,0,coins.length-1);
    }

    private static int getResult(int[] coins, int amount, int sum,int index) {
        if(amount == 0){
            return sum;
        }
        if(index == 0){
            if(amount % coins[index] == 0){
                sum += amount / coins[index];
                return sum;
            }else {
                return -1;
            }
        }
        while (index >= 0){
            if(coins[index]>amount){
                index--;
                continue;
            }else {
                // 拿
                int res = getResult(coins, amount - coins[index], sum + 1, index);
                if(res != -1){
                    return res;
                }

                // 不拿
                res = getResult(coins, amount, sum, index - 1);
                return res;

            }
        }

        return -1;
    }
}
