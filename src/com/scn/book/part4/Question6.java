package com.scn.book.part4;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-17
 */
public class Question6 {

    public static int getMaxResult(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int maxI = getMaxI(arr,i);
        }
        return 0;
    }

    private static int getMaxI(int[] arr, int i) {

        boolean hasRight = false;
        for (int j = i+1; j < arr.length; j++) {
            if(arr[i] != -1){
                hasRight = true;
            }
        }
        boolean hasLeft = false;
        for (int j = 0; j < i; j++) {
            if(arr[i] != -1){
                hasLeft = true;
            }
        }
        if(hasRight && hasLeft){

        }


        return 0 ;
    }
}
