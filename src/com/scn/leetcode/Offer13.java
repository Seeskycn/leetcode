package com.scn.leetcode;

import java.util.HashSet;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-03
 */
public class Offer13 {

    public static void main(String[] args) {
        System.out.println(movingCount(7, 2, 3));
    }

    public  static int movingCount(int m, int n, int k) {
        int totalCount = m * n;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                int sum = getSum(i,j);
                if(sum>k){
                    totalCount--;
                }
            }
        }
        return totalCount;

        //return getResult(m,n,k,0,0,new HashSet<String>());


    }

    private static int getSum(int i, int j) {
        int sum = 0;
        while (i>10){
            sum += i%10;
            i = i /10;
        }
        sum += i;

        while (j>10){
            sum += j%10;
            j = j /10;
        }
        sum += j;

        return sum;
    }

    private static int getResult(int m, int n, int k, int curI, int curJ, HashSet<String> set) {

        int sum = 0;
        // 往上
        if(canMove(m,n,curI,curJ-1,set)){
            sum += getResult(m,n,k,curI,curJ,set);
        }
        // 往下
        if(canMove(m,n,curI,curJ+1,set)){
            sum += getResult(m,n,k,curI,curJ,set);
        }

        // 往左


        return 0;
    }

    private static boolean canMove(int m, int n, int curI, int i, HashSet<String> set) {
        return false;
    }
}
