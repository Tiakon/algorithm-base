package cn.tiakon.java.leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;
import java.util.Stack;

/**
 * 155. 最小栈
 * https://leetcode.cn/problems/min-stack/
 *
 * @author tiankai.me@gmail.com on 2023-08-02 13:11.
 */
public class LC155MinStack {

    final Stack<Integer> stack1;
    final Stack<Integer> stack2;
    /**
     * 复杂度分析
     * 时间复杂度：对于题目中的所有操作，时间复杂度均为 O(1)。因为栈的插入、删除与读取操作都是 O(1)，我们定义的每个操作最多调用栈操作两次。
     * 空间复杂度：
     * O(n)，其中 n 为总操作数。最坏情况下，我们会连续插入 n 个元素，此时两个栈占用的空间为 O(n)。
     *
     * @author tiankai.me@gmail.com on 2023-08-02 14:25.
     */
    public LC155MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if (!stack2.empty()) {
            if (val <= stack2.peek()) stack2.push(val);
        } else stack2.push(val);
    }

    public void pop() {
        Integer ans = null;
        if (!stack1.empty()) ans = stack1.pop();
        if (!stack2.empty() && Objects.equals(ans, stack2.peek())) stack2.pop();
    }

    public int top() {
        Integer ans = null;
        if (!stack1.empty()) ans = stack1.peek();
        return ans;
    }

    public int getMin() {
        Integer ans = null;
        if (!stack2.empty()) ans = stack2.peek();
        return ans;
    }

    @Test
    public void case01Test() {
        LC155MinStack minStack = new LC155MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.getMin());   // 返回 -3.
        minStack.pop();
        Assert.assertEquals(0, minStack.top());      // 返回 0.
        Assert.assertEquals(-2, minStack.getMin()); // 返回 -2.
    }

    @Test
    public void case02Test() {
        LC155MinStack minStack = new LC155MinStack();
        minStack.push(-1);
        Assert.assertEquals(-1, minStack.getMin());
        Assert.assertEquals(-1, minStack.top());
        Assert.assertEquals(-1, minStack.getMin());
        minStack.pop();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(0, minStack.top());
        Assert.assertEquals(-2, minStack.getMin());
    }

    @Test
    public void case03Test() {
        // ["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
        // [[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]
        LC155MinStack minStack = new LC155MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        Assert.assertEquals(-1024, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(-1024, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(512, minStack.getMin());
    }

    @Test
    public void case04Test() {
        // ["MinStack","push","push","push","getMin","top","pop","getMin"]
        // [[],[-2],[0],[-1],[],[],[],[]]
        LC155MinStack minStack = new LC155MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);

        Assert.assertEquals(-2, minStack.getMin());
        Assert.assertEquals(-1, minStack.top());
        minStack.pop();
        Assert.assertEquals(-2, minStack.getMin());
    }
}
