package com.scn.book.part2.question10;

import com.scn.book.part2.Node;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-09-09
 */
public class Question10 {

    public Node addList1(Node head1,Node head2){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head1 !=null){
            stack1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 !=null){
            stack1.push(head2.value);
            head2 = head2.next;
        }

        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node pre = null;
        while (!stack1.isEmpty()||stack2.isEmpty()){
            n1 = stack1.isEmpty() ? 0:stack1.pop();
            n2 = stack2.isEmpty() ? 0:stack2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }
        if(ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

    public Node addLists2(Node head1 , Node head2){
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node c1 = head1;
        Node c2 = head2;
        Node node = null;
        Node pre = null;
        while (c1!= null || c2 != null){
            n1 = c1 != null ? c1.value : 0;
            n2 = c2 != null ? c2.value : 0;
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n%10);
            node.next = pre;
            ca = n /10;
            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }
        if(ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        reverseList(head1);
        reverseList(head2);
        return node;

    }

    private Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            next.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
