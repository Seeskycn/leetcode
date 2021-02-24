package com.scn.sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-23
 */
public class QuirkSort1 {

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
        if(L < R){

            SortUtils.swap(ints,L +(int) Math.round((R-L)),R);
            int[] res = partion(ints,L,R);

            quirkSort(ints,L,res[0]-1);
            quirkSort(ints,res[1]+1,R);
        }
    }

    private static int[] partion(int[] ints, int L, int R) {
        int less = L-1;
        int more = R;
        int index = L;

        while (index < more){
            if(ints[index] < ints[R]){
                SortUtils.swap(ints,index++,++less);
            }else if(ints[index] > ints[R]){
                SortUtils.swap(ints,index,--more);
            }else {
                index++;
            }

        }
        SortUtils.swap(ints,R,more);


        return new int[]{less+1,more};
    }


}
