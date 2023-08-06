package cn.tiakon.java.leetcode.queue;

/**
 * 641. 设计循环双端队列
 * https://leetcode.cn/problems/design-circular-deque/
 *
 * @author tiankai.me@gmail.com on 2022/8/15 10:20.
 */
public class LC641DesignCircularDeque {

    static class MyCircularDeque {

        private Node head;
        private Node tail;
        private int size;
        private final int capacity;

        public MyCircularDeque(int k) {
            capacity = k;
            size = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            final Node cur = new Node(value);
            if (size == 0) {
                head = tail = cur;
                // 注意，应该对插入值单独创建一个实例，而不是分别创建实例。
                // head = new Node(value);
                // tail = new Node(value);
            } else {
                // 对于新来节点加入流程：
                // 1. 将head的pre指向 cur
                // 2. 将cur的next指向head
                // 3. 移动 head 到 cur
                head.pre = cur;
                cur.next = head;
                head = cur;
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            final Node cur = new Node(value);
            if (size == 0) {
                head = tail = cur;
            } else {
                tail.next = cur;
                cur.pre = tail;
                tail = cur;
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            // 直接移动head到next节点，并将next的pre置空
            head = head.next;
            if (head != null) {
                head.pre = null;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = tail.pre;
            if (tail != null) {
                tail.next = null;
            }
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return tail.data;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    static class Node {
        int data;
        Node next;
        Node pre;

        public Node(int data) {
            this.data = data;
        }
    }

    // https://leetcode.cn/problems/design-circular-deque/solution/shu-zu-shi-xian-de-xun-huan-shuang-duan-dui-lie-by/
    static class MyCircularDequeWithArray {
        // 1、不用设计成动态数组，使用静态数组即可
        // 2、设计 head 和 tail 指针变量
        // 3、head == tail 成立的时候表示队列为空
        // 4、tail + 1 == head
        // 环队列的容量，即队列中最多可以容纳的元素数量
        private int capacity;
        // 一个固定大小的数组，用于保存循环队列的元素
        private int[] arr;
        // 队列首元素对应的数组的索引
        private int front;
        // 队列尾元素对应索引的下一个索引
        private int rear;

        public MyCircularDequeWithArray(int k) {
            capacity = k + 1;
            arr = new int[capacity];

            // 头部指向第 1 个存放元素的位置
            // 插入时，先减，再赋值
            // 删除时，索引 +1（注意取模）
            front = 0;
            // 尾部指向下一个插入元素的位置
            // 插入时，先赋值，再加
            // 删除时，索引 -1（注意取模）
            rear = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            front = (front - 1 + capacity) % capacity;
            arr[front] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            arr[rear] = value;
            // 对于下标自增操作而言，只需要进行「加一取模」即可
            rear = (rear + 1) % capacity;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            // front 被设计在数组的开头，所以是 +1
            front = (front + 1) % capacity;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            // 而对于下标自减操作，由于考虑负值问题，需要进行「增加限定空间偏移后，进行减一再取模」
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            // 当 rear 为 0 时防止数组越界
            return arr[(rear - 1 + capacity) % capacity];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            // 注意：这个设计是非常经典的做法
            return (rear + 1) % capacity == front;
        }

    }

}



