package com.scn.book.part2.question19;

import com.scn.book.part2.Node;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-10-12
 */
public class Question19 {

    public Node combine(Node head1 ,Node head2){
       if(head1 == null || head2 == null){
           return head1 == null ? head2 : head1;
       }
       Node newHead = head1.value<head2.value ? head1 : head1;
       Node cur1 = newHead == head1 ? head1 : head2;
       Node cur2 = newHead == head1 ? head2 : head1;
       Node pre = null;
       Node next = null;
       while (cur1 !=null && cur2!=null){
           if(cur1.value<=cur2.value){
               pre = cur1;
               cur1 = cur2.next;
           }else{
               next = cur2.next;
               pre.next = cur2;
               cur2.next = cur1;
               pre = cur2;
               cur2 = next;
           }
       }
       pre.next = cur1 ==null ? cur2 : cur1;
       return head1;
    }
}
