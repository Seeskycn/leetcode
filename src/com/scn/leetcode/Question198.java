package com.scn.leetcode;

/*
 *-----------------神兽保佑 -----------------
 *           ┌─┐        ┌─┐
 *       ┌─┘  ┴────┘  ┴─┐
 *       │                        │
 *       │        ───          │
 *       │  ─┬┘       └┬─   │
 *       │                        │
 *       │       ─┴─           │
 *       │                        │
 *       └───┐          ┌──┘
 *               │          │
 *               │          │
 *               │          │
 *               │          └────────────┐
 *               │                                    │
 *               │                                    ├─┐
 *               │                                    ┌─┘
 *               │                                    │
 *               └─┐  ┐  ┌─────┬─┐  ┌──┘
 *                   │  ┤  ┤          │  ┤  ┤
 *                   └─┴─┘          └─┴─┘
 *
 * ------------------代码无BUG!--------------
 * @Author: Seesky
 * @Date: 2021/2/2 20:56
 * @Description:
 */
public class Question198 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length+2];

        for (int i = nums.length - 1; i >=0 ; i--) {
            if(i == nums.length -1){
                dp[i] = nums[i];
                continue;
            }
            dp[i] = Math.max(nums[i]+dp[i+2],nums[i+1]);
        }
      return dp[0];


    }

    private static int getResult(int[] nums, int i) {
        if (i > nums.length - 1) {
            return 0;
        }
        if (i == nums.length - 1) {
            return nums[nums.length - 1];
        }
        return Math.max(nums[i] + getResult(nums, i + 2), getResult(nums, i + 1));
    }
}
