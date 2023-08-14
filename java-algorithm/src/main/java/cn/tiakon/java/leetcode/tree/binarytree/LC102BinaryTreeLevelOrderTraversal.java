package cn.tiakon.java.leetcode.tree.binarytree;

import cn.tiakon.java.leetcode.datastructure.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 *
 * @author tiankai.me@gmail.com on 2022/8/25 14:58.
 */
public class LC102BinaryTreeLevelOrderTraversal {

    /**
     * 通过预先记录队列大小，实现同层级的节点全部入队后，再全部处理。
     * 复杂度分析
     * 记树上所有节点的个数为 n。
     * 时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
     * 空间复杂度：队列中元素的个数不超过 nn 个，故渐进空间复杂度为 O(n)。
     *
     * @author tiankai.me@gmail.com on 2022/8/31 18:40.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        final List<List<Integer>> ans = new ArrayList<>();
        final Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        deque.add(node);
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            final int size = deque.size();
            for (int i = 0; i < size; i++) {
                node = deque.poll();
                list.add(node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            ans.add(list);
        }
        return ans;
    }

}
