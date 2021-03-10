package com.scn.datastructure.list;


/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-09
 */
public class ListUtil {

    public static void main(String[] args) {
        printList(getList(5));
    }

    public static ListNode getList(int count){
        ListNode[] listNodes = new ListNode[count];
        for (int i = 0; i < count; i++) {
            listNodes[i] = new ListNode(i);
        }
        for (int i = 0; i < listNodes.length; i++) {
            if(i == listNodes.length -1){
                continue;
            }
            listNodes[i].next = listNodes[i+1];
        }

        return listNodes[0];
    }

    public static void printList(ListNode head){

        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
