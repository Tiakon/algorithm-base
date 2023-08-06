package cn.tiakon.java.leetcode.queue;

/**
 * 622. 设计循环队列
 * https://leetcode.cn/problems/design-circular-queue/
 * 题解：https://leetcode.cn/problems/design-circular-queue/solution/she-ji-xun-huan-dui-lie-by-leetcode-solu-1w0a/
 *
 * @author tiankai.me@gmail.com on 2022/8/15 15:35.
 */
public class LC622DesignCircularQueue {
    static class MyCircularQueue {

        private int front;
        private int rear;
        private final int capacity;
        private final int[] elements;

        // 在循环队列中，当队列为空，可知 front=rear；而当所有队列空间全占满时，也有 front=rear。
        // 为了区别这两种情况，假设队列使用的数组有 capacity 个存储空间，则此时规定循环队列最多只能有 capacity−1 个队列元素，
        // 当循环队列中只剩下一个空存储单元时，则表示队列已满。
        // 初始化队列，同时 base 数组的空间初始化大小为 k+1。front,rear 全部初始化为 0
        // 计算队列当前的长度: (rear−front+capacity) mod capacity
        public MyCircularQueue(int k) {
            capacity = k + 1;
            elements = new int[capacity];
            // rear:指向队列尾部的下一个位置
            front = rear = 0;
        }

        // 在队列的尾部插入一个元素，并更新队尾的索引： (rear+1) mod capacity
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            elements[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        // 从队首取出一个元素，并更新队首的索引： (front+1) mod capacity
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            return true;
        }

        // 返回队首的元素，需要检测队列是否为空
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return elements[front];
        }

        // 返回队尾的元素，需要检测队列是否为空。计算队列尾部索引： (rear - 1 + capacity) % capacity
        // 由于考虑负值问题，需要进行「增加限定空间偏移后，进行减一再取模」。
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return elements[(rear - 1 + capacity) % capacity];
        }

        // 检测队列是否为空，根据之前的定义只需判断 rear 是否等于 front
        public boolean isEmpty() {
            return front == rear;
        }

        // 检测队列是否已满，根据之前的定义只需判断 front 是否等于 (rear+1) mod capacity
        // 数组大小固定,当 rear 循环到数组的前面，要从后面追上 front，还差一格的时候，判定队列为满
        // front -> 0 1 2 3 <- rear ,cacpcity=4，刚好front == (rear + 1) % cacpcity 成立。
        public boolean isFull() {
            return front == (rear + 1) % capacity;
        }
    }
}


