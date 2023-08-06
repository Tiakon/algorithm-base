package cn.tiakon.java.leetcode.linked;

class LC707MyLinkedList {
    int val;
    LC707MyLinkedList next;

    public LC707MyLinkedList() {

    }

    public int get(int index) {
        int ans = -1, count = 0;
        if (index < 0) return ans;
        LC707MyLinkedList pre = this;
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
        LC707MyLinkedList node = new LC707MyLinkedList();
        node.val = val;
        if (next != null) node.next = this.next;
        this.next = node;
    }

    public void addAtTail(int val) {
        LC707MyLinkedList node = new LC707MyLinkedList();
        node.val = val;
        LC707MyLinkedList pre = this;
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
            LC707MyLinkedList node = new LC707MyLinkedList();
            node.val = val;
            LC707MyLinkedList pre = this;
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
            LC707MyLinkedList pre = this;
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

    private void deleteNode(LC707MyLinkedList node) {
        if (node.next != null) {
            LC707MyLinkedList nextNode = node.next;
            node.next = nextNode.next;
            nextNode.next = null;
        }
    }

}