package cn.tiakon.java.leetcode.array.sort;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LC912SortArrayTest {

    @Test
    public void sortArrayWithBubbleSortTest() {
        final LC912SortArray lc912SortArray = new LC912SortArray();

        int[] nums = new int[]{5, 2, 3, 1};
        int[] ans1 = lc912SortArray.sortArrayWithBubbleSort(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5}, ans1);

        nums = new int[]{5, 1, 1, 2, 0, 0};
        ans1 = lc912SortArray.sortArrayWithBubbleSort(nums);
        Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 5}, ans1);
    }

    @Test
    public void sortArrayWithSelectSortTest() {
        final LC912SortArray lc912SortArray = new LC912SortArray();

        int[] nums = new int[]{5, 2, 3, 1};
        int[] ans1 = lc912SortArray.sortArrayWithSelectSort(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5}, ans1);

        nums = new int[]{5, 1, 1, 2, 0, 0};
        ans1 = lc912SortArray.sortArrayWithSelectSort(nums);
        Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 5}, ans1);
    }

    @Test
    public void sortArrayWithInsertSortTest() {
        final LC912SortArray lc912SortArray = new LC912SortArray();

        int[] nums = new int[]{5, 2, 3, 1};
        int[] ans1 = lc912SortArray.sortArrayWithInsertSort(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5}, ans1);

        nums = new int[]{5, 1, 1, 2, 0, 0};
        ans1 = lc912SortArray.sortArrayWithInsertSort(nums);
        Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 5}, ans1);
    }

    @Test
    public void sortArrayWithMergeSortTest() {
        final LC912SortArray lc912SortArray = new LC912SortArray();

        int[] nums = new int[]{5, 2, 3, 1};
        int[] ans1 = lc912SortArray.sortArrayWithMergeSort(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5}, ans1);

        nums = new int[]{5, 1, 1, 2, 0, 0};
        ans1 = lc912SortArray.sortArrayWithMergeSort(nums);
        Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 5}, ans1);
    }

    @Test
    public void sortArrayWithQuickSortTest() {
        final LC912SortArray lc912SortArray = new LC912SortArray();

        int[] nums = new int[]{5, 2, 3, 1};
        int[] ans1 = lc912SortArray.sortArrayWithQuickSort(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5}, ans1);

        nums = new int[]{5, 1, 1, 2, 0, 0};
        ans1 = lc912SortArray.sortArrayWithQuickSort(nums);
        Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 5}, ans1);
    }

    @Test
    public void sortArrayWithQuickSortV2Test() {
        int[] nums = new int[]{5, 2, 3, 1};
        Quick.sort(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 5}, nums);

        nums = new int[]{5, 1, 1, 2, 0, 0};
        Quick.sort(nums);
        Assert.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 5}, nums);
    }

    @Test
    public void sortArrayBenchmarkTest() {
        final LC912SortArray lc912SortArray = new LC912SortArray();
        final Random random = new Random();
        for (int i = 0; i < 100; i++) {
            // num[i] -> [-10000,10000]
            int maxValue = random.nextInt(10001);
            // length -> [1,10000];
            int length = random.nextInt(10000) + 1;
            int[] nums = MathRandomUtil.createRandomArray(length, maxValue);
            int[] ans1 = lc912SortArray.sortArrayWithBubbleSort(nums);
            int[] ans2 = lc912SortArray.sortArrayWithSelectSort(nums);
            int[] ans3 = lc912SortArray.sortArrayWithInsertSort(nums);
            Assert.assertArrayEquals(ans1, ans2);
            Assert.assertArrayEquals(ans1, ans3);
        }

    }

}
