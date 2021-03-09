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
 * @Date: 2021/3/8 22:19
 * @Description:
 */
public class Question80 {

    public static void main(String[] args) {
        int[] ints = {1,  2, 3, 4};
        int i = removeDuplicates(ints);
        for (int j = 0; j < i; j++) {
            System.out.print( ints[j] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {

        int slow = -1;
        int count = 1;

        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if(nums[i] == cur){
                count++;
                if(count > 2){
                    if (slow == -1) {
                        slow=i;
                    }
                }else {
                    if(slow != -1){
                        swap(nums, slow++, i);
                    }
                }
            }else {
                cur = nums[i];
                count = 1;
                if(slow != -1){
                    swap(nums, slow++, i);
                }
            }


        }
        return slow == -1 ? nums.length : slow;
    }

    public static void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
