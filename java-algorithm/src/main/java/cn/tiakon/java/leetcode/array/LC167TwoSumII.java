package cn.tiakon.java.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author tiankai.me@gmail.com on 2022/8/12 22:46.
 */
public class LC167TwoSumII {
    /**
     * 解题思路：使用哈希表
     * 当需要确定某元素是否出现或存在时，可以使用哈希表。
     * 1. 在遍历数组的同时，通过 target - nums[i] 进行查找差值
     * 2. 不会出现重复索引和元素的问题
     * 复杂度分析：
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 缺点：
     * 没有利用数组有序的性质，空间复杂度没有达到最优。
     *
     * @author tiankai.me@gmail.com on 2022/8/14 17:28.
     */
    public int[] twoSum(int[] numbers, int target) {
        final Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(target - numbers[i])) {
                return new int[]{hashMap.get(target - numbers[i]) + 1, i + 1};
            }
            hashMap.put(numbers[i], i);
        }
        return new int[0];
    }

    /**
     * 二分法
     * 1. 通过历数组中的数，减去 target 得到的差值，再去数组中做二分查找。
     * 2. 在寻找差值时，只在减数的右侧寻找，可以避免取到重复值。
     * 复杂度分析：
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2022/8/14 17:31.
     */
    public int[] twoSumV2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            final int value = target - numbers[i];
            int l = i + 1, r = numbers.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (value == numbers[mid]) {
                    return new int[]{i + 1, mid + 1};
                } else if (value > numbers[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return new int[0];
    }

    /**
     * 双指针，缩减搜索空间
     * 复杂度分析

     * 解题思路：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/solution/yi-zhang-tu-gao-su-ni-on-de-shuang-zhi-zhen-jie-fa/
     * <p>
     * 使用双指针如何确定中间结果没有遗漏？
     * 1. 根据提意返回的两元素下标范围在左指针l与右指针r所组成的笛卡尔积中，倒三角的部分。
     * 2. 每次查找只比较倒三角，右上角的位置即(l=0,r=len-1),
     * 2.1 当该位置(l=0,r=len-1)> target值时，说明结果不在倒三角的第len-1列上，因为此时l最小，r最大，应该减少r，故排除len-1列。
     * 2.2 当该位置(l=0,r=len-1)< target值时，说明结果不在倒三角的第0列上，因为此时r最大，l最小，应该增加l，故排除i=0行。
     * 复杂度分析：
     * 时间复杂度：O(n)，其中 n 是数组的长度。两个指针移动的总次数最多为 n 次。
     * 空间复杂度：O(1)。
     *
     * @author tiankai.me@gmail.com on 2022/8/14 23:14.
     */
    public int[] twoSumV3(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void twoSumTest() {
        final LC167TwoSumII lc167TwoSumII = new LC167TwoSumII();
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = lc167TwoSumII.twoSum(arr, target);
        // MathRandomUtil.printArray(twoSum);
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum);

        arr = new int[]{2, 3, 4};
        target = 6;
        twoSum = lc167TwoSumII.twoSum(arr, target);
        // MathRandomUtil.printArray(twoSum);
        Assert.assertArrayEquals(new int[]{1, 3}, twoSum);


        arr = new int[]{-1, 0};
        target = -1;
        twoSum = lc167TwoSumII.twoSum(arr, target);
        // MathRandomUtil.printArray(twoSum);
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum);

        arr = new int[]{3, 3};
        target = 6;
        twoSum = lc167TwoSumII.twoSum(arr, target);
        // MathRandomUtil.printArray(twoSum);
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum);

        arr = new int[]{1, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1, 7, 1, 1, 1, 1, 1};
        target = 11;
        twoSum = lc167TwoSumII.twoSum(arr, target);
        // MathRandomUtil.printArray(twoSum);
        Assert.assertArrayEquals(new int[]{6, 12}, twoSum);
    }

    @Test
    public void twoSumV2Test() {
        final LC167TwoSumII lc167TwoSumII = new LC167TwoSumII();
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = lc167TwoSumII.twoSumV2(arr, target);
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum);

        arr = new int[]{2, 3, 4};
        target = 6;
        twoSum = lc167TwoSumII.twoSumV2(arr, target);
        Assert.assertArrayEquals(new int[]{1, 3}, twoSum);


        arr = new int[]{-1, 0};
        target = -1;
        twoSum = lc167TwoSumII.twoSumV2(arr, target);
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum);

        arr = new int[]{3, 3};
        target = 6;
        twoSum = lc167TwoSumII.twoSumV2(arr, target);
        Assert.assertArrayEquals(new int[]{1, 2}, twoSum);

        arr = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 7};
        target = 11;
        twoSum = lc167TwoSumII.twoSumV2(arr, target);
        Assert.assertArrayEquals(new int[]{9, 11}, twoSum);
    }

}
