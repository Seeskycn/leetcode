package com.scn.leetcode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-17
 */
public class Question40 {

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        getResult(candidates,0,new LinkedList<>(),target,res);
        return res;
    }

    private static List<List<Integer>> getResult(int[] candidates, int begin, LinkedList<Integer> path, int target, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(path));
            return res;
        }
        if(begin >= candidates.length){
            return res;
        }
        for (int i = begin; i < candidates.length; i++) {
            if(candidates[i] == target){
                List<Integer> result = new ArrayList<>(path);
                result.add(candidates[i]);
                res.add(result);
            }
        }
        getResult(candidates,begin+1,path,target, res);

        if(candidates[begin]<=target){
            path.addLast(candidates[begin]);
            getResult(candidates,begin+1,path,target-candidates[begin], res);
            path.removeLast();
        }

        return res;
    }
}
