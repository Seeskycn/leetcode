package com.scn.book.part1.question7;

import java.util.LinkedList;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-08-10
 */
public class MaxWindows {

    public static void main(String[] args) {
        int[] arrays = {4,3,5,4,3,3,6,7};
        int w = 3;
        int[] maxWindows = getMaxWindows(arrays, w);
        for (int i = 0; i < maxWindows.length; i++) {
            System.out.println(maxWindows[i]);
        }
    }

    public static int[] getMaxWindows(int[] arrays , int w){
        if(arrays == null || w < 1 || arrays.length < w){
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arrays.length - w + 1];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            while (!qmax.isEmpty()&& arrays[qmax.peekLast()]<arrays[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i -w){
                qmax.pollFirst();
            }
            if(i>=w-1){
                res[index++] = arrays[qmax.peekFirst()];
            }
        }
        return res;
    }
}
