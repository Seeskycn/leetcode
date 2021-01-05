package com.scn.book.part3.question3;

import com.scn.book.part3.Node;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-10-27
 */
public class Question3 {

    public void printTree(Node head){
        System.out.println("binary tree");
        printInorder(head,0,"H",17);
        System.out.println();

    }

    private void printInorder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInorder(head.right,height+1,"v",len);
        String value = to + head.value + to ;
        int length = value.length();
        int lenL = (len -length)/2;
        int lenR = len - length -lenL;
        value = getSpace(lenL)+ value + getSpace(lenR);
        System.out.println(getSpace(height*len));
        printInorder(head.left,height+1,"^",len);
    }

    private String getSpace(int num) {
        String space = "";
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            sb.append(space);
        }
        return sb.toString();
    }
}
