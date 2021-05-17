package com.scn.datastructure.list;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-05-06
 */
public class Question148 {

    public static void main(String[] args) {
        ListNode node = sortList(ListUtil.getList(5));
        ListUtil.printList(node);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            ListNode next = head.next;
            if(head.val < next.val){
                return head;
            }else {
                head.next = null;
                next.next = head;
                return next;
            }

        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(next);
        return merge(node1, node2);
    }

    private static ListNode merge(ListNode node1, ListNode node2) {
        ListNode next1 = node1;
        ListNode next2 = node2;
        ListNode temp ;
        ListNode head = null;
        while (next1 != null && next2 != null) {
            if (next1.val < next2.val) {
                if (head == null) {
                    head = node1;
                }
                temp = node1.next;
                next1.next = node2;
                next1 = temp;
            } else {
                if (head == null) {
                    head = node2;
                }
                temp = node2.next;
                node2.next = next1;
                next2 = temp;
            }
        }

        return head;
    }
}
