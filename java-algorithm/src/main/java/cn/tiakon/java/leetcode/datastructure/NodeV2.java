package cn.tiakon.java.leetcode.datastructure;

public class NodeV2 {
    public int val;
    public NodeV2 prev;
    public NodeV2 next;
    public NodeV2 child;

    public NodeV2(int val) {
        this.val = val;
    }

    public NodeV2(int val, NodeV2 next) {
        this.val = val;
        this.next = next;
    }
}