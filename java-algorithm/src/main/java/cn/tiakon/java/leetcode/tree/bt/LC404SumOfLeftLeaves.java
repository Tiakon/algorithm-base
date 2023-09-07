package cn.tiakon.java.leetcode.tree.binarytree;

import cn.tiakon.java.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 404. 左叶子之和
 * https://leetcode.cn/problems/sum-of-left-leaves/
 *
 * @author tiankai.me@gmail.com on 2022/11/23 下午12:02.
 */
public class LC404SumOfLeftLeaves {
    int ans = 0;

    /**
     *
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.2 MB , 在所有 Java 提交中击败了 74.73% 的用户
     * 通过测试用例： 100 / 100
     * @author tiankai.me@gmail.com on 2022/11/23 下午1:53.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        preOrder(root);
        return ans;
    }

    public void preOrder(TreeNode node) {
        if (node == null) return;
        TreeNode leftNode = node.left;
        // 统计叶子节点的左孩子总和
        if (leftNode != null && leftNode.left == null && leftNode.right == null) ans += leftNode.val;
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 27.97% 的用户
     * 通过测试用例： 100 / 100
     *
     * @author tiankai.me@gmail.com on 2022/11/23 下午1:51.
     */
    public int sumOfLeftLeavesV2(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                TreeNode leftNode = root.left;
                if (leftNode != null && leftNode.left == null && leftNode.right == null) ans += leftNode.val;
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return ans;
    }

}