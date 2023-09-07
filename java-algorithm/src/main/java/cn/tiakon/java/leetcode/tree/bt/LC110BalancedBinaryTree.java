package cn.tiakon.java.leetcode.tree.binarytree;

import cn.tiakon.java.leetcode.datastructure.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 110. 平衡二叉树
 * https://leetcode.cn/problems/balanced-binary-tree/
 *
 * @author tiankai.me@gmail.com on 2022/8/25 15:01.
 */
public class LC110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean ans = false;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.peek();
            while (node != null) {
                System.out.printf("%d ", node.val);
                if (node.left != null) deque.push(node.left);
                node = node.left;
            }
            node = deque.poll();
            if (node != null && node.right != null) deque.push(node.right);
            else {
                node = deque.poll();
                if (node != null && node.right != null) {
                    deque.push(node.right);
                }
            }
        }
        return ans;
    }


    @Test
    public void case01Test() {
        final TreeNode node44 = new TreeNode(4);
        final TreeNode node4 = new TreeNode(4);
        final TreeNode node33 = new TreeNode(3);
        final TreeNode node3 = new TreeNode(3, node4, node44);
        final TreeNode node22 = new TreeNode(2);
        final TreeNode node2 = new TreeNode(2, node3, node33);
        final TreeNode root = new TreeNode(1, node2, node22);

        final LC110BalancedBinaryTree balancedBinaryTree = new LC110BalancedBinaryTree();
        // 1 2 3 4 4 3 2
        Assert.assertFalse(balancedBinaryTree.isBalanced(root));

    }

    @Test
    public void case02Test() {
        final TreeNode node33 = new TreeNode(7);
        final TreeNode node3 = new TreeNode(15);
        final TreeNode node22 = new TreeNode(20, node3, node33);
        final TreeNode node2 = new TreeNode(9);
        final TreeNode root = new TreeNode(3, node2, node22);

        final LC110BalancedBinaryTree balancedBinaryTree = new LC110BalancedBinaryTree();
        // 3 9 20 15 7
        Assert.assertFalse(balancedBinaryTree.isBalanced(root));

    }

}
