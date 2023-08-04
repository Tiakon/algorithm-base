package cn.tiakon.java.utils;

import cn.tiakon.java.leetcode.datastructure.TreeNode;

/**
 * @author tiankai.me@gmail.com on 2022/8/24 23:34.
 */
public class TreeUtils {

    /**
     * 前序遍历（先序遍历）
     * <p>
     * 中左右
     *
     * @author tiankai.me@gmail.com on 2022/7/4 18:29.
     */
    public static void preOrderRecur(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    /**
     * 中序遍历
     * 左中右
     *
     * @author tiankai.me@gmail.com on 2022/7/4 18:29.
     */
    public static void inOrderRecur(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderRecur(node.left);
        System.out.print(node.val + " ");
        inOrderRecur(node.right);
    }

    /**
     * 后序遍历
     * 左右中
     *
     * @author tiankai.me@gmail.com on 2022/7/4 18:29.
     */
    public static void postOrderRecur(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderRecur(node.left);
        postOrderRecur(node.right);
        System.out.print(node.val + " ");
    }


}
