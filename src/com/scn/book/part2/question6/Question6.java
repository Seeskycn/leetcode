package com.scn.book.part2.question6;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-09-03
 */
public class Question6 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node1;

        josephusKill1(node1,3);
    }
    public static Node josephusKill1(Node head , int m){
        if(head == null || head.next == head || m < 1){
            return head;
        }
        Node last = head;
        while (last.next != head){
            last = last.next;
        }
        int count = 0;
        while (head != last){
            if(++count == m){
                last.next = head.next;
                count = 0;
            }else{
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }
}

class Node{
    public int node;
    public Node next;

    public Node(int node) {
        this.node = node;
    }
}
