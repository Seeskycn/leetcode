package com.scn.book.part1.question10;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-08-13
 */
public class Question10 {
    public static void main(String[] args) {
        int[] ints = {1, 2,7, 3, 2, 6, 7, 4, 9};

        int num = getNum(ints, 5);

        System.out.println(num);
    }

    public static int getNum(int[] arrays, int num) {
        if (arrays == null || arrays.length == 0 || num < 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();

        int i = 0;
        int j = 0;

        int res = 0;
        while (i < arrays.length) {
            while (j < arrays.length) {
                if(qmin.isEmpty() || qmin.peekLast() != j){
                    while (!qmin.isEmpty() && arrays[qmin.peekLast()] >= arrays[j]) {
                        qmin.pollLast();
                    }
                    qmin.addLast(j);
                    while (!qmax.isEmpty() && arrays[qmax.peekLast()] <= arrays[j]) {
                        qmax.pollLast();
                    }
                    qmax.addLast(j);
                }
                if (arrays[qmax.getFirst()] - arrays[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            res += j - i;
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            i++;
        }
        return res;
    }



}

