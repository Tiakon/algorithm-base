package cn.tiakon.java.zbook.chapter01.example11;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最大值减去最小值小于或等于num的子数组数量✪✪✪
 * <p>
 * 给定数组arr和整数num，共返回有多少个子数组满足如下情况：
 * max(arr[i...j]) - min(arr[i...j])<=num
 * max(arr[i...j]) 表示子数组 arr[i...j] 中的最大值，min(arr[i...j])表示子数组 arr[i...j] 中的最小值、
 * <p>
 * 如果数组长度为N，请实现时间复杂度O(N)的解法。
 *
 * @author tiankai.me@gmail.com on 2022/7/25 22:12.
 */
public class SubarrayNum {

    public static int getSubarrayNum(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        final Deque<Integer> dequeMin = new ArrayDeque<Integer>();
        final Deque<Integer> dequeMax = new ArrayDeque<Integer>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                if (dequeMin.isEmpty() || dequeMin.peekLast() != j) {
                    while (!dequeMin.isEmpty() && arr[dequeMin.peekLast()] >= arr[j]) {
                        dequeMin.pollLast();
                    }
                    dequeMin.addLast(j);
                    while (!dequeMax.isEmpty() && arr[dequeMax.peekLast()] <= arr[j]) {
                        dequeMax.pollLast();
                    }
                    dequeMax.addLast(j);
                }
                if (arr[dequeMax.getFirst()] - arr[dequeMin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            res += j - i;
            if (dequeMin.peekFirst() == i) {
                dequeMin.pollFirst();
            }
            if (dequeMax.peekFirst() == i) {
                dequeMax.pollFirst();
            }
            i++;
        }
        return res;
    }

    @Test
    public void getSubarrayNumTest() {
        final int[] randomArray = MathRandomUtil.createRandomArray(10, 10);
        MathRandomUtil.printArray(randomArray);
        final int subarrayNum = SubarrayNum.getSubarrayNum(randomArray, 5);
        System.out.println(subarrayNum);
    }

}
