package com.scn.leetcode;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-31
 */
public class Question84 {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{4,2,0,3,2,5}));
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()){
                stack.push(i);
            }else {
                if(heights[stack.peek()] < heights[i]){
                    stack.push(i);
                }else if(heights[stack.peek()] == heights[i]){
                    stack.pop();
                    stack.push(i);
                }else {
                    while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                        Integer pop = stack.pop();
                        if(stack.isEmpty()){
                            max = Math.max(heights[pop] *i ,max);
                        }else {
                            Integer peek = stack.peek();
                            max = Math.max(heights[pop] * (i-peek-1),max);
                        }
                    }
                    stack.push(i);
                }
            }
        }
        int len = heights.length  ;
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            if(stack.isEmpty()){
                max = Math.max(heights[pop] * (len) ,max);
            }else {
                Integer peek = stack.peek();
                max = Math.max(heights[pop] * (len-peek-1),max);
            }
        }
        return max;

    }
}
