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
 * @Date: 2021/1/12 22:16
 * @Description:
 */
public class Question33 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{2,3}, 2));
    }
    public static  int search(int[] nums, int target) {
        if(nums.length < 1){
            return -1;
        }
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }else {
                return -1;
            }
        }
        if(nums[0]>target && nums[nums.length -1 ]<target){
            return -1;
        }

        int begin = 0;
        int end = nums.length-1;
        boolean  inDa = target>=nums[0]?true:false;
        while (true){
            int mid = (end +begin )/2;
            if(end -begin == 1 || end == begin){
                if (nums[begin]==target) {
                    return begin;
                }else {
                    return nums[end]== target?end:-1;
                }
            }
            if(mid <= 0){
                return nums[mid]==target ? 0:-1;
            }
            if(inDa){
                if(nums[mid]<nums[0]){
                    // mid 没在递增区域
                    end = mid-1;
                    continue;
                }else {
                    // mid 已经在递1增区域
                    if(nums[mid]<target){
                        // 往右找
                        begin = mid+1;
                    }else if(nums[mid]>target){
                        // 往左找
                       end = mid-1;
                    }else {
                        return mid;
                    }
                }
            }else{
                if(nums[mid]>nums[nums.length-1]){
                    // mid 没在递2增区域
                    begin = mid+1;
                    continue;
                }else {
                    // mid 已经在递2增区域
                    if(nums[mid]<target){
                        // 往右找
                        begin = mid+1;
                    }else if(nums[mid]>target){
                        // 往左找
                        end = mid-1;
                    }else {
                        return mid;
                    }
                }
            }
        }
    }
}
