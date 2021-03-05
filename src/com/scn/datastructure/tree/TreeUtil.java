package com.scn.datastructure.tree;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-28
 */
public class TreeUtil {

    public static void main(String[] args) {
        makeTree(new String[]{"1", "2", "2", "3", "3", "null", "null", "4", "4"});
    }

    public static TreeNode makeTree(String[] args) {
        TreeNode[] treeNodes = new TreeNode[args.length];
        treeNodes[0] = new TreeNode(Integer.valueOf(args[0]));
        for (int i = 1; i < args.length; i++) {
            TreeNode parent = treeNodes[(i - 1) / 2];
            if (parent == null) {
                continue;
            }
            TreeNode treeNode = args[i] == "null" ? null : new TreeNode(Integer.valueOf(args[i]));
            treeNodes[i] = treeNode;
            if ((i - 1) % 2 == 0) {
                parent.left = treeNode;
            } else {
                parent.right = treeNode;

            }

        }
        return treeNodes[0];

    }


    public static void printTreePreOrder(TreeNode node){
        if(node == null){
            System.out.print("null ");
            return;
        }
        System.out.print(node.val + " ");
        printTreePreOrder(node.left);
        printTreePreOrder(node.right);

    }

    public static TreeNode getTree(){
        return makeTree(new String[]{"1", "2", "2", "3", "3", "null", "null", "4", "4"});
    }


}
