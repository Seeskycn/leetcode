package com.scn.book.part3.question1;

import com.scn.book.part3.Node;
import sun.java2d.pipe.SpanIterator;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-10-16
 */
public class Question1 {

    /**
     * 先序遍历: 根 左 右
     * @param head
     */
    public void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    public void preOrderUnRecur(Node head){
        System.out.println("per-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.value + " ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历 左 根 右
     * @param head
     */
    public void inOrderRecur(Node head){
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    public void inOrderUnRecur(Node head){
        System.out.println("in-order: ");
        if (head == null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }

        }
        System.out.println();

    }

    /**
     * 后序遍历 左 右 根
     * @param head
     */
    public void posOrderRecur(Node head){
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + " ");
    }

    public void posOrderUnRecur1(Node head){
        System.out.println("pos-order: ");
        if (head == null) {
            return;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()){
            head = s1.pop();
            s2.push(head);
            if(head.left != null){
                s1.push(head.left);
            }
            if(head.right !=null){
                s1.push(head.right);
            }
        }
        while (!s2.isEmpty()){
            System.out.println(s2.pop().value + " ");
        }
        System.out.println();

    }

    public void posOrderUnRecur2(Node h){
        System.out.println("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()){
                c = stack.peek();
                if(c.left != null && h != c.left && h != c.right ){
                    stack.push(c.left);
                }else  if(c.right != null && h != c.right){
                    stack.push(c.right);
                }else{
                    System.out.println(stack.pop().value + " ");
                    h = c;
                }
            }
        }

    }


}
