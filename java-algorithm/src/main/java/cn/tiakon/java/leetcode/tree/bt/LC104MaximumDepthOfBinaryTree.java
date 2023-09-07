package cn.tiakon.java.leetcode.tree.binarytree;

import cn.tiakon.java.leetcode.datastructure.TreeNode;

/**
 * 104. 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 *
 * @author tiankai.me@gmail.com on 2022/8/25 15:00.
 */
public class LC104MaximumDepthOfBinaryTree {

    // 自下而上，后序遍历？
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 自上而下
    public int maxDepthV2(TreeNode root) {
        if (root == null) return 0;
        maximumDepth(root, 1);
        return answer;
    }

    private int answer;

    private void maximumDepth(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) answer = Math.max(answer, depth);
        maximumDepth(root.left, depth + 1);
        maximumDepth(root.right, depth + 1);
    }

    public int maxDepth2nd(TreeNode root) {
        return dfsFormTopToDown(root, 0);
    }

    public int dfsFormTopToDown(TreeNode node, int path) {
        if (node == null) return path;
        int leftPath = dfsFormTopToDown(node.left, path + 1);
        int rightPath = dfsFormTopToDown(node.right, path + 1);
        return Math.max(leftPath, rightPath);
    }

    public int dfsFromDownToTop(TreeNode node, int path) {
        if (node == null) return path;
        int leftPath = dfsFormTopToDown(node.left, path) + 1;
        int rightPath = dfsFormTopToDown(node.right, path) + 1;
        return Math.max(leftPath, rightPath);
    }

    public int dfsFromDownToTopV2(TreeNode node, int path) {
        if (node == null) return path;
        int leftPath = dfsFromDownToTopV2(node.left, path);
        int rightPath = dfsFromDownToTopV2(node.right, path);
        return Math.max(leftPath, rightPath) + 1;
    }

}
