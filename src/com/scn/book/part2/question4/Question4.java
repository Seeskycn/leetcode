package com.scn.book.part2.question4;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-09-02
 */
public class Question4 {


    public Node reverseList(Node cur){
        Node pre = null;
        Node next = null;

        while (cur != null){
            next = cur.next;
            // 当前节点的下一个节点指向前一个节点
            cur.next = pre;
            // 前一个节点移动
            pre = cur;
            // 当前节点移动
            cur = next;
        }
        return pre;
    }
    public DoubleNode reverseList(DoubleNode cur){
        DoubleNode pre = null;
        DoubleNode next = null;

        while (cur != null){

            next = cur.next;
            // 当前节点的下一个节点指向前一个节点
            cur.next = pre;
            // 当前节点的前一个节点指向下一个节点
            cur.previous = next;
            // 前一个节点移动
            pre = cur;
            // 当前节点移动
            cur = next;
        }
        return pre;
    }
}

class Node{
    public int value;
    public Node next ;

    public Node(int value) {
        this.value = value;
    }
}

class DoubleNode{
    public int value;
    public DoubleNode previous;
    public DoubleNode next;

    public DoubleNode(int value) {
        this.value = value;
    }
}
