package cn.tiakon.java.zbook.chapter01.example02;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;

import java.util.Stack;

/**
 * 用两个栈设计一个队列
 * 栈:先进后出
 * 队列:先进先出
 *
 * @author tiankai.me@gmail.com on 2022/6/22 11:15.
 */
public class TwoStacksQueue {

    private final Stack<Integer> stackPush;
    private final Stack<Integer> stackPop;

    public TwoStacksQueue() {
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    private void pourOut(){
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public int poll() {
        pourOut();
        return stackPop.pop();
    }

    public int peek() {
        pourOut();
        return stackPop.peek();
    }

    public static void main(String[] args) {
        for (int j = 0; j < 10000; j++) {
            final int[] randomArray = MathRandomUtil.createRandomArray(10, 10);
            final TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
            for (int i : randomArray) {
                twoStacksQueue.add(i);
            }
            for (int i : randomArray) {
                if (Math.random() < 0.3) {
                    Assert.assertEquals(i, twoStacksQueue.peek());
                }
                final int poll = twoStacksQueue.poll();
                Assert.assertEquals(i, poll);
            }
        }
    }

}
