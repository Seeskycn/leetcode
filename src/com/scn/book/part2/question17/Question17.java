package com.scn.book.part2.question17;

import com.scn.book.part2.Node;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-10-12
 */
public class Question17 {

    public void removeNodeWired(Node node){
        if (node == null) {
            return ;
        }
        Node next = node.next;
        if (next == null) {
            throw new RuntimeException("can not remove last one");
        }
        node.value = next.value;
        node.next = next.next;

    }
}
