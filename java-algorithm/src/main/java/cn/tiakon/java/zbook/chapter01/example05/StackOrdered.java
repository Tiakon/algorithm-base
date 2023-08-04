package cn.tiakon.java.zbook.chapter01.example05;

import cn.tiakon.java.utils.MathRandomUtil;
import cn.tiakon.java.utils.RandomStackAndArray;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Stack;

/**
 * 如何用一个栈实现另一个栈的排序（从上到下，由大到小）
 *
 * @author tiankai.me@gmail.com on 2022/6/29 14:16.
 */
public class StackOrdered {

    private final Stack<Integer> tempStack = new Stack<>();

    // 移除并返回栈中最小的值
    private int getAndRemoveMinValue(Stack<Integer> stack1) {
        final Integer pop = stack1.pop();
        if (stack1.isEmpty()) {
            return pop;
        } else {
            int lastValue = getAndRemoveMinValue(stack1);
            if (lastValue > pop) {
                stack1.push(lastValue);
                lastValue = pop;
            } else {
                stack1.push(pop);
            }
            return lastValue;
        }
    }

    // 方式一
    public Stack<Integer> ordered(Stack<Integer> stack1) {
        while (!stack1.isEmpty()) {
            final int minValue = getAndRemoveMinValue(stack1);
            tempStack.push(minValue);
        }
        return tempStack;
    }

    // 方式二，最优解
    public static Stack<Integer> sortStackByStack(Stack<Integer> stack) {
        final Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            final Integer cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        // while (!help.isEmpty()) {
        //     stack.push(help.pop());
        // }
        return help;
    }

    public static void main(String[] args) {
        int testCount = 1;
        for (int j = 0; j < testCount; j++) {
            int randomLen = (int) (Math.random() * 100);
            int randomValue = (int) (Math.random() * 100 + 10);
            RandomStackAndArray randomStackAndArray = MathRandomUtil.getRandomStackAndArray(randomLen, randomValue);
            final int[] randomArray = randomStackAndArray.getRandomArray();
            final Stack<Integer> randomStack = randomStackAndArray.getRandomStack();

            final Stack<Integer> ordered = new StackOrdered().ordered(randomStack);
            // final Stack<Integer> ordered = StackOrdered.sortStackByStack(randomStack);

            final Stack<Integer> stack2 = new Stack<>();
            for (int i : Arrays.stream(randomArray).sorted().toArray()) {
                stack2.push(i);
            }
            while (!stack2.isEmpty()) {
                // System.out.printf("%d ", stack2.pop());
                Assert.assertEquals(ordered.pop(), stack2.pop());
            }
        }
    }

}
