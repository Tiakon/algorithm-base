package cn.tiakon.java.leetcode.datastructure;

import java.util.Collections;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children= Collections.emptyList();

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}