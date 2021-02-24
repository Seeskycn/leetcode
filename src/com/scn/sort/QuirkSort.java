package com.scn.sort;

import java.security.PublicKey;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-22
 */
public class QuirkSort {

    public static void main(String[] args) {
        int[] ints = new int[]{1,5,4,2,3};
        sort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    private static void sort(int[] ints) {

        quirkSort(ints,0,ints.length-1);
    }

    private static void quirkSort(int[] ints, int L, int R) {
        if(L<R){

            int[] res = partion(ints, L, R,ints[R]);
            quirkSort(ints,L,res[0]-1);
            quirkSort(ints,res[1]+1,R);

        }
    }

    private static int[] partion(int[] ints, int L, int R, int num) {
        int less = L - 1;
        int more = R;
        int cur = L;

        while (cur < more) {
            if (ints[cur] < num) {
                swap(ints,++less,cur++);
            } else if (ints[cur] > num) {
                swap(ints,cur,--more);
            } else {
                cur++;
            }
        }
        swap(ints,more,R);
        return new int[]{less+1,more};
    }

    private static void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

}
