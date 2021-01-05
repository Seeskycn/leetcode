package com.scn.book.part2.question15;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-10-10
 */
public class Question15 {

    public Node covert1(Node head){
        Queue<Node> queue = new LinkedList<>();
        inOrderToQueue(head,queue);
        if(queue.isEmpty()){
            return head;
        }
        head = queue.poll();
        Node per = head;
        per.left = null;
        Node cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            per.right = cur;
            cur.left = per;
            per = cur;
        }
        per.right = null;
        return head;
    }

    private void inOrderToQueue(Node head, Queue<Node> queue) {
        if (head == null) {
            return;
        }
        inOrderToQueue(head.left,queue);
        queue.offer(head);
        inOrderToQueue(head.right,queue);
    }

    public Node convert2(Node head){
        if(head == null){
            return head;
        }
        return process(head).start;
    }

    private ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(null,null);
        }
        ReturnType leftList = process(head.left);
        ReturnType rightList = process(head.right);
        if(leftList.end !=null){
            leftList.end.right = head;
        }
        head.left = leftList.end;
        head.right = rightList.start;
        if(rightList.start != null){
            rightList.start.left = head;
        }

        return new ReturnType(leftList.start != null ? leftList.start : head ,
                rightList.end != null ? rightList.end : head);
        }
}
