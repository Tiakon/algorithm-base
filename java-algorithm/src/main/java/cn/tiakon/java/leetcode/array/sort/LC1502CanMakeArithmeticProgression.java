package cn.tiakon.java.leetcode.array.sort;

import java.util.Arrays;

/**
 * 1502. 判断能否形成等差数列
 * https://leetcode.cn/problems/can-make-arithmetic-progression-from-sequence/
 *
 * @author tiankai.me@gmail.com on 2022/11/14 上午10:57.
 */
public class LC1502CanMakeArithmeticProgression {
    /**
     * 先排序,如果数组是arr等差数列,则一定有 arr[i] * 2 == arr[i - 1] + arr[i + 1]  成立.
     *
     * @author tiankai.me@gmail.com on 2022/11/14 上午11:05.
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) return false;
        }
        return true;
    }
}
