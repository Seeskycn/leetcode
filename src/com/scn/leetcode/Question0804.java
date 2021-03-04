package com.scn.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
 * @Date: 2021/3/4 22:33
 * @Description:
 */
public class Question0804 {

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{});
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        getResult(nums,res,new LinkedList<>(),0);
        return res;
    }

    private static void getResult(int[] nums, List<List<Integer>> res,LinkedList<Integer> path,int begin) {
        if (begin == nums.length) {
            return;
        }
        for (int i = begin; i < nums.length; i++) {

            path.addLast(nums[i]);
            res.add( new ArrayList<Integer>(path));
            getResult(nums,res,path,++begin);
            path.removeLast();

        }

    }


}
