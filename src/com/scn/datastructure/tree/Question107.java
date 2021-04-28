package com.scn.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-11
 */
public class Question107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> subRes = new ArrayList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.pop();
                subRes.add(pop.val);
                if (pop.left != null) {
                    queue.addLast(pop.left);
                }
                if (pop.right != null) {
                    queue.addLast(pop.right);
                }
            }
            res.addFirst(subRes);
            subRes = new ArrayList<>();
        }
        return res;
    }
}
