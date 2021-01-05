package com.scn.book.part3.question8;

import com.scn.book.part3.Node;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-11-12
 */
public class Question8 {

    public int bstTopSize1(Node head){
        if (head == null) {
            return 0;
        }
        int max = maxTopo(head,head);
        max = Math.max(bstTopSize1(head.left),max);
        max = Math.max(bstTopSize1(head.right),max);
        return max;
    }

    private int maxTopo(Node h, Node n) {
        if (h != null && n != null && isBSTNode(h,n,n.value)) {
            return maxTopo(h,n.left) + maxTopo(h,n.right) + 1;
        }
        return 0;
    }

    private boolean isBSTNode(Node h, Node n, Integer value) {
        if (h == null) {
            return false;
        }
        if (h == n) {
            return true;
        }
        return isBSTNode(h.value > value ? h.left : h.right , n ,value);
    }
}
