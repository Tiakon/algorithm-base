package cn.tiakon.java.leetcode.array.sort;

/**
 * 1470. 重新排列数组
 * https://leetcode.cn/problems/shuffle-the-array/
 *
 * @author tiankai.me@gmail.com on 2022/8/29 11:20.
 */
public class LC1470ShuffleTheArray {
    /**
     * 一次遍历
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.6 MB , 在所有 Java 提交中击败了 43.04% 的用户
     * <p>
     * 复杂度分析
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @author tiankai.me@gmail.com on 2022/8/29 12:02.
     */
    public int[] shuffle(int[] nums, int n) {
        if (nums == null || nums.length != 2 * n) throw new RuntimeException("The array length is error.");
        int[] ans = new int[nums.length];
        int i = 0, j = 0;
        while (i < nums.length) {
            ans[i] = nums[j];
            ans[i + 1] = nums[n + j++];
            i += 2;
        }
        return ans;
    }

    /**
     *
     * 双指针原地修改(未实现)
     * 复杂度分析
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @author tiankai.me@gmail.com on 2022/8/29 12:04.
     */
    public int[] shuffleV2(int[] nums, int n) {
        if (nums == null || nums.length != 2 * n) throw new RuntimeException("The array length is error.");
        int cur = 1, left = 1, right = n;
        while (left < right) {
            if (cur % 2 != 0) {
                int tmp = nums[cur];
                nums[cur] = nums[right];
                nums[right] = tmp;
                left = right;
                right++;
            } else {
                int tmp = nums[cur];
                nums[cur] = nums[left];
                nums[left] = tmp;
            }
            cur++;
        }
        return nums;
    }
}
