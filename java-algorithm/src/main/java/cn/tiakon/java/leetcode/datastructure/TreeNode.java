package cn.tiakon.java.leetcode.datastructure;

// 定义一个二叉树节点
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, int val) {
        this.left = left;
        this.val = val;
    }

    public TreeNode(int val, TreeNode right) {
        this.val = val;
        this.right = right;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

}
