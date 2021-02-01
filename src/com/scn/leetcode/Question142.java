package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-31
 */
public class Question142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next ==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        boolean flag = false;
        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = true;
                break;
            }
        }
        if(flag){
            fast = head;
            while (true){
                if (fast == slow) {
                    return fast;
                }
                fast = fast.next;
                slow = slow.next;
            }
        }else {
            return null;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}


