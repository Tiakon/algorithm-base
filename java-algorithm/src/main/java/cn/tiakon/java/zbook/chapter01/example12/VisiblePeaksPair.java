package cn.tiakon.java.zbook.chapter01.example12;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 求可见山峰对数
 * 描述：
 * 一个不含有负数的数组可以代表一圈环形山，每个位置的值代表山的高度。
 * 比如，{3,1,2,4,5}，{4,5,3,1,2}或{1,2,4,5,3}都代表同样结构的环形山。
 * 3->1->2->4->5->3 方向叫作 next 方向(逆时针)，
 * 3->5->4->2->1->3 方向叫作 last 方向(顺时针)。
 * 山峰 A 和 山峰 B 能够相互看见的条件为:
 * 1. 如果 A 和 B 是同一座山，认为不能相互看见。
 * 2. 如果 A 和 B 是不同的山，并且在环中相邻，认为可以相互看见。
 * 3. 如果 A 和 B 是不同的山，并且在环中不相邻，假设两座山高度的最小值为 min。如果 A 通过 next 方向到 B 的途中没有高度比 min 大的山峰，或者 A 通过 last 方向到 B 的途中没有高度比 min 大的山峰，认为 A 和 B 可以相互看见。
 * 原问题：
 * 给定一个不含有负数且不重复值的数组 arr，请问有多少对山峰能够相互看见？
 * 进阶问题：
 * 给定一个不含有负数且可能有重复值的数组 arr，请问有多少对山峰能够相互看见？
 * <p>
 * 假设数组长度为N，数组不重复要求时间复杂度为 O(1)，数组可能重复要求时间复杂度为 O(N)
 *
 * @author tiankai.me@gmail.com on 2022/7/27 11:49.
 */
public class VisiblePeaksPair {

    /**
     * 时间复杂度：O(N^2)
     *
     * @author tiankai.me@gmail.com on 2022/7/27 17:52.
     */
    public static List<RecordV1> getVisiblePeaksPair(int[] arr) {
        final List<RecordV1> res = new ArrayList<>();
        boolean isAdded = false;
        for (int i = 0; i < arr.length; i++) {
            final Stack<Integer> stack = new Stack<Integer>();
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i] && !isAdded) {
                    res.add(new RecordV1(arr[i], arr[j]));
                    isAdded = true;
                } else {
                    stack.push(j);
                }
            }
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && !isAdded) {
                    res.add(new RecordV1(arr[i], arr[j]));
                    isAdded = true;
                } else {
                    stack.push(j);
                }
            }
            while (!stack.isEmpty()) {
                if (arr[stack.peek()] > arr[i]) {
                    res.add(new RecordV1(arr[i], arr[stack.peek()]));
                    break;
                }
                stack.pop();
            }
            isAdded = false;
        }
        return res;
    }

    /**
     * 时间复杂度：O(N^2)
     *
     * @author tiankai.me@gmail.com on 2022/7/28 18:17.
     */
    public static List<RecordV1> getVisiblePeaksPairV2(int[] arr) {
        final List<RecordV1> res = new ArrayList<>();
        boolean isAdded = false;
        for (int i = 0; i < arr.length; i++) {
            final Stack<Integer> stack = new Stack<Integer>();
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[i] && !isAdded) {
                    res.add(new RecordV1(arr[i], arr[j]));
                    isAdded = true;
                } else {
                    stack.push(j);
                }
            }
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i] && !isAdded) {
                    res.add(new RecordV1(arr[i], arr[j]));
                    isAdded = true;
                } else {
                    stack.push(j);
                }
            }
            while (!stack.isEmpty()) {
                if (arr[stack.peek()] >= arr[i]) {
                    res.add(new RecordV1(arr[i], arr[stack.peek()]));
                    break;
                }
                stack.pop();
            }
            isAdded = false;
        }
        return res;
    }

    /**
     * 数组中不重复,可由公式得出可见山峰数量,时间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2022/7/27 18:18.
     */
    public static int getVisiblePeaksPairNum(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        if (arr.length == 2) {
            return 1;
        }
        return arr.length * 2 - 3;
    }

    @Test
    public void getVisiblePeaksPairTest() {
        // int[] arr = {3, 1, 2, 4, 5};
        int[] arr = {3, 4, 2, 7, 5};
        final List<RecordV1> visiblePeaksPair = getVisiblePeaksPair(arr);
        for (RecordV1 recordV1 : visiblePeaksPair) {
            System.out.println(recordV1);
        }
        final int visiblePeaksPairNum = VisiblePeaksPair.getVisiblePeaksPairNum(arr);
        Assert.assertEquals(visiblePeaksPair.size(), visiblePeaksPairNum);
    }

    @Test
    public void getVisiblePeaksPairWithNonRepeatTest() {
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int[] arr = MathRandomUtil.getNonRepeatArray(random.nextInt(10) + 10, 9);
            final List<RecordV1> visiblePeaksPair = getVisiblePeaksPair(arr);
            final int visiblePeaksPairNum = VisiblePeaksPair.getVisiblePeaksPairNum(arr);
            Assert.assertEquals(visiblePeaksPair.size(), visiblePeaksPairNum);
        }

    }

    /**
     * 数组中可能重复,求可见山峰数量,时间复杂度：O(N)
     *
     * @author tiankai.me@gmail.com on 2022/7/28 17:27.
     */
    public static int getVisibleNum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        // 先在环中找到其中一个最大值的位置，哪一个都行
        for (int i = 0; i < size; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        Stack<Record> stack = new Stack<Record>();
        // 先把（最大值，1）这个记录放入stack中
        stack.push(new Record(arr[maxIndex]));
        // 从最大值位置的下一位置开始沿next方便遍历
        int index = nextIndex(maxIndex, size);
        // 用"小找大"的方式统计所有可见山峰对
        int res = 0;
        // 遍历阶段开始，当index再次回到maxIndex的时候，说明转了一圈，遍历阶段就结束
        while (index != maxIndex) {
            // 当前数字arr[index]要进栈，判断会不会破坏第一维的数字从顶到底一次变大
            // 如果破坏了，就依次弹出栈顶记录，并计算山峰对数量
            while (stack.peek().value < arr[index]) {
                int k = stack.pop().times;
                // 弹出记录为（X，K）,如果 K==1，产生2对
                // 如果K>1,产生2K+C(2,K)对
                res += getInternalSum(k) + 2 * k;
            }
            // 当前数字 arr[index] 要进入栈了，如果和当前栈顶数字一样就合并
            // 不一样就把记录(arr[index],1)放入栈中
            if (stack.peek().value == arr[index]) {
                stack.peek().times++;
            } else {
                stack.push(new Record(arr[index]));
            }
            index = nextIndex(index, size);
        }
        // 清算阶段开始
        // 清算阶段的第1小阶段
        // 非栈中倒数第一，非栈中倒数第二的数
        while (stack.size() > 2) {
            int times = stack.pop().times;
            res += getInternalSum(times) + 2 * times;
        }
        // 清算阶段的第2小阶段
        // 栈中倒数第二的数
        if (stack.size() == 2) {
            int times = stack.pop().times;
            res += getInternalSum(times) + (stack.peek().times == 1 ? times : 2 * times);
        }
        // 清算阶段的第3小阶段
        // 栈中最后一个数
        res += getInternalSum(stack.pop().times);
        return res;
    }

    // 如果k==1,返回0；如果k>1,返回C(2,k)
    public static int getInternalSum(int k) {
        return k == 1 ? 0 : (k * (k - 1) / 2);
    }

    // 环形数组中当前位置为i,数组长度为size,返回i的下一个位置
    private static int nextIndex(int i, int size) {
        return i < (size - 1) ? (i + 1) : 0;
    }

    /**
     * 得到数组中最大值索引
     *
     * @author tiankai.me@gmail.com on 2022/7/28 17:30.
     */
    public static int getIndexForMaxValue(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int maxIndex = 0;
        // 先在环中找到其中一个最大值的位置，哪一个都行
        for (int i = 0; i < arr.length; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        return maxIndex;
    }

    @Test
    public void getIndexForMaxValueTest() {
        int[] arr = {5, 6, 3, 2, 7, 4, 5, 9, 8, 7};
        final int indexForMaxValue = getIndexForMaxValue(arr);
        Assert.assertEquals(7, indexForMaxValue);
    }

    @Test
    public void nextIndexTest() {
        Assert.assertEquals(1, nextIndex(0, 6));
        Assert.assertEquals(2, nextIndex(1, 6));
        Assert.assertEquals(3, nextIndex(2, 6));
        Assert.assertEquals(4, nextIndex(3, 6));
        Assert.assertEquals(5, nextIndex(4, 6));
        Assert.assertEquals(0, nextIndex(5, 6));
    }

    @Test
    public void getVisiblePeaksPairMaybeRepeatTest() {
        int[] arr = {3, 2, 5, 4, 3, 5, 4, 2, 4, 4, 5};
        // int[] arr = {3, 3, 4, 4, 2, 5, 4, 2, 3, 6, 6};
        final List<RecordV1> visiblePeaksPair = VisiblePeaksPair.getVisiblePeaksPairV2(arr);
        final int visiblePeaksPairNum = VisiblePeaksPair.getVisibleNum(arr);
        Assert.assertEquals(visiblePeaksPair.size(), visiblePeaksPairNum);
    }

    @Test
    public void getVisiblePeaksPairMaybeRepeatBenchmarkTest() {
        for (int i = 0; i < 1000; i++) {
            final int[] arr = MathRandomUtil.createRandomArray(10, 9);
            final List<RecordV1> visiblePeaksPair = VisiblePeaksPair.getVisiblePeaksPairV2(arr);
            final int visiblePeaksPairNum = VisiblePeaksPair.getVisibleNum(arr);
            if (visiblePeaksPair.size() != visiblePeaksPairNum) {
                System.out.println(i);
            }
            Assert.assertEquals(visiblePeaksPair.size(), visiblePeaksPairNum);
        }
    }

}

class Record {
    public int value;
    public int times;

    public Record(int value) {
        this.value = value;
        this.times = 1;
    }
}

class RecordV1 {

    private int leftIndex;
    private int rightIndex;

    public RecordV1(int leftIndex, int rightIndex) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }

    @Override
    public String toString() {
        return String.format("%d,%d", leftIndex, rightIndex);
    }
}
