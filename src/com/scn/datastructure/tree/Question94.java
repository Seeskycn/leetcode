package com.scn.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-28
 */
public class Question94 {
    public static void main(String[] args) {
        List<Integer> list = inorderTraversal(TreeUtil.makeTree(new String[]{"1", "null", "2", "null", "null", "3"}));
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            // 如果当前节点不为空,当前节点压如栈,当点节点为空,弹出一个节点,打印,并往右;
            // 第一步能直接到当前节点的最左节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;

        }
        return res;

    }
}
