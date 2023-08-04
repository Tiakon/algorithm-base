package cn.tiakon.java.zbook.chapter01.example08;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * 构造数组 MaxTree 的原则
 * 1. 每一个数的父节点是它左边第一个比它大的数和它右边第一个比它大的树中，较小的那个。
 * 2. 如果一个数左边没有比它大的数，右边也没有，也就是说，这个数是整个数组的最大值，那么这个数是MaxTre的头结点。
 * 实现思路
 * 1. 利用栈跟数组，找到每个数左右两边都比它大的数，并保存成 map
 * 2. 从左到右遍历 node数组，找到每个数左边第一个比自己大的数，保存成 leftMap
 * 3. 从右到左遍历 node数组，找到每个数右边第一个比自己大的数，保存成 rightMap
 * 4. 根据 MaxTree 父节点的构建原则，创建树。
 *
 * @author tiankai.me@gmail.com on 2022/7/4 15:06.
 */
public class MaxTree {

    /**
     * @author tiankai.me@gmail.com on 2022/7/5 13:57.
     */
    public Node getMaxTree(int[] arr) {
        final Node[] nodes = new Node[arr.length];
        for (int i = 0; i != arr.length; i++) {
            nodes[i] = new Node(arr[i]);
        }
        final Stack<Node> nodeStack = new Stack<>();
        final HashMap<Node, Node> leftMap = new HashMap<>();
        final HashMap<Node, Node> rightMap = new HashMap<>();
        // 从左到右遍历，找每个数左边第一个比它大的数
        for (int i = 0; i < nodes.length; i++) {
            final Node curNode = nodes[i];
            while (!nodeStack.isEmpty() && nodeStack.peek().value < curNode.value) {
                popStackSetMap(nodeStack, leftMap);
            }
            nodeStack.push(curNode);
        }
        while (!nodeStack.isEmpty()) {
            popStackSetMap(nodeStack, leftMap);
        }
        // 从右到左遍历，找每个数右边第一个比它大的数
        for (int i = nodes.length - 1; i != -1; i--) {
            final Node curNode = nodes[i];
            while (!nodeStack.isEmpty() && nodeStack.peek().value < curNode.value) {
                popStackSetMap(nodeStack, rightMap);
            }
            nodeStack.push(curNode);
        }
        while (!nodeStack.isEmpty()) {
            popStackSetMap(nodeStack, rightMap);
        }
        Node head = null;
        for (int i = 0; i != nodes.length; i++) {
            final Node curNode = nodes[i];
            final Node left = leftMap.get(curNode);
            final Node right = rightMap.get(curNode);
            if (left == null && right == null) {
                // 它左右两边都没有比它大的数，所以它是头结点
                head = curNode;
            } else if (left == null) {
                // 它左边的数没有比它大的，所以取右边的数作为父节点
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    // 当父节点左子树有值，则将它放置右节点位置
                    right.right = curNode;
                }
            } else if (right == null) {
                // 它右边的数没有比它大的，所以取左边的数作为父节点
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                // 它左右两边都有比它大的数，所以取较小的数作为父节点
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    /**
     * 保存每个数左边或右边第一个比它自己大的数
     *
     * @author tiankai.me@gmail.com on 2022/7/5 13:31.
     */
    private void popStackSetMap(Stack<Node> nodeStack, HashMap<Node, Node> map) {
        final Node popNode = nodeStack.pop();
        if (nodeStack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, nodeStack.peek());
        }
    }

    @Test
    public void getMaxTreeTest() {
        final int[] nonRepeatArray = {5, 4, 6, 7, 3, 8, 1};
        final MaxTree maxTree = new MaxTree();
        final Node maxTreeHead = maxTree.getMaxTree(nonRepeatArray);
        // 8 7 6 5 4 3 1
        Node.preOrderRecur(maxTreeHead);
        System.out.println("");
        // 4 5 6 7 3 8 1
        Node.inOrderRecur(maxTreeHead);
        System.out.println("");
        // 4 5 6 3 7 1 8
        Node.posOrderRecur(maxTreeHead);
    }

    @Test
    public void getMaxTreeV2Test() {
        final int[] nonRepeatArray = MathRandomUtil.getNonRepeatArray(10, 100);
        MathRandomUtil.printArray(nonRepeatArray);
        final MaxTree maxTree = new MaxTree();
        final Node maxTreeHead = maxTree.getMaxTree(nonRepeatArray);
        Node.preOrderRecur(maxTreeHead);
        System.out.println("");
        Node.inOrderRecur(maxTreeHead);
        System.out.println("");
        Node.posOrderRecur(maxTreeHead);
    }

}

/**
 * 最大值树
 * 一个数组的MaxTree定义：
 * 数组必须没有重复元素
 * MaxTree是一颗二叉树，数组的每一个值对应一个二叉树节点。
 * 包括 MaxTree 树在内且在其中的每一颗子树上，值最大的节点都是树的头。
 *
 * @author tiankai.me@gmail.com on 2022/7/4 15:06.
 */
class Node {

    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 先序遍历
     * 中左右
     *
     * @author tiankai.me@gmail.com on 2022/7/4 18:29.
     */
    public static void preOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    /**
     * 中序遍历
     * 左中右
     *
     * @author tiankai.me@gmail.com on 2022/7/4 18:29.
     */
    public static void inOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        inOrderRecur(node.left);
        System.out.print(node.value + " ");
        inOrderRecur(node.right);
    }

    /**
     * 后序遍历
     * 左右中
     *
     * @author tiankai.me@gmail.com on 2022/7/4 18:29.
     */
    public static void posOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        posOrderRecur(node.left);
        posOrderRecur(node.right);
        System.out.print(node.value + " ");
    }

}