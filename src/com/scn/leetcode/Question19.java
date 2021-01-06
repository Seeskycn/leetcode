package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-07-20
 */
public class Question19 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = null;
        ListNode listNode1 = removeNthFromEnd(listNode, 1);
        System.out.println(111);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 0){
            return null;
        }
        ListNode empty= new ListNode(0);
        empty.next = head;
        ListNode fast = empty;
        ListNode slow = empty;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 移动
        while (fast.next!=null){
           fast=fast.next;
           slow=slow.next;
        }

        if(slow == empty){
            return head.next;
        }else{
            slow.next = slow.next.next;
        }


        return head;
    }
}



class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
