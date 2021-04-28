package com.scn.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-10
 */
public class Question102 {



    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<LevelNode> linkedList = new LinkedList<>();
        linkedList.addLast(new LevelNode(root,1));
        List<Integer> subRes = new ArrayList<>();
        while (!linkedList.isEmpty()){

            LevelNode pop = linkedList.pop();
            TreeNode node = pop.node;
            int level = pop.level;
            subRes.add(node.val);
            if(node.left!=null){
                linkedList.addLast(new LevelNode(node.left,level+1));
            }
            if(node.right != null){
                linkedList.addLast(new LevelNode(node.right,level+1));
            }
            if(!linkedList.isEmpty()&&linkedList.peek().level != level){
                res.add(subRes);
                subRes = new ArrayList<>();

            }
        }

        res.add(subRes);
        return res;
    }
   static class LevelNode{
        TreeNode node;
        int level;

        public LevelNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
