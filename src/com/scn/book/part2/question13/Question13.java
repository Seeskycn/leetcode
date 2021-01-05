package com.scn.book.part2.question13;

import com.scn.book.part2.Node;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-10-09
 */
public class Question13 {

    /**
     * hash表解决,空间复杂度 o(n) 时间复杂度 o(n)
     * @param head
     * @return
     */
    public Node removeRep1(Node head){
        if (head == null) {
            return head;
        }

        HashSet<Integer> set = new HashSet<>();

        Node pre = head;
        Node cur = head.next;
        set.add(head.value);

        while (cur != null){
            if(set.contains(cur.value)){
                pre.next=cur.next;
            }else{
                set.add(cur.value);
                pre=cur;
            }
            cur = cur.next;
        }

        return head;
    }

    /**
     * 类似遍历,时间复杂度 o(N²),空间复杂度 o(1)
     * @param head
     * @return
     */
    public Node removeRep2(Node head){

        Node cur= head;
        Node pre = null;
        Node next = null;

        while (cur != null){
            pre = cur;
            next = cur.next;
            while (next != null){
                if(cur.value == next.value){
                    pre.next = cur.next;
                }else{
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
        return head;
    }

}
