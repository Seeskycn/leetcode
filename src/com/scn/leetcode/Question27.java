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
 * @Date: 2021/1/10 18:52
 * @Description:
 */
public class Question27 {
    public static void main(String[] args) {
        removeElement(new int[]{3,2,2,3}, 3);

    }


    public static int removeElement(int[] nums, int val) {

        int count = nums.length;
        int current = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count--;
                if (current == -1) {
                    current = i;
                } else {
                    continue;
                }
            } else {
                if (current != -1) {
                    nums[current] = nums[i];
                    nums[i] = val;

                    if (current++ == i) {
                        current = -1;
                    }
                }

            }

        }
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println(count);
        return count;
    }
}
