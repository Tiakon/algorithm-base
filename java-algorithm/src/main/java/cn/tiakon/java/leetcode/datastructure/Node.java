package cn.tiakon.java.leetcode.datastructure;

import java.util.Collections;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children = Collections.emptyList();

    public Node prev;
    public Node next;
    public Node child;
    public Node random;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

}