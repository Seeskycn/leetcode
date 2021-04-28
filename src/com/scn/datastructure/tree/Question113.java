package com.scn.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-11
 */
public class Question113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        getResult(res,root,targetSum,new LinkedList<>());
        return res;
    }

    private void getResult(List<List<Integer>> res, TreeNode root, int targetSum, LinkedList<Integer> path) {
        if(root.left == null && root.right == null){
            if (root.val == targetSum) {
                path.addLast(root.val);
                res.add(new ArrayList<>(path));
                path.removeLast();
            }
            return;
        }
        if(root.left !=null){
            path.addLast(root.val);
            getResult(res,root.left,targetSum-root.val,path);
            path.removeLast();
        }
        if(root.right !=null){
            path.addLast(root.val);
            getResult(res,root.right,targetSum-root.val,path);
            path.removeLast();
        }
    }
}
