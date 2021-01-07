package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-07
 */
public class Question21 {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1;
        ListNode next1 = cur1;
        ListNode cur2 = l2;
        ListNode next2 = cur2;
        while (!(cur1== null || cur2 == null)){
            if(cur1.val < cur2.val){
                while (cur1.next != null && cur1.next.val<cur2.val){
                    cur1 = cur1.next;
                }
                next1 = cur1.next ;
                cur1.next = cur2;
                cur1 = next1;
            }else {
                while (cur2.next!= null &&cur2.next.val<=cur1.val){
                    cur2 = cur2.next;
                }
                next2 = cur2.next ;
                cur2.next = cur1;
                cur2 = next2;
            }
        }

        return l1.val < l2.val ? l1 : l2;

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
