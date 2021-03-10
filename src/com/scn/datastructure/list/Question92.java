package com.scn.datastructure.list;

import javafx.application.Preloader;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-08
 */
public class Question92 {

    public static void main(String[] args) {
        ListUtil.printList(reverseBetween(ListUtil.getList(2),1,2));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;

        for (int i = 0; i < right - left+1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        pre.next = null;
        rightNode.next = null;

        reverseLinkedList(leftNode);
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;

    }

    private static void reverseLinkedList(ListNode head) {
        ListNode next = head.next;
        ListNode cur = head;
        cur.next = null;
        while (next != null){
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }

    }
}
