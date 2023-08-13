package cn.tiakon.java.leetcode.simulation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * https://leetcode.cn/problems/implement-stack-using-queues/
 *
 * @author tiankai.me@gmail.com on 2022/11/26 下午9:46.
 */
public class LC225ImplementStackUsingQueues {
    class MyStack {
        Queue<Integer> queuePush;
        Queue<Integer> queuePop;
        public MyStack() {
            queuePush = new LinkedList<>();
            queuePop = new LinkedList<>();
        }
        public void push(int x) {
            queuePush.add(x);
            while (!queuePush.isEmpty()) {
                queuePop.add(queuePush.poll());
            }
        }
        public int pop() {
            while (!queuePush.isEmpty()) {
                queuePop.add(queuePush.poll());
            }
            if (queuePop.isEmpty()) throw new RuntimeException("queuePop is empty!");
            return queuePop.poll();
        }
        public int top() {
            while (!queuePush.isEmpty()) {
                queuePop.add(queuePush.poll());
            }
            if (queuePop.isEmpty()) throw new RuntimeException("queuePop is empty!");
            return queuePop.peek();
        }
        public boolean empty() {
            return queuePush.isEmpty() && queuePop.isEmpty();
        }
    }
}
