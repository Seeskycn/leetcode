package com.scn.datastructure;

import java.util.Random;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-08-24
 */
public class SkipList {

    // 节点晋升的概率
    private static final double PROMOTE_RATE = 0.5;
    private Node head ,tail;
    private int maxLevel;

    public SkipList() {
        this.head = new Node(Integer.MAX_VALUE);
        this.tail = new Node(Integer.MAX_VALUE);
        head.right = tail;
        tail.left = head;
    }

    public Node search(int data){
        Node p = findNode(data);
        if(p.data == data){
            System.out.println("找到节点" + data);
            return p;
        }else {
            System.out.println("未找到节点" + data);
            return null;
        }
    }

    private Node findNode(int data) {
        Node node = head;
        while (true){
            while (node.right.data !=Integer.MAX_VALUE && node.right.data <= data){
                node = node.right;
            }
            if(node.down == null){
                break;
            }
            node = node.down;
        }
        return node;
    }

    public void insert(int data){
        Node preNode = findNode(data);
        if( preNode.data == data){
            return;
        }
        Node node = new Node(data);
        appendNode(preNode,node);
        int currentLevel = 0;
        // 随机决定节点是否晋升
        Random random = new Random();
        while (random.nextDouble() < PROMOTE_RATE){
            if(currentLevel == maxLevel){
                addLevel();
            }
            while (preNode.up == null){
                preNode = preNode.left;
            }
            preNode = preNode.up;
            // 把 晋升的新节点插入到上一层
            Node upperNode = new Node(data);
            appendNode(preNode,upperNode);
            upperNode.down = node;
            node.up = upperNode;
            node = upperNode;
            currentLevel ++;

        }


    }

    private void addLevel() {
        maxLevel++;
        Node p1 = new Node(Integer.MAX_VALUE);
        Node p2 = new Node(Integer.MAX_VALUE);
        p1.right = p2;
        p2.left = p1;
        p1.down = head;
        head.up = p1;
        p2.down = tail;
        tail.up = p2;
        head = p1;
        tail = p2;

    }

    private void appendNode(Node preNode, Node node) {
        Node right = preNode.right;
        preNode.right = node;
        right.left = node;
        node.left = preNode;
        node.right = right;
    }

    // 删除节点
    public boolean remove(int data){
        Node removeNode = findNode(data);
        if(removeNode == null){
            return false;
        }
        int currentLevel = 0;
        while (removeNode != null){
            Node right = removeNode.right;
            Node left = removeNode.left;
            right.left = left;
            left.right = right;

            // 如果不是最底层,且只有无穷小节点和无穷大节点,删除改层
            if(currentLevel != 0 && right.data == Integer.MAX_VALUE && left.data == Integer.MAX_VALUE){
                removeLevel(left);
            }else{
                currentLevel ++;
            }
            removeNode = removeNode.up;
        }
        return true;
    }

    private void removeLevel(Node left) {
        Node right = left.right;
        Node leftDown = left.down;
        Node rightDown = right.down;
        if(left.up == null){
            leftDown.up = null;
            rightDown.up = null;
        }else{
            left.up.down = leftDown;
            right.up.down = rightDown;
            leftDown.up = left.up;
            rightDown.up = right.up;
        }
        maxLevel --;

    }

}
class Node{

    public int data;
    public Node right ,left,down,up;

    public Node(int data) {
        this.data = data;
    }
}