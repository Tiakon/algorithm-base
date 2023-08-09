package cn.tiakon.java.leetcode.tree.ntree;

import cn.tiakon.java.leetcode.datastructure.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 589. N 叉树的前序遍历
 * https://leetcode.cn/problems/n-ary-tree-preorder-traversal
 *
 * @author tiankai.me@gmail.com on 2022/11/22 下午4:07.
 */
public class LC589NAryTreePreorderTraversal {
    /**
     * 递归法
     *
     * @author tiankai.me@gmail.com on 2022/11/22 下午4:10.
     */
    public List<Integer> preorder(Node root) {
        if (root == null) return Collections.emptyList();
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    public void preorder(Node root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        for (Node child : root.children) {
            preorder(child, ans);
        }
    }

    /**
     * 迭代法
     *
     * @author tiankai.me@gmail.com on 2022/11/22 下午4:10.
     */
    public List<Integer> preorderV2(Node root) {
        if (root == null) return Collections.emptyList();
        List<Integer> ans = new ArrayList<>();
        Deque<List<Node>> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                ans.add(root.val);
                List<Node> nodes = root.children;
                if (nodes == null || nodes.size() == 0) root = null;
                else {
                    root = nodes.get(0);
                    nodes.remove(0);
                    stack.push(nodes);
                }
            }
            List<Node> nodes = stack.peek();
            if (nodes != null && nodes.size() != 0) {
                root = nodes.get(0);
                nodes.remove(0);
            } else if (!stack.isEmpty()) {
                stack.pop();
                List<Node> peeks = stack.peek();
                if (peeks != null && peeks.size() != 0) {
                    root = peeks.get(0);
                    peeks.remove(0);
                }
            }
        }
        return ans;
    }

    public List<Integer> preorderV3(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; --i) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }


    @Test
    public void preorderV2Test() {
        LC589NAryTreePreorderTraversal lc589NAryTreePreorderTraversal = new LC589NAryTreePreorderTraversal();
        // [1,null,3,2,4,null,5,6]
        // [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        // [44]
        List<Node> list3 = new ArrayList<>();
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        list3.add(node5);
        list3.add(node6);
        Node node3 = new Node(3, list3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> list = new ArrayList<>();
        list.add(node3);
        list.add(node2);
        list.add(node4);
        Node root = new Node(1, list);
        List<Integer> ans = lc589NAryTreePreorderTraversal.preorder(root);
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(2);
        arrayList.add(4);
        Assert.assertEquals(arrayList, ans);
    }

}
