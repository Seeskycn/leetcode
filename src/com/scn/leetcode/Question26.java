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
 * @Date: 2021/1/9 15:36
 * @Description:
 */
public class Question26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length <= 1){
            return nums.length;
        }
        int curLength = 0;
        int curNum = nums[curLength];
        for (int i = 1; i < nums.length; i++) {
            if(curNum == nums[i]){
                continue;
            }else {
                curNum = nums[i];
                curLength++;
                nums[curLength] = nums[i];
            }
        }
        return curLength+1;
    }
}
