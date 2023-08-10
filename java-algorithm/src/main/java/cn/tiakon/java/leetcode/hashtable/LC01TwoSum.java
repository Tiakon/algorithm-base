package cn.tiakon.java.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode.cn/problems/two-sum/
 *
 * @author Created by Tiakon on 2019/1/8 9:44.
 */
public class LC01TwoSum {

    /**
     * 暴力枚举
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     *
     * @author tiankai.me@gmail.com on 2022/8/14 17:03.
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 使用哈希表，
     * 当需要确定某元素是否出现或存在时，可以使用哈希表。
     * 1. 在遍历数组的同时，通过 target - nums[i] 进行查找差值
     * 2. 不会出现重复索引和元素的问题
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @author tiankai.me@gmail.com on 2022/8/14 15:54.
     */
    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


}
