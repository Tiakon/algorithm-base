package cn.tiakon.java.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/range-sum-query-immutable/">303. 区域和检索 - 数组不可变</a>
 * @author tiankai.me@gmail.com on 2022/11/26 下午10:05.
 */
public class LC303RangeSumQueryImmutable {
    class NumArray {
        int[] preSum;
        int[] nums;
        int ans = 0;

        public NumArray(int[] nums) {
            this.nums = nums;
            preSum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                preSum[i] = (ans += nums[i]);
            }
        }

        public int sumRange(int left, int right) {
            return left == 0 ? preSum[right] : (preSum[right] - preSum[left] + nums[left]);
        }
    }

    /**
     * 时间复杂度：初始化 O(n)，每次检索 O(1)，其中 n 是数组 nums 的长度。
     * 初始化需要遍历数组 nums 计算前缀和，时间复杂度是 O(n)。
     * 每次检索只需要得到两个下标处的前缀和，然后计算差值，时间复杂度是 O(1)。
     * <p>
     * 空间复杂度：O(n)，其中 n 是数组 nums 的长度。需要创建一个长度为 n+1 的前缀和数组。
     *
     * @author tiankai.me@gmail.com on 2022/11/26 下午10:22.
     */
    class NumArrayV2 {
        int[] sums;

        public NumArrayV2(int[] nums) {
            int n = nums.length;
            sums = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }

    @Test
    public void numArrayTest() {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        Assert.assertEquals(1, numArray.sumRange(0, 2));
        Assert.assertEquals(-1, numArray.sumRange(2, 5));
        Assert.assertEquals(-3, numArray.sumRange(0, 5));
    }

    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        if (n % 2 == 0) return n / 2;
        else return n;
    }

    public int[][] onesMinusZeros(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];
        Map<Integer, Integer> rowSumMap = new HashMap<>(), colSumMap = new HashMap<>();
        int rowSum, colSum;
        for (int row = 0; row < ans.length; row++) {
            if (rowSumMap.containsKey(row)) rowSum = rowSumMap.get(row);
            else {
                rowSum = getRowSum(grid, row);
                rowSumMap.put(row, rowSum);
            }
            for (int col = 0; col < ans[row].length; col++) {
                if (colSumMap.containsKey(col)) colSum = colSumMap.get(col);
                else {
                    colSum = getColSum(grid, col);
                    colSumMap.put(col, colSum);
                }
                ans[row][col] = rowSum + colSum;
            }
        }
        return ans;
    }

    // 得到行的0与1个数差
    public int getRowSum(int[][] grid, int row) {
        int count = 0;
        for (int i = 0; i < grid[row].length; i++) {
            if (grid[row][i] == 1) count++;
        }
        return count - (grid[row].length - count);
    }

    // 得到列的0与1个数差
    public int getColSum(int[][] grid, int col) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 1) count++;
        }
        return count - (grid.length - count);
    }

    @Test
    public void onesMinusZerosTest() {
        LC303RangeSumQueryImmutable queryImmutable = new LC303RangeSumQueryImmutable();
        int[][] grid = {{0, 1, 1}, {1, 0, 1}, {0, 0, 1}};
        Assert.assertEquals(1, queryImmutable.getRowSum(grid, 0));
        Assert.assertEquals(1, queryImmutable.getRowSum(grid, 1));
        Assert.assertEquals(-1, queryImmutable.getRowSum(grid, 2));
        Assert.assertEquals(-1, queryImmutable.getColSum(grid, 0));
        Assert.assertEquals(-1, queryImmutable.getColSum(grid, 1));
        Assert.assertEquals(3, queryImmutable.getColSum(grid, 2));

        int[][] ans = queryImmutable.onesMinusZeros(grid);
        Assert.assertArrayEquals(new int[][]{{0, 0, 4}, {0, 0, 4}, {-2, -2, 2}}, ans);
    }

    public int pivotInteger(int n) {
        int sum = (1 + n) * n / 2;
        int preSum = 0;
        for (int i = 1; i < n + 1; i++) {
            preSum += i;
            if (sum - (i + 1) - preSum == preSum) return i + 1;
        }
        return n == 1 ? 1 : -1;
    }

    public int appendCharacters(String s, String t) {
        int ans = 0, left = 0, right = 0;
        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                ++left;
                ++right;
            } else ++left;
        }
        if (left <= s.length() && right == t.length()) ans = 0;
        else if (right < t.length()) ans = t.length() - right;
        return ans;
    }

}
