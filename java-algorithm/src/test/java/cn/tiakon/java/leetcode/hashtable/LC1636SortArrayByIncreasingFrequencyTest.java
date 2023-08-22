package cn.tiakon.java.leetcode.hashtable;

import org.junit.Assert;
import org.junit.Test;

public class LC1636SortArrayByIncreasingFrequencyTest {

    @Test
    public void frequencySortTest() {
        final LC1636SortArrayByIncreasingFrequency lc1636SortArrayByIncreasingFrequency = new LC1636SortArrayByIncreasingFrequency();

        int[] randomArray = new int[]{5, 0, -5, 1, 5, 4, 5, 4, 2, -3, 4, 4};
        int[] frequencySort = lc1636SortArrayByIncreasingFrequency.frequencySort(randomArray);
        // MathRandomUtil.printArray(frequencySort);
        Assert.assertArrayEquals(new int[]{2, 1, 0, -3, -5, 5, 5, 5, 4, 4, 4, 4}, frequencySort);

        randomArray = new int[]{1, 1, 2, 2, 2, 3};
        frequencySort = lc1636SortArrayByIncreasingFrequency.frequencySort(randomArray);
        // MathRandomUtil.printArray(frequencySort);
        Assert.assertArrayEquals(new int[]{3, 1, 1, 2, 2, 2}, frequencySort);

        randomArray = new int[]{2, 3, 1, 3, 2};
        frequencySort = lc1636SortArrayByIncreasingFrequency.frequencySort(randomArray);
        // MathRandomUtil.printArray(frequencySort);
        Assert.assertArrayEquals(new int[]{1, 3, 3, 2, 2}, frequencySort);

        randomArray = new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1};
        frequencySort = lc1636SortArrayByIncreasingFrequency.frequencySort(randomArray);
        // MathRandomUtil.printArray(frequencySort);
        Assert.assertArrayEquals(new int[]{5, -1, 4, 4, -6, -6, 1, 1, 1}, frequencySort);
    }

}
