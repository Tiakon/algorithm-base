package cn.tiakon.java.zbook.chapter01.example03;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;

import java.util.*;

/**
 * 仅用递归函数和栈操作逆序一个栈
 *
 * @author tiankai.me@gmail.com on 2022/6/23 11:12.
 */
public class ReversedOrderStack {

    // 返回并移除栈中最后一个元素
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        final Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            final int lastElement = getAndRemoveLastElement(stack);
            stack.push(result);
            return lastElement;
        }
    }

    // 逆序
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {

        for (int j = 0; j < 10000; j++) {
            final int[] randomArray = MathRandomUtil.createRandomArray(10, 10);
            final Stack<Integer> stack = new Stack<>();
            final List<Integer> lists = new ArrayList<>(randomArray.length);
            for (int i : randomArray) {
                stack.push(i);  // 栈  :  先进后出，逆序了一次
                lists.add(i);   // 队列 : 先进先出
            }
            // 又逆序了一次
            reverse(stack);
            // 所以数组不需要逆序了
            // Collections.reverse(lists);
            // for (Integer list : lists) {
            //     System.out.printf("%d ", list);
            // }
            // System.out.println("");
            // MathRandomUtil.printStack(stack);

            for (int i = 0; i < lists.size(); i++) {
                Assert.assertEquals(lists.get(i), stack.pop());
            }
        }

    }

    public static void test() {
        final Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        MathRandomUtil.printStack(stack);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        MathRandomUtil.printStack(stack);
    }
}
