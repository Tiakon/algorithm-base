package cn.tiakon.java.leetcode.tree.binarytree;

import cn.tiakon.java.leetcode.datastructure.TreeNode;

import java.util.*;

/**
 * 144.二叉树的前序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 *
 * @author tiankai.me@gmail.com on 2022/8/25 13:33.
 */
public class LC144BinaryTreePreorderTraversal {

    /**
     * 递归前序遍历（先序遍历）中左右
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 是二叉树的节点数。每一个节点恰好被遍历一次。
     * 空间复杂度：O(n)，为递归过程中栈的开销，平均情况下为 O(logn)，最坏情况下树呈现链状，为 O(n)。
     *
     * @author tiankai.me@gmail.com on 2022/8/25 14:45.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * 迭代前序遍历：
     * 通过嵌套while循环与栈结构遍历二叉树，记录节点入栈顺序可实现前序遍历。
     *
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 是二叉树的节点数。每一个节点恰好被遍历一次。
     * 空间复杂度：O(n)，为迭代过程中显式栈的开销，平均情况下为 O(logn)，最坏情况下树呈现链状，为 O(n)。
     *
     * @author tiankai.me@gmail.com on 2022/8/25 14:46.
     */
    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    /**
     * 莫里斯遍历（Morris遍历）
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 是二叉树的节点数。没有左子树的节点只被访问一次，有左子树的节点被访问两次。
     * 空间复杂度：O(1)。只操作已经存在的指针（树的空闲指针），因此只需要常数的额外空间。
     *
     * @author tiankai.me@gmail.com on 2022/8/25 14:47.
     */
    public List<Integer> preorderTraversalV3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        TreeNode p1 = root, p2 = null;
        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }

}
