package cn.tiakon.java.leetcode.simulation;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 *
 * @author tiankai.me@gmail.com on 2022/11/26 下午9:18.
 */
public class LC232ImplementQueueUsingStacks {

    // 使用两个栈,poll或peek时,将栈倒入另一个栈中.
    class MyQueue {

        Deque<Integer> stackPush;
        Deque<Integer> stackPop;

        public MyQueue() {
            stackPush = new ArrayDeque<>();
            stackPop = new ArrayDeque<>();
        }

        public void push(int x) {
            stackPush.push(x);
        }

        public int pop() {
            if (!stackPop.isEmpty()) return stackPop.pop();
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
            return stackPop.pop();
        }

        public int peek() {
            if (!stackPop.isEmpty()) return stackPop.peek();
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
            return stackPop.peek();
        }

        public boolean empty() {
            return stackPush.isEmpty() && stackPop.isEmpty();
        }
    }

    @Test
    public void myQueueTest() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        Assert.assertEquals(1,myQueue.peek());
        Assert.assertEquals(1,myQueue.pop());
        Assert.assertFalse(myQueue.empty());
    }

}
