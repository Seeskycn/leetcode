package com.scn.book.part2.question1;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-08-14
 */
public class Question1 {

    public void printCommonPart(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        while (node1 != null && node2 != null) {
            if (node1.value < node2.value) {
                node1 = node1.next;
            } else if (node1.value > node2.value) {
                node2 = node2.next;
            } else {
                System.out.println(node1.value);
                node2 = node2.next;
                node1 = node1.next;
            }
        }
    }

    class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
