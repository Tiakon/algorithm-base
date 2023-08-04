package cn.tiakon.java.zbook.chapter01.example01;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;

import java.util.Arrays;

public class MyStack2 extends MyStack1 {

    @Override
    public void push(int newNum) {
        this.stackData.push(newNum);
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }else{
            final Integer newMin = stackMin.peek();
            stackMin.push(newMin);
        }
    }

    @Override
    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("You stack is empty.");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public static void main(String[] args) {
        for (int j = 0; j < 10000; j++) {
            final MyStack2 myStack2 = new MyStack2();
            final int[] randomArray = MathRandomUtil.createRandomArray(10, 10);
            final int minValue = Arrays.stream(randomArray).min().getAsInt();
            for (int i : randomArray) {
                myStack2.push(i);
            }
            Assert.assertEquals(minValue, myStack2.getMin());
        }
    }


}
