package com.scn.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-28
 */
public class Offer32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        return getResult(root, 0, new ArrayList<List<Integer>>());
    }

    private List<List<Integer>> getResult(TreeNode root, int level, List<List<Integer>> res) {
        if (root != null){
            if (res.size()<level) {
                res.add(new ArrayList<>());
            }
            List<Integer> list = res.get(level);
            list.add(root.val);
            getResult(root.left,level+1,res);
            getResult(root.right,level+1,res);
        }
        return res;
    }
}
