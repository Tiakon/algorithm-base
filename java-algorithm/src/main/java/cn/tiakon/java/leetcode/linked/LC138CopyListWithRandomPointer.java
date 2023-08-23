package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * https://leetcode.cn/problems/copy-list-with-random-pointer/
 *
 * @author tiankai.me@gmail.com on 2023-08-23 7:22.
 */
public class LC138CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        int index = 0;
        final Map<Node, Integer> map = new HashMap<>();
        final Map<Integer, Node> newMap = new HashMap<>();
        Node dummy = new Node(-1);
        Node curr = head, node = dummy;
        while (curr != null) {
            map.put(curr, index);
            final Node newNode = new Node(curr.val);
            node.next = newNode;
            newMap.put(index++, newNode);
            curr = curr.next;
            node = node.next;
        }
        curr = head;
        node = dummy.next;
        while (curr != null) {
            final Integer i = map.get(curr.random);
            node.random = newMap.getOrDefault(i, null);
            curr = curr.next;
            node = node.next;
        }
        return dummy.next;
    }

    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    /**
     * 回溯 + 哈希表
     * 复杂度分析:
     * 时间复杂度：O(n)，其中 n 是链表的长度。对于每个节点，我们至多访问其「后继节点」和「随机指针指向的节点」各一次，均摊每个点至多被访问两次。
     * 空间复杂度：O(n)，其中 n 是链表的长度。为哈希表的空间开销。
     *
     * @author tiankai.me@gmail.com on 2023-08-23 10:28.
     */
    public Node copyRandomListV2(Node head) {
        if (head == null) return null;
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomListV2(head.next);
            headNew.random = copyRandomListV2(head.random);
        }
        return cachedNode.get(head);
    }

    public Node copyRandomListV3(Node head) {
        if (head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
