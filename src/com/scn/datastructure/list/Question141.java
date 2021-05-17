package com.scn.datastructure.list;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-05-13
 */
public class Question141 {

    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast !=null && fast.next != null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
                
    }
}
