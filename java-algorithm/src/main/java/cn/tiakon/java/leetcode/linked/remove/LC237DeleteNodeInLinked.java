package cn.tiakon.java.leetcode.linked.remove;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 237. 删除链表中的节点
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 *
 * @author tiankai.me@gmail.com on 2022/10/31 下午12:02.
 */
public class LC237DeleteNodeInLinked {
    /**
     * 用下一个节点的值与引用替换掉当前节点的值与引用
     * 这道题细思极恐：如何让自己在世界上消失，但又不死？ —— 将自己完全变成另一个人，再杀了那个人就行了。
     * @author tiankai.me@gmail.com on 2022/10/31 下午12:20.
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
    }
}
