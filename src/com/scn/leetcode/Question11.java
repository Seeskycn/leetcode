package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： 双指针
 * @since 2020-07-13
 */
public class Question11 {

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,18,17,6};
        int maxArea = maxArea(arr);
        System.out.println(maxArea);
    }

    public static int maxArea(int[] height) {
        int result = 0;
        int start = 0;
        int finish = height.length-1;
        while (start != finish){
            result = Math.max(result,Math.min(height[start],height[finish])*(finish - start));
            if(height[start] < height[finish]){
                start ++;
            }else {
                finish -- ;
            }
        }
        return result;
    }
}
