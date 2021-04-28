package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-11
 */
public class Question134 {

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if(gas[i]<cost[i]){
                continue;
            }
            if(canReturn(gas,cost,i)){
                return i;

            }
        }

        return -1;


    }

    private static boolean canReturn(int[] gas, int[] cost, int i) {
        int start = i;
        int cur = gas[i];
        while (true){
            cur = cur - cost[i];
            if(cur < 0){
                return false;
            }
            i = i+1;
            if(i == gas.length){
                i = 0;
            }
            cur = cur + gas[i];
            if(i == start){
                return true;
            }
        }
    }
}
