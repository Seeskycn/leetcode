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
 * @Date: 2021/2/28 13:53
 * @Description:
 */
public class Question160 {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headA.next == null || headB == null || headB.next == null){
            return headA;
        }
        int lengthA = 0;
        int lengthB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA.next != null) {
            lengthA++;
            nodeA = nodeA.next;
        }
        while (nodeB.next != null) {
            lengthB++;
            nodeB = nodeB.next;
        }

        if (lengthA > lengthB) {
            int num = lengthA - lengthB;
            while (num > 0) {
                headA = headA.next;
                num --;
            }

        }else {
            int num = lengthB - lengthA;
            while (num > 0) {
                headB = headB.next;
                num --;
            }

        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;


    }
}
