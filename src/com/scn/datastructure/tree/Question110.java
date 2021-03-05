package com.scn.datastructure.tree;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-28
 */
public class Question110 {

    public static void main(String[] args) {
        System.out.println(isBalanced(TreeUtil.makeTree(new String[]{"1", "2", "2", "3", "3", "null", "null", "4", "4"})));
    }

    public static boolean isBalanced(TreeNode root) {
        Result high = getHigh(root);
        return high.flag;

    }

    private static Result getHigh(TreeNode root) {
        if (root == null) {
            return new Result(true, 0);
        }
        TreeNode left = root.left;
        Result highL = getHigh(left);
        if (!highL.flag) {
            return new Result(false, 0);
        }

        TreeNode right = root.right;
        Result highR = getHigh(right);
        if (!highR.flag) {
            return new Result(false, 0);
        }

        if (Math.abs(highL.high - highR.high) <= 1) {
            return new Result(true,Math.max(highL.high, highR.high) + 1);
        } else {
            return new Result(false, 0);
        }
    }

    static class Result {

        boolean flag;

        int high;

        public Result(boolean flag, int high) {
            this.flag = flag;
            this.high = high;
        }
    }

}
