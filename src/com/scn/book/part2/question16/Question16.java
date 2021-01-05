package com.scn.book.part2.question16;

import com.scn.book.part2.Node;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-10-10
 */
public class Question16 {

    public static Node selectionSort(Node head){
        //排序部分末尾
        Node tail = null ;
        //未排序部分头部
        Node cur = head;
        //最小节点的前一个节点
        Node smallPre = null;
        //最小节点
        Node small = null;

        while (cur != null){
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if(smallPre != null){
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if(tail == null){
                head = small;
            }else {
                tail.next = small;
            }
            tail = small;
        }
        return head;

    }

    private static Node getSmallestPreNode(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null){
            if(cur.value < small.value){
                smallPre = pre;
                small = cur;
            }
            pre=cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
