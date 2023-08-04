package cn.tiakon.java.zbook.chapter01.example01;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Stack;

/**
 * 设计一个得到最小值的栈
 * 所有操作时间复杂度都是O(1)
 * 空间复杂度是O(n)
 *
 * @author tiankai.me@gmail.com on 2022/6/22 10:45.
 */
public class MyStack1 {

    public Stack<Integer> stackData;
    public Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        this.stackData.push(newNum);
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("The stack data is empty.");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        for (int j = 0; j < 10000; j++) {
            final MyStack1 myStack1 = new MyStack1();
            final int[] randomArray = MathRandomUtil.createRandomArray(10, 10);
            final int minValue = Arrays.stream(randomArray).min().getAsInt();
            for (int i : randomArray) {
                myStack1.push(i);
            }
            Assert.assertEquals(minValue, myStack1.getMin());
        }
    }

}
