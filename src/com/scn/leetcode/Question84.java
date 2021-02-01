package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-31
 */
public class Question84 {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{1,1}));
    }

    public static int largestRectangleArea(int[] heights) {
        if(heights.length == 1){
            return heights[0];
        }
        int maxSize = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = findLeft(heights,heights[i],i);
            int right = findRight(heights,heights[i],i);

            maxSize = Math.max(maxSize,heights[i]*(right+left+1));


        }
        return maxSize;

    }

    private static int findRight(int[] heights, int indexNum, int i) {
        int count = 0;
        for (int j = i+1; j < heights.length; j++) {
            if(heights[j]<indexNum){
                return count;
            }
            count++;
        }

        return count;
    }

    private static int findLeft(int[] heights, int indexNum, int i) {
        int count = 0;
        for (int j = i-1; j >= 0; j--) {
            if(heights[j]<indexNum){
                return count;
            }
            count++;
        }

        return count++;
    }
}
