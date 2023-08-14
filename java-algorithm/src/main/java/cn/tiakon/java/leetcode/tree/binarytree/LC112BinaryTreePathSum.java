package cn.tiakon.java.leetcode.tree.binarytree;

import cn.tiakon.java.leetcode.datastructure.TreeNode;

import java.util.LinkedList;

/**
 * 112. 路径总和
 * https://leetcode.cn/problems/path-sum/
 * <p>
 * https://leetcode.cn/problems/path-sum-ii/
 * <p>
 * https://leetcode.cn/problems/path-sum-iii/
 *
 * @author tiankai.me@gmail.com on 2022/8/25 15:05.
 */
public class LC112BinaryTreePathSum {

    // 使用递归之自上而下的方式解决
    // 类似于计算二叉树中的最小最大深度，通过递减每条路径上的值，判断最后的叶子节点是否等于0
    //  执行用时： 0 ms, 在所有 Java 提交中击败了 100.00%的用户
    //  内存消耗： 41.4 MB, 在所有 Java 提交中击败了 41.23%的用户
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // 使用栈迭代
    public void hasPathSumV2(TreeNode root, int targetSum) {
//        if (root == null) return false;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curNode = root;
        while (!stack.isEmpty() || curNode != null) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            if (curNode.right == null) System.out.print(curNode.val+" ");
            else if(curNode.right != null && curNode.left != null) System.out.print(curNode.val+" ");
            curNode = curNode.right;

        }
    }

}
