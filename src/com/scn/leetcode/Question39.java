package com.scn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-17
 */
public class Question39 {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,7,6,3,5,1},9));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        getResult(candidates,0,target,new LinkedList<>(),res);
        return res;
    }

    private static List<List<Integer>> getResult(int[] candidates, int begin, int target,LinkedList<Integer> path, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(path));
            return res;
        }
        if(begin >=candidates.length){
            return res;
        }
        for (int i = begin; i < candidates.length - 1; i++) {
            if(candidates[i] == target) {
                List<Integer> sub = new ArrayList<>(path);
                sub.add(candidates[i]);
                res.add(sub);
            }
        }
        // 不选单前
        getResult(candidates,begin+1,target,path, res);

        // 选择当前
        if(candidates[begin]<=target){
            path.addLast(candidates[begin]);
            getResult(candidates,begin,target-candidates[begin],path, res);
            path.removeLast();
        }

        return res;

    }

}
