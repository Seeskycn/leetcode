package com.scn.sort;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-23
 */
public class QuirkSort2 {

    public static void main(String[] args) {
        int[] ints = new int[]{1,5,4,2,3,8,9,1,4};
        sort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    private static void sort(int[] ints) {
        quirkSort2(ints,0,ints.length-1);
    }

    private static void quirkSort2(int[] ints, int L, int R) {
        if(L<R){
            int[] res = partion(ints,L,R);
            quirkSort2(ints,L,res[0]-1);
            quirkSort2(ints,res[1]+1,R);
        }

    }

    private static int[] partion(int[] ints, int L, int R) {
        int less = L - 1;
        int more = R;
        int cur = L;
        while (cur < more){
            if(ints[cur] < ints[R] ){
                SortUtils.swap(ints,cur++,++less);
            }else if (ints[cur] > ints[R]){
                SortUtils.swap(ints,cur,--more);
            }else {
                cur++;
            }
        }

        SortUtils.swap(ints,more,R);
        return new int[]{less+1,more};
    }
}
