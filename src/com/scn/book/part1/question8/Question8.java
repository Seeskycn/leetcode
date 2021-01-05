package com.scn.book.part1.question8;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-08-10
 */
public class Question8 {

    public static int[][] rightWay(int[] arrays) {
        int[][] res = new int[arrays.length][2];

        for (int i = 0; i < arrays.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur > 0) {
                if (arrays[cur] < arrays[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;

            while (cur < arrays.length) {
                if (arrays[cur] < arrays[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }

            res[i][0] = arrays[leftLessIndex];
            res[i][1] = arrays[rightLessIndex];
        }

        return res;

    }

    /**
     * 不重复数组获得左右相离最近的索引
     * @param arrays
     * @return
     */
    public static int[][] getNearLessNoRepeat(int[] arrays) {
        int[][] res = new int[arrays.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arrays.length; i++) {
            while (!stack.isEmpty() && arrays[stack.peek()] > arrays[i]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        // 处理剩下的
        while (!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    /**
     * 重复数组获得左右相离最近的数组
     * @return
     */
    public static int[][] getNearLess(int[] arrays){
        int[][] res = new int[arrays.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arrays.length; i++) {
            while (!stack.isEmpty()&& arrays[stack.peek().get(0)]>arrays[i]){
                List<Integer> pop = stack.pop();
                // 只取最晚加入队列的那一个
                int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
                for (Integer popIndex : pop) {
                    res[popIndex][0] = leftIndex;
                    res[popIndex][1] = i;
                }
            }
            if(!stack.isEmpty() && arrays[stack.peek().get(0)] == arrays[i]){
                stack.peek().add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()){
            List<Integer> pop = stack.pop();
            // 只取最晚加入队列的那一个
            int leftIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size()-1);
            for (Integer popIndex : pop) {
                res[popIndex][0] = leftIndex;
                res[popIndex][1] = -1;
            }
        }
        return res;
    }

}
