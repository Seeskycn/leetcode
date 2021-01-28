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
 * @Date: 2021/1/11 22:10
 * @Description:
 */
public class Question31 {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,2,1,3,5,3,21,6,3,7,9,0};
        nextPermutation(num);
    }

    public static void nextPermutation(int[] nums) {
        bbSort(nums);
        for (int i = nums.length-1; i >=1 ; i--) {
            if(nums[i]==nums[i-1]){
                for (int j = i; j < nums.length-1; j++) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int i : nums) {
            System.out.print(i+ " ");
        }
    }

    public static void bbSort(int[] nums){
        for (int j = 0; j < nums.length - 1; j++) {
            for (int i = 0; i < nums.length-j-1; i++) {
                if(nums[i]>nums[i+1]){
                    int temp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}
