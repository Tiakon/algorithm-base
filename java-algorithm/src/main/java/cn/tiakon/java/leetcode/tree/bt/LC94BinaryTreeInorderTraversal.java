package cn.tiakon.java.leetcode.tree.binarytree;

import cn.tiakon.java.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 *
 * @author tiankai.me@gmail.com on 2022/8/25 14:24.
 */
public class LC94BinaryTreeInorderTraversal {

    // 递归 中序遍历 左中右
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    // 迭代 中序遍历 左中右
    // 通过嵌套while循环与栈遍历二叉树，在栈弹出时记录节点顺序即为中序遍历。
    public List<Integer> inorderTraversalV2(TreeNode root) {
        final List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        final Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while (!deque.isEmpty() || node != null) {
            while (node != null) {
                deque.push(node);
                node = node.left;
            }
            node = deque.pop();
            ans.add(node.val);
            node = node.right;
        }
        return ans;
    }

    /**
     * 莫里斯遍历（Morris遍历）
     * @author tiankai.me@gmail.com on 2022/8/26 13:58.
     */
    public List<Integer> inorderTraversalV3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

}
