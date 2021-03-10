package com.scn.datastructure.tree;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-09
 */
public class Question98 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.makeTree(new String[]{"5","4","6","null","null","3","7"});
        System.out.println(isValidBST(treeNode));
    }

    public static boolean isValidBST(TreeNode root) {

         return getResult(root).isValidBST;

    }

    public static Result getResult(TreeNode root){
        if(root == null ){
            return new Result(0,0,true);
        }
        int max = root.val;
        int min = root.val;
        if (root.left != null) {
            Result result = getResult(root.left);
            if(result.max >= root.val || result.isValidBST == false){
                return new Result(0,0,false);
            }else {
                min = result.min;
            }
        }

        if (root.right != null) {
            Result result = getResult(root.right);
            if(result.min <= root.val || result.isValidBST == false){
                return new Result(0,0,false);
            }else {
                max = result.max;
            }
        }
        return new Result(min,max,true);

    }

   static class Result{


        private Integer min;

        private Integer max;

        private Boolean isValidBST;

       public Result(Integer min, Integer max, Boolean isValidBST) {
           this.min = min;
           this.max = max;
           this.isValidBST = isValidBST;
       }
   }
}
