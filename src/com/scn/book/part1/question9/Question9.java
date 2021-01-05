package com.scn.book.part1.question9;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-08-11
 */
public class Question9 {

    public int maxRecSize(int[][] map){
        if(map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea,maxRecFromBottom(height));
        }
        return maxArea;
    }

    private int maxRecFromBottom(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty()&&height[i]<height[stack.peek()]){
                Integer j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer j = stack.pop();
            int k = stack.isEmpty() ? -1 :stack.peek();
            int curArea = (height.length - k -1)*height[j];
            maxArea = Math.max(maxArea,curArea);
        }
        return maxArea;
    }
}
