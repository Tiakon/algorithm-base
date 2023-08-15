package cn.tiakon.java.leetcode.linked.doubly;

import cn.tiakon.java.leetcode.datastructure.NodeV2;

/**
 * 430. 扁平化多级双向链表
 * https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * @author tiankai.me@gmail.com on 2023-08-06 21:41.
 */
public class LC430FlattenMultilevelDoublyLinkedList {
    public NodeV2 flatten(NodeV2 head) {
        NodeV2 curr = head;
        flattenNode(curr);
        return head;
    }

    public NodeV2 flattenNode(NodeV2 node) {
        NodeV2 curr = node;
        while (curr != null && curr.next != null) {
            NodeV2 childHead = curr.child;
            while (childHead != null) {
                NodeV2 childTail = flattenNode(childHead);
                curr.child = null;
                NodeV2 next = curr.next;
                curr.next = childHead;
                childHead.prev = curr;
                childTail.next = next;
                next.prev = childTail;
                childHead = null;
            }
            curr = curr.next;
        }
        return curr;
    }

}