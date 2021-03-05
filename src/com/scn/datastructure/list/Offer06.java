package com.scn.datastructure.list;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-03
 */
public class Offer06 {

    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node !=null){
            node = node.next;
            count++;
        }
        int[] res = new int[count];
        node = head;

        while (node !=null){
            res[--count] = node.val;
            node = node.next;
        }

        return res;




    }
}
