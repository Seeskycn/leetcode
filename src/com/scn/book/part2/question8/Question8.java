package com.scn.book.part2.question8;

import com.scn.book.part2.Node;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-09-08
 */
public class Question8 {

    public static void main(String[] args) {
        Node[]  array = new Node[]{new Node(9),new Node(3),new Node(4),new Node(2),new Node(6)
                ,new Node(0),new Node(5),new Node(1)};
        arrPartition(array,4);
    }
    public Node listPartition1(Node head , int pivot){
        if (head == null) {
            return head;
        }
        Node cur = head ;
        int i = 0;
        while (cur.next!=null){
            cur = cur.next;
            i++;
        }
        Node[] nodeArr = new Node[i];
        i = 0 ;
        cur = head;
        for ( i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,pivot);
        for ( i = 1; i != nodeArr.length; i++) {
            nodeArr[i -1].next = nodeArr[i];
        }
        nodeArr[i-1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index !=big){
            if(nodeArr[index].value < pivot){
                swap(nodeArr,++small,index++);
            }else if(nodeArr[index].value == pivot){
                index ++;
            }else{
                swap(nodeArr,--big,index);
            }
        }
    }

    private static void swap(Node[] nodeArr, int a, int b) {
        Node temp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = temp;
    }


    public Node listPartition2(Node head , int pivot){
        // 小的头
        Node sH = null;
        // 小的尾
        Node sT = null;
        // 相等的头
        Node eH = null;
        // 相等的尾
        Node eT = null;
        // 大的头
        Node bH = null;
        // 大的尾
        Node bT = null;
        // 下一个节点
        Node next = null;

        while (head != null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = head;
                }
            }else if (head.value == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else{
                    eT.next = head;
                    eT = head;
                }
            }else{
                if(bH == null){
                    bH = head;
                    bT = head;
                }else{
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        // 小的和相等的重新连接
        if(sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if(eT != null){
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH ;
    }
}
