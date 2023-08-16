package cn.tiakon.java.leetcode.array;

/**
 * 26. 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 *
 * @author tiankai.me@gmail.com on 2022/10/28 下午2:33.
 */
public class LC26RemoveDuplicatesFromSortedArray {


    /**
     * 双指针
     * <p>
     * 1. 一个指针 i 进行数组遍历，另外一个指针 j 指向有效数组的最后一个位置。
     * 2. 只有当 i 所指向的值和 j 不一致（不重复），才将 i 的值添加到 j 的下一位置。
     * 复杂度分析
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2022/10/28 下午7:19.
     */
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) nums[++j] = nums[i];
        }
        return j + 1;
    }

    public int removeDuplicatesV2(int[] nums) {
        if (nums.length == 1) return 1;
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) j++;
            else nums[++i] = nums[j++];
        }
        return i + 1;
    }

}
