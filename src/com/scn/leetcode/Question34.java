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
 * @Date: 2021/1/13 22:01
 * @Description:
 */
public class Question34 {
    public static void main(String[] args) {
        for (int i : searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3)) {
            System.out.print(i + " ");
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0){
            return result;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            }
        } else {
            if (target < nums[0] || target > nums[nums.length - 1]) {
                return result;
            } else {
                int begin = 0;
                int end = nums.length - 1;
                while (true) {
                    int mid = (begin + end) / 2;
                    if (end <= begin || end - begin == 1) {
                        if (nums[begin] == target) {
                            result [0] = begin;
                            if (nums[end] == target) {
                                result[1] = end;
                            }else {
                                result[1] = begin;
                            }
                        }else {
                            if (nums[end] == target) {
                                result[0] = end;
                                result[1] = end;
                            }
                        }
                        return result;
                    }
                    if (nums[mid] > target) {
                        end = mid - 1;
                    } else if (nums[mid] < target) {
                        begin = mid + 1;
                    } else {

                        for (int i = begin; i < mid; i++) {
                            if (nums[i] == target) {
                                result[0] = i;
                                break;
                            }
                        }
                        for (int i = mid; i <=end; i++) {
                            if (nums[i] == target) {
                                result[1] = i;
                            }
                        }
                        if (result[0] == -1) {
                            result[0] = mid;
                        }
                        if (result[1] == -1) {
                            result[1] = mid;
                        }
                        return result;
                    }

                }
            }
        }
        return result;
    }
}
