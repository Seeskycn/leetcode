package com.scn.book.part2.question9;

import java.util.HashMap;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-09-09
 */
public class Question9 {

    public Node copyListWithRand1(Node head){
        if (head == null) {
            return head;
        }
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);

    }

    public Node copyListWithRand2(Node head){
        if (head == null) {
            return head;
        }
        Node cur = head;
        Node next = null;
        while (cur != null){
            next = cur.next;
            Node newNode = new Node(cur.value);
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        // 复制节点的 rand 指针
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        Node res = head.next;
        // 拆分
        cur = head;
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;


    }


}

class Node {
    public int value;
    public Node next;
    public Node rand;

    public Node(int value) {
        this.value = value;
    }
}
