package cn.tiakon.java.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1460. 通过翻转子数组使两个数组相等
 * https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 *
 * @author tiankai.me@gmail.com on 2022/8/24 17:15.
 */
public class LC1460ReversingSubArrays {

    // 对两个数组做词频统计，相同即满足条件
    // 1. 哈希表
    // 2. 排序后，比较数组

    /**
     * 反面教材
     * 执行用时： 13 ms , 在所有 Java 提交中击败了 8.25% 的用户
     * 内存消耗： 41.9 MB , 在所有 Java 提交中击败了 5.43% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/24 17:53.
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            hashMap.put(target[i], hashMap.getOrDefault(target[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (!hashMap.containsKey(arr[i])) hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
            else hashMap.put(arr[i], hashMap.get(arr[i]) - 1);
        }
        final Integer[] array = hashMap.values().stream().distinct().toArray(Integer[]::new);
        return array.length == 1 && array[0] == 0;
    }

    /**
     * 反面教材
     * 执行用时： 8 ms , 在所有 Java 提交中击败了 11.09% 的用户
     * 内存消耗： 41.6 MB , 在所有 Java 提交中击败了 12.98% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/24 18:24.
     */
    public boolean canBeEqualV2(int[] target, int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            wordCountA(hashMap, target[i]);
            wordCountB(hashMap, arr[i]);
        }
        final Integer[] array = hashMap.values().stream().distinct().toArray(Integer[]::new);
        return array.length == 1 && array[0] == 0;
    }

    public void wordCountA(Map<Integer, Integer> hashMap, int num) {
        if (!hashMap.containsKey(num)) hashMap.put(num, 1);
        else if (hashMap.get(num) == 0) hashMap.put(num, 1);
        else hashMap.put(num, hashMap.get(num) + 1);
    }

    public void wordCountB(Map<Integer, Integer> hashMap, int num) {
        if (!hashMap.containsKey(num)) hashMap.put(num, -1);
        else if (hashMap.get(num) == 0) hashMap.put(num, -1);
        else hashMap.put(num, hashMap.get(num) - 1);
    }

    /**
     * 最优解
     * 我们维护一个hash表,对数字进行计数即可。遇到小于0的返回false。
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.76% 的用户
     * 内存消耗： 41.2 MB , 在所有 Java 提交中击败了 60.85% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/24 18:34.
     */
    public boolean canBeEqualV3(int[] target, int[] arr) {
        final int[] ints = new int[1000];
        for (int i : target) {
            ints[i - 1]++;
        }
        for (int i : arr) {
            if (--ints[i - 1] < 0) return false;
        }
        return true;
    }

}
