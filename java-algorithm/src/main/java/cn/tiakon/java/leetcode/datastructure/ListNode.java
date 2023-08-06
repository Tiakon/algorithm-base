package cn.tiakon.java.leetcode.datastructure;
// class ListNode {
//    public ListNode pre;
//    public int val;
//    public ListNode next;
//    public ListNode() {
//    }
//    public ListNode(int val) {
//        this.val = val;
//    }
//    public ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
// public ListNode(ListNode pre, int val, ListNode next) {
//         this.pre = pre;
//         this.val = val;
//         this.next = next;
// }
//}

/**
 * 单链表
 * 双链表
 *
 * @author tiankai.me@gmail.com on 2023/7/30 下午1:27.
 */
public class ListNode<T> implements Cloneable {
    public ListNode<T> prev;
    public T val;
    public ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(ListNode<T> prev, T val) {
        this.prev = prev;
        this.val = val;
    }

    public ListNode(ListNode<T> prev, T val, ListNode<T> next) {
        this.prev = prev;
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        String ans;
        if (prev == null) ans = "ListNode{val=" + val + ",next=" + next + '}';
        else ans = "ListNode{pre=" + prev + ",val=" + val + ",next=" + next + '}';
        return ans;
    }

    // 深拷贝
    @Override
    public ListNode<T> clone() {
        ListNode<T> node = null;
        try {
            node = (ListNode<T>) super.clone();
            if (prev != null) node.prev = prev.clone();
            if (next != null) node.next = next.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return node;
    }
}