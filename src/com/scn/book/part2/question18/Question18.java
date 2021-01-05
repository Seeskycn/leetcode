package com.scn.book.part2.question18;

import com.scn.book.part2.Node;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-10-12
 */
public class Question18 {
    public Node insertNum(Node head ,int num){
        Node newNode = new Node(num);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur !=head){
            if(pre.value<=num && cur.value >= num){
               break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = newNode;
        newNode.next = cur;
        return head.value < num ? head : newNode;
    }
}
