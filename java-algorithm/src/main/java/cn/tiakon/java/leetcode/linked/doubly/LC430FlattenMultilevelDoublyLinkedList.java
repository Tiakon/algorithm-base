package cn.tiakon.java.leetcode.linked.doubly;

import cn.tiakon.java.leetcode.datastructure.Node;

/**
 * 430. 扁平化多级双向链表
 * https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * @author tiankai.me@gmail.com on 2023-08-06 21:41.
 */
public class LC430FlattenMultilevelDoublyLinkedList {
    /**
     * 模拟+深度优先遍历
     * <p>
     * 复杂度分析：
     * 时间复杂度：O(n)，其中 n 是链表中的节点个数。
     * 空间复杂度：O(n)。上述代码中使用的空间为深度优先搜索中的栈空间，如果给定的链表的「深度」为 d，那么空间复杂度为 O(d)。
     * 在最换情况下，链表中的每个节点的 next  都为空，且除了最后一个节点外，每个节点的 child 都不为空，
     * 整个链表的深度为 n，因此时间复杂度为 O(n)。
     *
     * @author tiankai.me@gmail.com on 2023-08-20 13:56.
     */
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node node) {
        Node curr = node, prev = null;
        while (curr != null) {
            Node childHead = curr.child;
            if (childHead != null) {
                Node childTail = dfs(childHead);
                curr.child = null;
                Node next = curr.next;
                curr.next = childHead;
                childHead.prev = curr;
                childTail.next = next;
                if (next != null) next.prev = childTail;
            }
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    /**
     * 可以将此链表当作特殊的二叉树，使用二叉树的前序遍历即可。
     *
     * @author tiankai.me@gmail.com on 2023-08-20 14:07.
     */
    Node last = null;
    public Node flattenV2(Node head) {
        if (head == null) return null;
        Node next = head.next;
        if (last != null) last.next = head;
        head.prev = last;
        last = head;
        flattenV2(head.child);
        head.child = null;
        flattenV2(next);
        return head;
    }

}