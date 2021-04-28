package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-17
 */
public class Question45 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 1, 1, 1, 4}));
    }

    public static int jump(int[] nums) {
        if(nums == null || nums.length == 1){
            return 0;
        }

       int[] canReach = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            canReach[i] = nums[i] + i;
        }

        int i = nums.length -1;
        int index = 0;
        int count = 0;

        while (true){
            if(canReach[index] >=i){
                count++;
                i = index;
                if(index == 0){
                    break;
                }
                index = 0;
            }else {
                index++;
            }

        }
        return count;



    }


}
