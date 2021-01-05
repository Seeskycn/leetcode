package com.scn.book.part2.question2;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-09-02
 */
public class Question2 {

    public Node removeLastKthNode(Node head , int lastKth){
        if(head == null || lastKth < 1){
            return head;
        }
        Node cur = head;
        while (cur != null){
            lastKth--;
            cur = head.next;
        }
        if(lastKth == 0){
            head = head.next;
        }
        if(lastKth<0){
            cur = head;
            while (++lastKth !=  0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }


    public DoubleNode removeLastKthNode(DoubleNode head , int lastKth){
        if(head == null || lastKth < 1){
            return head;
        }
        DoubleNode cur = head;
        while (cur!=null){
            lastKth -- ;
            cur = head.next;
        }

        if(lastKth == 0){
            head = head.next;
            head.previous = null;
        }
        if(lastKth < 0){
            cur = head;
            while (++lastKth != 0){
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if(newNext != null){
                newNext.previous = cur;
            }
        }
        return head;
    }

}

class Node{
    public Node next;
    public int value;

    public Node(int value) {
        this.value = value;
    }
}

class DoubleNode{
    public int value;
    public DoubleNode previous;
    public DoubleNode next;

    public DoubleNode(int value){
        this.value = value;
    }
}
