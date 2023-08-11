package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 725. 分隔链表
 * https://leetcode.cn/problems/split-linked-list-in-parts/
 *
 * @author tiankai.me@gmail.com on 2023-08-11 7:20.
 */
public class LC725SplitLinkedListInParts {

    /**
     * 链表分成k组，尽可能均分。且前面组的长度要大于后面组的长度。
     * 根据链表长度取模，模不为0时，在均分k个组时就多分一个节点，模随每组递减，直到为0；
     * <p>
     * 复杂度分析：
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2023-08-11 11:50.
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode temp = head, node = head;
        while (temp != null && ++size > 0) temp = temp.next;
        ListNode[] ans;
        int num = size / k, i = size % k;
        ans = new ListNode[k];
        for (int j = 0; j < k && node != null; j++) {
            ans[j] = node;
            for (int l = 1; l < num; l++) node = node.next;
            if (num != 0 && i-- > 0) node = node.next;
            if (node != null) {
                ListNode currLast = node;
                node = node.next;
                currLast.next = null;
            }
        }
        return ans;
    }

}
