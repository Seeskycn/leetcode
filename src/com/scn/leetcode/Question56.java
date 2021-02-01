package com.scn.leetcode;

import javax.lang.model.element.VariableElement;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-26
 */
public class Question56 {
    public static void main(String[] args) {
        int[][] merge = merge(new int[][]{{1, 4}, {2, 3}});
        for (int[] ints : merge) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Stack<int[]> stack = new Stack<>();
        for (int[] interval : intervals) {
            if (stack.isEmpty()) {
                stack.push(interval);
            }else {
                merge(stack,interval);
            }
        }
        int[][] res = new int[stack.size()][1];
        int index = stack.size()-1;
        while (!stack.isEmpty()){
            res[index] = stack.pop();
            index--;
        }
        return res;
    }

    private static void merge(Stack<int[]> stack, int[] interval) {
        int[] pop = stack.peek();
        if(pop[1]>=interval[0]){
            if(pop[1]<interval[1]){
                pop[1]=interval[1];
            }
        }else {
            stack.push(interval);
        }
    }

}
