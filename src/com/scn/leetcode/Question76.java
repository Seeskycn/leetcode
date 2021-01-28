package com.scn.leetcode;

import java.lang.reflect.Array;

/*
 *-----------------神兽保佑 -----------------
 *           ┌─┐        ┌─┐
 *       ┌─┘  ┴────┘  ┴─┐
 *       │                        │
 *       │        ───          │
 *       │  ─┬┘       └┬─   │
 *       │                        │
 *       │       ─┴─           │
 *       │                        │
 *       └───┐          ┌──┘
 *               │          │
 *               │          │
 *               │          │
 *               │          └────────────┐
 *               │                                    │
 *               │                                    ├─┐
 *               │                                    ┌─┘
 *               │                                    │
 *               └─┐  ┐  ┌─────┬─┐  ┌──┘
 *                   │  ┤  ┤          │  ┤  ┤
 *                   └─┴─┘          └─┴─┘
 *
 * ------------------代码无BUG!--------------
 * @Author: Seesky
 * @Date: 2021/1/28 22:10
 * @Description:
 */
public class Question76 {
    public static void main(String[] args) {
        int[] ints = {1};
        sortColors(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }

    }
    public static void sortColors(int[] nums) {
        int minIndex = 0;
        int maxIndex = nums.length-1;
        int i = 0;
        while (true){
            if(i == maxIndex){
                if(nums[i] == 0){
                    if(i != minIndex){
                        swap(nums, minIndex, i);
                        minIndex ++;
                        i++;
                    }
                }
                break;
            }
            if(nums[i] == 0){
                if(i != minIndex){
                    swap(nums, minIndex, i);
                }
                i++;
                minIndex ++;
            }else if(nums[i] == 2){
                if( i != maxIndex){
                    swap(nums, i, maxIndex);
                    maxIndex--;
                }
            }else {
                i++;
            }

        }

    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;


    }
}
