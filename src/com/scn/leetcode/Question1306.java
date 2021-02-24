package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-03
 */
public class Question1306 {

    public static void main(String[] args) {
        System.out.println(canReach(new int[]{4,2,3,0,3,1,2},5));
    }
    public static boolean canReach(int[] arr, int start) {
        int[] dp = new int[arr.length];


        return getResult(arr, start,dp);

    }

    private static boolean getResult(int[] arr, int start, int[] dp) {
        if(dp[start] == 0){
            dp[start] = 1;
        }else {
            return false;
        }
        if(arr[start] == 0){
            return true;
        }
        if((start+arr[start])>arr.length && (start - arr[start])<0){
            return false;
        }
        if((start+arr[start])<arr.length){
            if(getResult(arr,start+arr[start],dp)){
                return true;
            }
        }
        if((start - arr[start])>=0){
           if(getResult(arr,start - arr[start],dp)) {
               return true;
           }
        }
        return false;
    }
}
