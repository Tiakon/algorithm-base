package cn.tiakon.java.leetcode.array;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * 769. 最多能完成排序的块
 * https://leetcode.cn/problems/max-chunks-to-make-sorted/
 *
 * @author tiankai.me@gmail.com on 2022/8/13 23:25.
 */
public class LC769MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int ans = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void maxChunksToSortedTest() {
        final LC769MaxChunksToMakeSorted lc769MaxChunksToMakeSorted = new LC769MaxChunksToMakeSorted();
        int[] nums = new int[]{4, 3, 2, 1, 0};
        int maxChunks = lc769MaxChunksToMakeSorted.maxChunksToSorted(nums);
        Assert.assertEquals(1, maxChunks);

        nums = new int[]{1, 0, 2, 3, 4};
        maxChunks = lc769MaxChunksToMakeSorted.maxChunksToSorted(nums);
        Assert.assertEquals(4, maxChunks);
    }

    @Test
    public void maxChunksToSortedBenchmarkTest() {
        final LC769MaxChunksToMakeSorted lc769MaxChunksToMakeSorted = new LC769MaxChunksToMakeSorted();
        final Random random = new Random();
        for (int i = 0; i < 20; i++) {
            // length -> [1,10]
            int length = random.nextInt(10) + 1;
            //  0 <= arr[i] < length
            final int[] nums = MathRandomUtil.createRandomArray(length, length, true);
            MathRandomUtil.printArray(nums);
            int maxChunks = lc769MaxChunksToMakeSorted.maxChunksToSorted(nums);
            System.out.println("maxChunks：" + maxChunks);
            // Assert.assertEquals(1, maxChunks);
        }

    }
}