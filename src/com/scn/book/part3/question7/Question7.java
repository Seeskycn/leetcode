package com.scn.book.part3.question7;

import com.scn.book.part3.Node;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-11-03
 */
public class Question7 {

    public ReturnType process(Node x){
        // base case : 如果子树是空树
        // 最小值为系统最大
        // 最大值为系统最小
        if (x == null) {
            return new ReturnType(null,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        // 默认直接得到所有左树信息
        ReturnType lData = process(x.left);
        // 默认直接得到所有右树信息
        ReturnType rData = process(x.right);
        // 以下过程为信息整合
        // 同时对X为头节点的子树也做童谣的要求,也需要返回如ReturnType描述的全部信息
        // 以x为头节点的子树的最小值是,左树最小,右树最小以及x值得三者中的最小的
        int min = Math.min(x.value,Math.min(lData.min,rData.min));
        // 以x为头节点的子树的最大值是,左树最大,右树最大以及x值得三者中的最大的
        int max = Math.max(x.value,Math.max(lData.max,rData.max));
        // 如果考虑可能性一和可能性二,则以x为头节点的子树的最大搜索二叉树大小
        int maxBSTSize = Math.max(rData.maxBSTSize,lData.maxBSTSize);
        // 如果只考虑可能性一和可能性二,则以x为头节点的最大搜索二叉树头节点
        Node maxBSTHead = lData.maxBSTSize > rData.maxBSTSize ? lData.maxBSTHead : rData.maxBSTHead;
        // 利用收集信息,可以判断是否存在第三种可能性
        if(lData.maxBSTHead == x.left && rData.maxBSTHead == x.right && x.value > lData.max && x.value < rData.min){
            maxBSTSize = lData.maxBSTSize + rData.maxBSTSize + 1;
            maxBSTHead = x;
        }
        //信息收集完毕,返回
        return new ReturnType(maxBSTHead,maxBSTSize,min,max);
    }
}
