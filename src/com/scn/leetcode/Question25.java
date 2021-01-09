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
 * @Date: 2021/1/9 14:55
 * @Description:
 */
public class Question25 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;

        print(l1);
        print(reverseKGroup(l1,3));
    }
    public static void print(ListNode head) {
        while (head !=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("---------------");
    }
    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode cur = head;
        ListNode[] temp = new ListNode[k];
        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return head;
            }
            temp[i] = cur;
            cur = cur.next;
        }
        for (int i = k-1; i >=0; i--) {
            if (i == 0) {
                temp[0].next = reverseKGroup(cur,k);;
            } else {
                temp[i].next = temp[i - 1];
            }
        }

        return temp[k - 1];

    }

  static   class ListNode {
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
