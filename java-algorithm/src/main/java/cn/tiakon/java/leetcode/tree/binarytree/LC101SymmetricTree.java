package cn.tiakon.java.leetcode.tree.binarytree;

import cn.tiakon.java.leetcode.datastructure.TreeNode;

import java.util.*;

/**
 * 101. 对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/
 *
 * @author tiankai.me@gmail.com on 2022/9/1 23:31.
 */
public class LC101SymmetricTree {

    /**
     * 广度优先遍历，迭代法
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 9.63% 的用户
     * 内存消耗： 41.2 MB , 在所有 Java 提交中击败了 5.02% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/9/20 12:26.
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<TreeNode> leftList = new ArrayList<>();
            List<TreeNode> rightList = new ArrayList<>();
            while (!deque.isEmpty()) {
                TreeNode pollFirst = deque.pollFirst();
                TreeNode pollLast = null;
                if (!deque.isEmpty()) pollLast = deque.pollLast();
                if (pollLast != null && pollFirst.val != pollLast.val) return false;
                addLeftValueInDeque(pollFirst, leftList);
                addRightValueInDeque(pollLast, rightList);
            }
            deque.addAll(leftList);
            for (int i = rightList.size() - 1; i >= 0; i--) {
                deque.add(rightList.get(i));
            }
        }
        return true;
    }

    // 添加左子树的左右节点
    public void addLeftValueInDeque(TreeNode treeNode, List<TreeNode> list) {
        if (treeNode != null && treeNode.val != Integer.MAX_VALUE) {
            if (treeNode.left != null) list.add(treeNode.left);
            else list.add(new TreeNode(Integer.MAX_VALUE));
            if (treeNode.right != null) list.add(treeNode.right);
            else list.add(new TreeNode(Integer.MAX_VALUE));
        }
    }

    // 添加右子树的右左节点，方便逆序与左子树形成镜像
    public void addRightValueInDeque(TreeNode treeNode, List<TreeNode> list) {
        if (treeNode != null && treeNode.val != Integer.MAX_VALUE) {
            if (treeNode.right != null) list.add(treeNode.right);
            else list.add(new TreeNode(Integer.MAX_VALUE));
            if (treeNode.left != null) list.add(treeNode.left);
            else list.add(new TreeNode(Integer.MAX_VALUE));
        }
    }

    /**
     * 深度优先遍历，递归法
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 57.66% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/9/19 20:22.
     */
    public boolean isSymmetricV2(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode node01, TreeNode node02) {
        //递归的终止条件是两个节点都为空
        //或者两个节点中有一个为空
        //或者两个节点的值不相等
        if (node01 == null && node02 == null) return true;
        if (node01 == null || node02 == null) return false;
        if (node01.val != node02.val) return false;
        // 比较左节点的左孩子 和 右节点的右孩子，不一样立马返回
        // 再比较左节点的右孩子 和 右节点的左孩子
        return dfs(node01.left, node02.right) && dfs(node01.right, node02.left);
    }

    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n)，同「方法一」。
     * 空间复杂度：这里需要用一个队列来维护节点，每个节点最多进队一次，出队一次，队列中最多不会超过 n 个点，故渐进空间复杂度为 O(n)。
     *
     * @author tiankai.me@gmail.com on 2022/9/20 13:15.
     */
    public boolean isSymmetricV3(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        //用队列保存节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        //将根节点的左右孩子放到队列中
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            //从队列中取出两个节点，再比较这两个节点
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            //如果两个节点都为空就继续循环，两者有一个为空就返回false
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            //将左节点的左孩子， 右节点的右孩子放入队列
            queue.add(left.left);
            queue.add(right.right);
            //将左节点的右孩子，右节点的左孩子放入队列
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }


}
