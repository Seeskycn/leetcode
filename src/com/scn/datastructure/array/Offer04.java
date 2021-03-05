package com.scn.datastructure.array;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-03
 */
public class Offer04 {

    public static void main(String[] args) {
        int[][] arr = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(arr, 20));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }

        int i = 0;
        int j = matrix[i].length-1;

        while (i<matrix.length && j >=0){
            if(matrix[i][j]<target){
                i++;
            }else if(matrix[i][j]>target){
                j--;
            }else {
                return true;
            }


        }
        return false;
    }
}
