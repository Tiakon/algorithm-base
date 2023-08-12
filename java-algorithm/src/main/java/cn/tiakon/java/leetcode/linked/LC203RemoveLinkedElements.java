package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 203. 移除链表元素
 * https://leetcode.cn/problems/remove-linked-list-elements/
 *
 * @author tiankai.me@gmail.com on 2022/10/30 下午7:07.
 */
public class LC203RemoveLinkedElements {

    // 递归,从下至上
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements(head.next, val);
        return (int) head.val == val ? head.next : head;
    }

    public ListNode removeElementsV2(ListNode head, int val) {
        ListNode node = head;
        while (node != null && (int) node.val == val) {
            node = node.next;
            head = node;
        }
        ListNode preNode = null;
        while (node != null) {
            if ((int) node.val == val) preNode.next = node.next;
            else preNode = node;
            node = node.next;
        }
        return head;
    }

    /**
     * 双百效率,添加虚拟头结点,统一处理逻辑
     * 复杂度分析:
     * 时间复杂度：O(n)
     * 空间复杂度：忽略递归带来的额外空间开销。复杂度为 O(1)
     *
     * @author tiankai.me@gmail.com on 2022/10/31 上午11:56.
     */
    public ListNode removeElementsV3(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        dfs(dummy, dummy.next, val);
        return dummy.next;
    }

    private void dfs(ListNode prev, ListNode root, int val) {
        if (root == null) return;
        if ((int) root.val == val) prev.next = root.next;
        else prev = root;
        dfs(prev, prev.next, val);
    }

}