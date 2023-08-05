package cn.tiakon.java.leetcode.array.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 217. 存在重复元素
 * https://leetcode.cn/problems/contains-duplicate/
 *
 * @author tiankai.me@gmail.com on 2022/11/24 下午9:06.
 */
public class LC217ContainsDuplicate {
    // 双指针+排序
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return true;
        }
        return false;
    }

    // 哈希表
    public boolean containsDuplicateV2(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.getOrDefault(nums[i], 0) >= 1) return true;
            else hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        return false;
    }

    /**
     * 哈希Set
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 91.85% 的用户
     * 内存消耗： 49.4 MB , 在所有 Java 提交中击败了 91.04% 的用户
     * 通过测试用例： 70 / 70
     *
     * @author tiankai.me@gmail.com on 2022/11/24 下午9:33.
     */
    public boolean containsDuplicateV3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) return true;
        }
        return false;
    }

    // 去重后与原长度不等
    public boolean containsDuplicateV4(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }


    // 插入排序
    public void sort(int[] nums) {
        if (nums.length == 1) return;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    @Test
    public void sortTest() {
        LC217ContainsDuplicate containsDuplicate = new LC217ContainsDuplicate();
        int[] nums = new int[]{4, 3, 2, 5, 1};
        containsDuplicate.sort(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums);
    }

}
