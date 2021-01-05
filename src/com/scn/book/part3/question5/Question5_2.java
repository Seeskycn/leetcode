package com.scn.book.part3.question5;

import com.scn.book.part3.Node;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-10-30
 */
public class Question5_2 {

    /**
     * Morris 遍历过程
     * 假设当前节点为 cur ,初始cur 就是整棵树的头节点,根据以下标准让cur移动
     * 1)如果cur为null,则过程停止,否则继续下面过程
     * 2)如果cur没有左子树就让cur向右移动,即令cur = cur.right
     * 3)如果cur有左子树,则让cur左子树上的最右子节点,记为 mostRight
     * 3.1)如果mostRight的right指向null,则令 mostRight.right = cur,也就是让mostRight的righr指针指向当前节点,然后cur向左移动,即令cur = cur.left
     * 3.2)如果mostRight的right指向cur,则令 mostRight.right = null,也就是让mostRight.right指向null;然后让 cur向右移动,即令cur = cur.right
     * @param head
     */
    public void morris(Node head){
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = head.left;
            if (mostRight == null) {
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight != null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight = null;
                }
            }

            cur = cur.right;
        }
    }

    /**
     * 前序遍历 根 左右
     * @param head
     */
    public void morrisPre(Node head){
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur!= null){
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight == null) {
                    mostRight.right = cur;
                    System.out.println( cur.value + " ");
                    cur = cur.left;
                    continue;
                }else{
                    mostRight = null;
                }
            }else {
                System.out.println(cur.value + " ");
            }
            cur = cur.right;
        }
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
     * 后续遍历 左 右 根
     */
    public void morrisPos(Node head){
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }
}
