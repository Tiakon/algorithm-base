package cn.tiakon.java.leetcode.linked.design;

import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 1472. 设计浏览器历史记录
 * https://leetcode.cn/problems/design-browser-history/
 *
 * @author tiankai.me@gmail.com on 2023-09-03 10:30.
 */
public class LC1472BrowserHistory {
    ListNode<String> curr;

    public LC1472BrowserHistory(String homepage) {
        this.curr = new ListNode<>(homepage);
    }

    public void visit(String url) {
        final ListNode<String> node = new ListNode<>(curr, url);
        final ListNode<String> next = curr.next;
        if (next != null) next.prev = null;
        curr.next = node;
        curr = node;
    }

    public String back(int steps) {
        while (steps-- > 0 && curr != null && curr.prev != null) {
            curr = curr.prev;
        }
        return curr.val;
    }

    public String forward(int steps) {
        while (steps-- > 0 && curr != null && curr.next != null) {
            curr = curr.next;
        }
        return curr.val;
    }

}


