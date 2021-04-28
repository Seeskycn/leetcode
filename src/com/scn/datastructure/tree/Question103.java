package com.scn.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-10
 */
public class Question103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // true 为从左往右
        Boolean flag = true;

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> subRes = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.pop();
                if(flag){
                    subRes.addLast(pop.val);
                }else {
                    subRes.addFirst(pop.val);
                }
                if (pop.left != null) {
                    queue.addLast(pop.left);
                }
                if (pop.right != null) {
                    queue.addLast(pop.right);
                }
            }
            res.add(subRes);
            subRes = new LinkedList<>();
            flag = !flag;


        }
        return res;


    }
}
