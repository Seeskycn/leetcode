package com.scn.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-28
 */
public class Question589 {

    public static void main(String[] args) {
    }

    public static List<Integer> preorder(Node root) {

        return getResult(root);

    }

    private static List<Integer> getResult(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> array = new ArrayList<>();
        array.add(root.val);
        for (Node child : root.children) {
           array.addAll(getResult(child));
        }
        return array;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

