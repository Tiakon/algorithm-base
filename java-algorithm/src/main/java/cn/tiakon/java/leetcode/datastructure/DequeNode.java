package cn.tiakon.java.leetcode.datastructure;

public class DequeNode {
    public int val;
    public DequeNode next;
    public DequeNode pre;

    public DequeNode() {
    }

    public DequeNode(int val) {
        this.val = val;
    }

    public DequeNode(int val, DequeNode next, DequeNode pre) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }
}
