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
 * @Date: 2021/1/9 13:46
 * @Description:
 */
public class Question23 {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 2) {
            return merge2List(lists[0], lists[1]);
        }
        int begin = 0;
        int end = lists.length - 1;
        int mid = (begin + end) / 2;
        while (begin != mid) {
            int left = begin;
            int right = mid;
            while (left < mid) {
                lists[left] = merge2List(lists[left], lists[right]);
                left++;
                right++;
            }
            if (right == end) {
                lists[mid] = lists[end];
                end = mid;
            } else {
                end = mid - 1;
            }
            if (mid == 1) {
                return merge2List(lists[0], lists[1]);
            }
            mid = (begin + end) / 2;
        }
        return lists[0];

    }

    public ListNode merge2List(ListNode l1, ListNode l2) {
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
        while (!(cur1 == null || cur2 == null)) {
            if (cur1.val < cur2.val) {
                while (cur1.next != null && cur1.next.val < cur2.val) {
                    cur1 = cur1.next;
                }
                next1 = cur1.next;
                cur1.next = cur2;
                cur1 = next1;
            } else {
                while (cur2.next != null && cur2.next.val <= cur1.val) {
                    cur2 = cur2.next;
                }
                next2 = cur2.next;
                cur2.next = cur1;
                cur2 = next2;
            }
        }

        return l1.val < l2.val ? l1 : l2;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}



