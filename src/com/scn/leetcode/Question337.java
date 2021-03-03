package com.scn.leetcode;

/*
 *-----------------神兽保佑 -----------------
 *           ┌─┐        ┌─┐
 *       ┌─┘  ┴────┘  ┴─┐
 *       │                        │
 *       │        ───          │
 *       │  ─┬┘       └┬─   │
 *       │                        │
 *       │       ─┴─           │
 *       │                        │
 *       └───┐          ┌──┘
 *               │          │
 *               │          │
 *               │          │
 *               │          └────────────┐
 *               │                                    │
 *               │                                    ├─┐
 *               │                                    ┌─┘
 *               │                                    │
 *               └─┐  ┐  ┌─────┬─┐  ┌──┘
 *                   │  ┤  ┤          │  ┤  ┤
 *                   └─┴─┘          └─┴─┘
 *
 * ------------------代码无BUG!--------------
 * @Author: Seesky
 * @Date: 2021/3/1 21:07
 * @Description:
 */
public class Question337 {


    public int rob(TreeNode root) {

        return getResult(root, 0,true);
    }

    private int getResult(TreeNode root, int sum, boolean canTake) {
        if(root == null){
            return sum;
        }
        if(root.left == null && root.right == null){
            if(canTake){
                return sum+root.val;
            }else {
                return sum;
            }

        }
        if(canTake){
            sum = Math.max ((getResult(root.left,sum,false) +  getResult(root.right,sum,false) + root.val),
                    getResult(root.left,sum,true) +  getResult(root.right,sum,true));
        }else {
            sum = getResult(root.left,sum,true) +  getResult(root.right,sum,true);
        }


        return sum;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
