package cn.tiakon.java.leetcode.datastructure;
//class ListNode {
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
//}
/**
 * 单向链表
 * @author tiankai.me@gmail.com on 2023/7/30 下午1:27.
 */
public class ListNode<T> implements Cloneable {
    public T val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    // 深拷贝
    @Override
    public ListNode clone() {
        ListNode node = null;
        try {
            node = (ListNode) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (next!=null){
            node.next = next.clone();
        }
        return node;
    }
}