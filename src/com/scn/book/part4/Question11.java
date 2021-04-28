package com.scn.book.part4;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-24
 */
public class Question11 {

    public static void main(String[] args) {
        String str1="abcde";
        String str2="bebcd";
        int[][] res = getDp(str1.toCharArray(),str2.toCharArray());

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getDp(char[] array1, char[] array2) {
        int[][] dp = new int[array1.length][array2.length];

        for (int i = 0; i < array1.length; i++) {
            dp[i][0] = array1[i] == array2[0] ? 1:0;
        }
        for (int i = 0; i < array2.length; i++) {
            dp[0][i] = array1[0] == array2[i] ? 1:0;
        }

        for (int i = 1; i < array1.length; i++) {
            for (int j = 1; j < array2.length; j++) {
                if(array1[i] == array2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }


        return dp;
    }
}
