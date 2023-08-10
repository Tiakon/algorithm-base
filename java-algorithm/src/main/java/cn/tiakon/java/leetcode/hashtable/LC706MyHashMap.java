package cn.tiakon.java.leetcode.hashtable;

/**
 * 706. 设计哈希映射
 * https://leetcode.cn/problems/design-hashmap/description/
 * jdk hashmap的简易实现（数组+链表+自动扩容机制）
 *
 * @author tiankai.me@gmail.com on 2023-08-09 7:48.
 */
public class LC706MyHashMap {
    final float loadFactor = 0.75f;
    int capacity = 16;
    int size = 0;
    Object[] arrays;

    public LC706MyHashMap() {
        arrays = new Object[capacity];
    }

    public void put(int key, int value) {
        resize(size + 1);
        final int keyIndex = getIndex(key);
        if (arrays[keyIndex] != null) {
            Node node = (Node) arrays[keyIndex];
            while (node != null) {
                if (node.key == key) {
                    node.val = value;
                    break;
                } else if (node.next == null) {
                    node.next = new Node(key, keyIndex, value);
                    ++size;
                    break;
                }
                node = node.next;
            }
        } else {
            arrays[keyIndex] = new Node(key, keyIndex, value);
            ++size;
        }
    }

    private int getIndex(int key) {
        return key & (capacity - 1);
    }

    /**
     * 注意:扩容后需要重新计算key值的索引.
     *
     * @author tiankai.me@gmail.com on 2023-08-09 13:55.
     */
    private void resize(int newSize) {
        if (newSize > capacity * loadFactor && capacity < Integer.MAX_VALUE) {
            int newCapacity = (capacity >= (Integer.MAX_VALUE) >> 1) ? Integer.MAX_VALUE : capacity << 1;
            Object[] newArray = new Object[newCapacity];
            for (Object array : arrays) {
                if (array != null) {
                    Node node = (Node) array;
                    while (node != null) {
                        int newKeyIndex = node.key & (newCapacity - 1);
                        Node newNode = new Node(node.key, newKeyIndex, node.val);
                        if (newArray[newKeyIndex] != null) newNode.next = (Node) newArray[newKeyIndex];
                        newArray[newKeyIndex] = newNode;
                        node = node.next;
                    }
                }
            }
            arrays = newArray;
            capacity = newCapacity;
        }
    }

    public int get(int key) {
        final int keyIndex = getIndex(key);
        if (arrays[keyIndex] != null) {
            Node node = (Node) arrays[keyIndex];
            while (node != null) {
                if (node.key == key) return node.val;
                node = node.next;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int keyIndex = getIndex(key);
        if (arrays[keyIndex] != null) {
            Node node = (Node) arrays[keyIndex], prev = null;
            while (node != null) {
                if (node.key == key && prev == null) {
                    arrays[keyIndex] = node.next;
                    --size;
                    break;
                } else if (node.key == key && prev != null) {
                    prev.next = node.next;
                    --size;
                    break;
                } else prev = node;
                node = node.next;
            }
        }
    }
}

class Node {
    int key;
    int keyIndex;
    int val;
    Node next;

    public Node(int key, int keyIndex, int val) {
        this.key = key;
        this.keyIndex = keyIndex;
        this.val = val;
    }
}