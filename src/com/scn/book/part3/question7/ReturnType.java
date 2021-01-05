package com.scn.book.part3.question7;

import com.scn.book.part3.Node;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-11-03
 */
public class ReturnType {
    public Node maxBSTHead;
    public int maxBSTSize;
    public int min;
    public int max;

    public ReturnType(Node maxBSTHead, int maxBSTSize, int min, int max) {
        this.maxBSTHead = maxBSTHead;
        this.maxBSTSize = maxBSTSize;
        this.min = min;
        this.max = max;
    }
}
