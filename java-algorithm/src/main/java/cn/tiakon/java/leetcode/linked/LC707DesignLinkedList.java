package cn.tiakon.java.leetcode.linked;

import cn.tiakon.java.leetcode.datastructure.DequeNode;
import cn.tiakon.java.leetcode.datastructure.ListNode;

/**
 * 707. 设计链表
 * https://leetcode.cn/problems/design-linked-list/
 * 基于节点设计
 *
 * @author tiankai.me@gmail.com on 2023/7/29 下午9:52.
 */
public class LC707DesignLinkedList {
    int size = 0;
    ListNode head;

    public LC707DesignLinkedList() {
        head = new ListNode();
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return (int) cur.val;
    }

    //    public void addAtHead(int val) {
//        ListNode newNode = new ListNode(val);
//        if (head.next != null) newNode.next = head.next;
//        head.next = newNode;
//    }
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //    public void addAtTail(int val) {
//        ListNode node = new ListNode(val);
//        ListNode temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = node;
//    }
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        size++;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    //    public void deleteAtIndex(int index) {
//        if (index < 0) return;
//        int count = 0;
//        ListNode pre = head;
//        while (pre != null) {
//            if (count == index) {
//                deleteNode(pre);
//                break;
//            }
//            ++count;
//            pre = pre.next;
//        }
//    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

//    private void deleteNode(ListNode node) {
//        ListNode deleteNode = node.next;
//        if (deleteNode != null) {
//            node.next = deleteNode.next;
//            deleteNode.next = null;
//        }
//    }
}

class DequeLinkedList {
    int size;
    DequeNode head;
    DequeNode tail;

    public DequeLinkedList() {
        head = new DequeNode();
        tail = head;
    }

    public int get(int index) {
        int ans = -1, count = 0;
        if (index < 0 || index > size - 1) return ans;
        if (index > (size << 1)) {
            count = size - 1;
            DequeNode node = tail.pre;
            while (node != null) {
                if (count == index) {
                    ans = node.val;
                    break;
                }
                --count;
                node = node.pre;
            }
        } else {
            DequeNode node = head.next;
            while (node != null) {
                if (count == index) {
                    ans = node.val;
                    break;
                }
                ++count;
                node = node.next;
            }
        }
        return ans;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size - 1) return;
        DequeNode addNode = new DequeNode(val);
        ++size;
        if (index > (size << 1)) {
            DequeNode temp = tail;
            for (int i = size - 1; i >= index; i--) {
                temp = temp.pre;
            }
            DequeNode pre = temp.pre;
            pre.next = addNode;
            addNode.pre = pre;
            addNode.next = temp;
            temp.pre = addNode;
        } else {
            DequeNode temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            DequeNode nextNode = temp.next;
            temp.next = addNode;
            addNode.next = nextNode;
            nextNode.pre = addNode;
            addNode.pre = temp;
        }
    }

    public void deleteAtIndex(int index) {

    }

}

class MyLinkedList {
    int val;
    MyLinkedList next;

    public MyLinkedList() {

    }

    public int get(int index) {
        int ans = -1, count = 0;
        if (index < 0) return ans;
        MyLinkedList pre = this;
        while (pre.next != null) {  // 循环判断节点的引用是否为空,为空就是尾节点.
            pre = pre.next;
            if (count == index) {
                ans = pre.val;
                break;
            } else ++count;
        }
        return ans;
    }

    public void addAtHead(int val) {
        MyLinkedList node = new MyLinkedList();
        node.val = val;
        if (next != null) node.next = this.next;
        this.next = node;
    }

    public void addAtTail(int val) {
        MyLinkedList node = new MyLinkedList();
        node.val = val;
        MyLinkedList pre = this;
        while (pre.next != null) {  // 循环判断节点的引用是否为空,为空就是尾节点.
            pre = pre.next;
        }
        pre.next = node;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) return;
        if (index == 0) addAtHead(val);
        else {
            int count = 0;
            MyLinkedList node = new MyLinkedList();
            node.val = val;
            MyLinkedList pre = this;
            while (pre.next != null) {
                if (count == index) {
                    node.next = pre.next;
                    pre.next = node;
                    return;
                } else ++count;
                pre = pre.next;
            }
            if (count == index) {
                node.next = pre.next;
                pre.next = node;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0) return;
        if (index == 0) deleteNode(this);
        else {
            int count = 0;
            MyLinkedList pre = this;
            while (pre.next != null) {
                if (count == index) {
                    deleteNode(pre);
                    break;
                }
                ++count;
                pre = pre.next;
            }
        }
    }

    private void deleteNode(MyLinkedList node) {
        if (node.next != null) {
            MyLinkedList nextNode = node.next;
            node.next = nextNode.next;
            nextNode.next = null;
        }
    }

}