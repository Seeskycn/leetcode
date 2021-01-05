package com.scn.book.part2.question3;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-09-02
 */
public class Question3 {

    public Node removeByRatio(Node head , int a , int b){

        if(a <1 || a > b){
            return head;
        }
        int n = 0 ;
        Node cur = head;
        while (cur != null){
            n ++ ;
            cur = cur.next;
        }

        n = (int) Math.ceil(((double) a*n/(double)b));

        if(n == 1){
            head = head.next;
        }
        if(n > 1){
            cur = head;
            while (--n != 1){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}

class Node{
    public int value;

    public Node next;

    public Node(int value) {
        this.value = value;
    }
}
