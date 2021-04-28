package com.scn.leetcode;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-14
 */
public class Question85 {

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{}));
    }

    public static int maximalRectangle(char[][] matrix) {
        if(matrix==null && matrix.length == 0){
            return 0;
        }
        int max = 0;
        int[] res = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res[j] = matrix[i][j] == '0' ? 0:res[j]+1;
            }
            max = Math.max(max,largestRectangleArea(res));
        }
        return max;
    }

    public static int largestRectangleArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (arr[i] > arr[stack.peek()]) {
                    stack.push(i);
                } else {

                    while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                        Integer pop = stack.pop();
                        if (stack.isEmpty()) {
                            max = Math.max(max, arr[pop] * (i));
                        } else {
                            Integer peek = stack.peek();
                            max = Math.max(max, arr[pop] * (i - peek - 1));
                        }
                    }
                    stack.push(i);
                }
            }
        }
        int len = arr.length;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (stack.isEmpty()) {
                max = Math.max(max, arr[pop] * (len));
            } else {
                Integer peek = stack.peek();
                max = Math.max(max, arr[pop] * (len - peek - 1));
            }
        }
        return max;
    }
}
