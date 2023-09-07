package cn.tiakon.java.leetcode.tree.binarytree;

import cn.tiakon.java.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 *
 * @author tiankai.me@gmail.com on 2022/8/25 15:02.
 */
public class LC111MinimumDepthOfBinaryTree {

    /**
     * 深度优先遍历
     * 递归之自下向上
     *
     * @author tiankai.me@gmail.com on 2022/8/31 19:47.
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        else if (root.right == null) return minDepth(root.left) + 1;
        else return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }

    private int ans = Integer.MAX_VALUE;

    /**
     * 深度优先遍历
     * 递归之自上向下
     *
     * @author tiankai.me@gmail.com on 2022/9/1 14:00.
     */
    public int minDepthV2(TreeNode root) {
        if (root == null) return 0;
        getMinDepth(root, 1);
        return ans;
    }

    public void getMinDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            ans = Math.min(ans, depth);
            return;
        }
        if (root.left == null) getMinDepth(root.right, depth + 1);
        else if (root.right == null) getMinDepth(root.left, depth + 1);
        else {
            getMinDepth(root.right, depth + 1);
            getMinDepth(root.left, depth + 1);
        }
    }

    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * 广度优先遍历
     * 复杂度分析
     * 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
     * 空间复杂度：O(N)，其中 N 是树的节点数。空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数。
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 89.91% 的用户
     * 内存消耗： 60.3 MB , 在所有 Java 提交中击败了 88.14% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/31 19:47.
     */
    public int minDepthV3(TreeNode root) {
        if (root == null) return 0;
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) return depth;
            if (node.left != null) queue.offer(new QueueNode(node.left, depth + 1));
            if (node.right != null) queue.offer(new QueueNode(node.right, depth + 1));
        }
        return 0;
    }

}
