package cn.tiakon.java.leetcode.tree.binarytree;

import cn.tiakon.java.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 145.二叉树的后序遍历
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 *
 * @author tiankai.me@gmail.com on 2022/8/25 14:25.
 */
public class LC145BinaryTreePostorderTraversal {

    // 递归后序遍历 左右中
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    // 迭代后序遍历 左右中
    public List<Integer> postorderTraversalV2(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        if (root == null) return Collections.emptyList();
        final Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        TreeNode prev = null; // 标记已访问的节点
        while (!deque.isEmpty() || node != null) {
            while (node != null) {
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            if (node.right == null || node.right == prev) {  // 这里左节点已空,所以判断右节点是否为空或时候已经遍历过.
                ans.add(node.val);                           // 左右节点都空或右节点以遍历完成时,输出父节点.
                prev = node;                                 // 将指针指向当前最后已输出的节点
                node = null;                                 // 标记当前指针为空,用来跳过左节点的遍历,只弹出栈.
            } else {                                         // 这里表示右节点尚未访问,需要遍历
                deque.push(node);                            // 将父节点重新入栈
                node = node.right;                           // 将当前指针指向父节点的右节点
            }
        }
        return ans;
    }
}
