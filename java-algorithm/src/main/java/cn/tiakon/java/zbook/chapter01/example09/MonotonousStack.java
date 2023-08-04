package cn.tiakon.java.zbook.chapter01.example09;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈结构
 * 给定一个不含有重复值的数组 arr ,找到每一个i位置左边和右边离i位置最近且值比arr[i] 小的位置，返回所有位置相应的信息。
 * 0 1 2 3 4 5 6
 * arr = {3,4,1,5,6,2,7}
 * 返回如下二维数组作为结果：
 * {
 * {-1,2},
 * {0,2},
 * {-1,-1},
 * {2,5},
 * {3,5},
 * {2,-1},
 * {5,-1},
 * }
 * 进阶问题:给定一个可能含有重复值的数组 arr ,找到每一个i位置左边和右边离i位置最近且值比arr[i] 小的位置，返回所有位置相应的信息。
 * 要求： 原问题和进阶问题解法，时间复杂度都达到 O(N)
 *
 * @author tiankai.me@gmail.com on 2022/7/5 15:10.
 */
public class MonotonousStack {

    /**
     * 时间复杂度 O(N^2)
     *
     * @author tiankai.me@gmail.com on 2022/7/5 16:54.
     */
    public int[][] getLeftAndRightFirstMinValue(int[] arr) {
        if (arr == null) {
            return new int[0][0];
        }
        final int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            final int leftFirstLessValue = getLeftFirstLessValueIndex(i, arr);
            final int rightFirstLessValue = getRightFirstLessValueIndex(i, arr);
            res[i][0] = leftFirstLessValue;
            res[i][1] = rightFirstLessValue;
        }
        return res;
    }

    public int getLeftFirstLessValueIndex(int index, int[] arr) {
        int leftMinValue = -1;
        // 从它左边向右边比较大小
        for (int i = index - 1; i >= 0; i--) {
            if (arr[index] > arr[i]) {
                leftMinValue = i;
                break;
            }
        }
        return leftMinValue;
    }

    public int getRightFirstLessValueIndex(int index, int[] arr) {
        int rightMinValue = -1;
        // 从它右边开始比较大小
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[index] > arr[i]) {
                rightMinValue = i;
                break;
            }
        }
        return rightMinValue;
    }

    // 时间复杂度 O(N^2)
    public int[][] getLeftAndRightFirstMinValueV2(int[] arr) {
        if (arr != null) {
            throw new NullPointerException("The array cannot be empty. ");
        }
        final int[][] res = new int[arr.length][2];
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                final Integer popIndex = stack.pop();
                final Integer rightIndex = i;
                final Integer leftIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = rightIndex;
                res[popIndex][1] = leftIndex;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            final Integer popIndex = stack.pop();
            res[popIndex][0] = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][1] = -1;
        }
        return res;
    }

    // 时间复杂度 O(N^2)
    public int[][] rightWay(int[] arr) {
        final int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }

    /**
     * 大多数情况下当输入是数组，可以利用栈或队列暂存数据，实现O(N)的时间复杂度。
     * 当元素不满足条件时，入栈，可通过 while 循环，将数据进行处理，满足条件后输出。
     * <p>
     * <p>
     * 时间复杂度 O(N)
     *
     * @author tiankai.me@gmail.com on 2022/7/5 18:05.
     */
    private int[][] getNearLessNoRepeat(int[] arr) {
        final int[][] res = new int[arr.length][2];
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int popIndex = stack.pop();
                final int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            final Integer popIndex = stack.pop();
            final int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    /**
     * 进阶问题的 O(N) 解法
     *
     * @author tiankai.me@gmail.com on 2022/7/19 0:04.
     */
    private int[][] getNearLessMayRepeat(int[] arr) {
        if (arr == null) {
            throw new NullPointerException("The array cannot be empty.");
        }
        final int[][] res = new int[arr.length][2];
        final Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                final List<Integer> popIndex = stack.pop();
                // 取位于下面位置的列表中，最晚加入的那个
                final int leftMinIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popi : popIndex) {
                    res[popi][0] = leftMinIndex;
                    res[popi][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                final List<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                stack.push(arrayList);
            }
        }
        while (!stack.isEmpty()) {
            final List<Integer> popIndex = stack.pop();
            // 取位于下面位置的列表中，最晚加入的那个
            final int leftMinIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer popi : popIndex) {
                res[popi][0] = leftMinIndex;
                res[popi][1] = -1;
            }
        }
        return res;
    }

    // 左右最小值 O(N^2) 测试
    @Test
    public void getLeftAndRightFirstMinValueTest() {
        final int[] nonRepeatArray = {3, 4, 1, 5, 6, 2, 7};
        final MonotonousStack stack = new MonotonousStack();
        final int[][] leftAndRightFirstMinValue = stack.getLeftAndRightFirstMinValue(nonRepeatArray);
        MathRandomUtil.print2DArray(leftAndRightFirstMinValue);
    }

    // 左右最小值 O(N) 测试
    @Test
    public void getNearLessNoRepeatTest() {
        final int[] nonRepeatArray = {3, 4, 1, 5, 6, 2, 7};
        final MonotonousStack stack = new MonotonousStack();
        final int[][] leftAndRightFirstMinValue = stack.getNearLessNoRepeat(nonRepeatArray);
        // -1 2
        // 0 2
        // -1 -1
        // 2 5
        // 3 5
        // 2 -1
        // 5 -1
        MathRandomUtil.print2DArray(leftAndRightFirstMinValue);
    }

    // 进阶版，左右最小值 O(N) 测试
    @Test
    public void getNearLessMayRepeatTest() {

    }

    // 测试二维数组
    @Test
    public void ddArrayTest() {
        // 3行，2列
        final int[][] ints = new int[3][2];
        ints[0][0] = 1;
        ints[0][1] = 1;
        ints[1][0] = 2;
        ints[1][1] = 2;
        ints[2][0] = 3;
        ints[2][1] = 3;
        MathRandomUtil.print2DArray(ints);
    }

}





