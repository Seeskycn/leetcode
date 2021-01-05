package com.scn.book.part2.question5;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-09-03
 */
public class Question5 {



    public Node reversePart(Node head , int from ,int to){
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null){
            len++;
            fPre = len == from -1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : fPre;
            node1 = node1.next;
        }
        if(from > to || from < 1 || to >  len){
            return head;
        }

        // 翻转开始位置
        node1 = fPre == null ? head : fPre.next;

        // 翻转开始下一个位置
        Node cur = node1.next;
        // 开始位置的下一个指针指向 tpos
        node1.next = tPos;

        Node next = null;
        while (cur != tPos){

            next = cur.next;
            // 当前节点的下雨个节点指向前一个节点
            cur.next = node1;

            node1 = cur;
            cur = next;
        }
        if(fPre != null){
            fPre.next = node1;
            return head;
        }
        return node1;

    }
}

class Node{
    public int value;

    public Node next;

    public Node(int value) {
        this.value = value;
    }
}