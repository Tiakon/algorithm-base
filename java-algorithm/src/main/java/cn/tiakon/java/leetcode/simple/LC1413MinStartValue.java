package cn.tiakon.java.leetcode.simple;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * 逐步求和得到正数的最小值
 * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 * 示例 1：
 * <p>
 * 输入：nums = [-3,2,-3,4,2]
 * 输出：5
 * 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
 * 累加求和
 * startValue = 4 | startValue = 5 | nums
 * (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 * (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 * (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 * (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 * (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 * 示例 2：
 * 输入：nums = [1,2]
 * 输出：1
 * 解释：最小的 startValue 需要是正数。
 * 示例 3：
 * 输入：nums = [1,-2,-3]
 * 输出：5
 * 提示：
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author tiankai.me@gmail.com on 2022/8/9 23:26.
 */
public class LC1413MinStartValue {

    // 逐步求和得到正数的最小值
    public int minStartValue(int[] nums) {
        int minStartValue = 1;
        while (true) {
            int sum = minStartValue;
            boolean sumLessOne = false;
            for (int num : nums) {
                sum += num;
                if (sum < 1) {
                    sumLessOne = true;
                    break;
                }
            }
            if (sumLessOne) {
                minStartValue++;
            } else {
                break;
            }
        }
        return minStartValue;
    }

    /**
     * 要保证所有的累加和 accSum 满足 accSum + startValue≥1，
     * 只需保证累加和的最小值 accSumMin 满足 accSumMin+startValue≥1，
     * 那么 startValue 的最小值即可取 −accSumMin+1。
     * <p>
     * 时间复杂度：O(n) ，其中 n 是数组 nums 的长度。只需要遍历数组一次。
     * 空间复杂度：O(1) 。只需要使用常量空间。
     *
     * @author tiankai.me@gmail.com on 2022/8/9 23:57.
     */
    public int minStartValueV2(int[] nums) {
        int accSum = 0, accSumMin = 0;
        for (int num : nums) {
            accSum += num;
            accSumMin = Math.min(accSumMin, accSum);
        }
        return -accSumMin + 1;
    }

    @Test
    public void minStartValueTest() {
        final LC1413MinStartValue lc1413MinStartValue = new LC1413MinStartValue();
        int[] nums = new int[]{-3, 2, -3, 4, 2};
        int minStartValue = lc1413MinStartValue.minStartValue(nums);
        Assert.assertEquals(5, minStartValue);
        nums = new int[]{1, 2};
        minStartValue = lc1413MinStartValue.minStartValue(nums);
        Assert.assertEquals(1, minStartValue);
        nums = new int[]{1, -2, -3};
        minStartValue = lc1413MinStartValue.minStartValue(nums);
        Assert.assertEquals(5, minStartValue);
    }

    @Test
    public void minStartValueBenchmarkTest() {
        final LC1413MinStartValue lc1413MinStartValue = new LC1413MinStartValue();
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            // length -> [1,100]
            int length = random.nextInt(100) + 1;
            // maxValue -> [-100,100]
            int maxValue = random.nextInt(101);
            final int[] nums = MathRandomUtil.createRandomArray(length, maxValue);
            final int minStartValue = lc1413MinStartValue.minStartValue(nums);
            final int minStartValueV2 = lc1413MinStartValue.minStartValueV2(nums);
            Assert.assertEquals(minStartValue, minStartValueV2);
        }
    }

}
