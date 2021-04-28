package com.scn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-15
 */
public class Offer59I {

    public static void main(String[] args) {
        for (int i : maxSlidingWindow(new int[]{1,-1}, 1)) {
            System.out.print(i + " ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        if(nums.length <= k){
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(nums[i],max);
            }
            return new int[]{max};
        }

        for (int i = 0; i < nums.length; i++) {
            if(i<k){
                if (linkedList.isEmpty()) {
                    linkedList.addLast(i);
                }else {
                    while (!linkedList.isEmpty() && nums[linkedList.getLast()] < nums[i]){
                        linkedList.removeLast();
                    }
                    linkedList.addLast(i);
                }
            }else {
                res.add(nums[linkedList.peek()]);
                while (!linkedList.isEmpty() && linkedList.peek()<=(i-k) ){
                    linkedList.pop();
                }
                while (!linkedList.isEmpty() && nums[linkedList.getLast()] < nums[i]){
                    linkedList.removeLast();
                }
                linkedList.addLast(i);
            }
        }
        res.add(nums[linkedList.peek()]);
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
