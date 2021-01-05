package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-07-20
 */
public class Question19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 0){
            return null;
        }
        ListNode empty= new ListNode(0);
        empty.next = head;
        ListNode p = empty;
        ListNode q = empty;

        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        // 移动
        while (p!=null){
           p=p.next;
           q=q.next;
        }
        return null;
    }
}



class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
