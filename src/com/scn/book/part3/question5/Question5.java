package com.scn.book.part3.question5;

import com.scn.book.part3.Node;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-10-29
 */
public class Question5 {
    /**
     * Morris 遍历过程
     * 假设当前节点为 cur,初始市cur就是整棵树的头节点,根据以下标准让cur移动
     * 1)如果 cur 为 null,则过程停止,否则继续下面过程
     * 2)如果cur没有左子树,则让cur向右移动,即令 cur = cur.right
     * 3)如果cur有左子树,则找到cur左子树上的最右子节点,记为mostRight
     *  3.1)如果mostRight 的right指向null,则令 mostRight.right = cur ,也就是让 mostRight 的 right指针指向当前节点,然后cur向左移动,即令cur = cur.left
     *  3.2)如果mostRight.right的指针指向cur,则令mostRIght.right = null ;也就是让mostRight的tight的指针指向null,然后让cur向右移动,即令cur = cur.right
     * @param head
     */
    public void morris(Node head){
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur!=null){
            mostRight = cur.left;
            if (mostRight != null) { // 如果当前cur有左子树
                while (mostRight.right!= null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                //从上面的while出来后，mostRight就是cur左子树上的最右节点
                if (mostRight.right == null) { // 如果mostRight.right指向null
                    mostRight.right = cur; // 让其指向cur
                    cur = cur.left; // cur向左移动
                    continue;
                }else {//如果 mostRight.right指向 cur
                    mostRight.right = null; // 让其指向null
                }
            }
            //如果没有左子树,cur向右移动
            //或者cur左子树上最右节点的右指针指向的cur的,cur向右移动
            cur = cur.right;
        }

    }

    /**
     * 前序遍历 根 左 右
     * @param head
     */
    public void morrisPre(Node head){
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;

        while (cur!=null){
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight == null) {
                    mostRight.right = cur;
                    System.out.println(cur.value + " ");
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }else{
                System.out.println(cur.value + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * 中序遍历 左 根 右
     * @param head
     */
    public void morrisIn(Node head){
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = head.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight = null;
                }
            }
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
    }

    /**
     * 后序遍历 左 右 根
     * @param head
     */
    public void morrisPos(Node head){
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight == null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
                cur = cur.right;
            }
        }
        printEdge(head);
        System.out.println();
    }

    private void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null){
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private Node reverseEdge(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.right;
            head.right = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
