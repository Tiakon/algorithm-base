package cn.tiakon.java.leetcode.array.binarysearch;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LC704BinarySearchTest {

    final static LC704BinarySearch lc704BinarySearch = new LC704BinarySearch();

    @Test
    public void binarySearchV1Test() {
        int target = 1;
        int[] arrayWithSorted = {-5, -4, -1, 1};
        int index = lc704BinarySearch.binarySearch(arrayWithSorted, target);
        int targetIndex = lc704BinarySearch.binarySearchV1(arrayWithSorted, target);
        Assert.assertEquals(index, targetIndex);

        target = 0;
        int[] arrayWithSorted2 = {-1, 0, 5};
        index = lc704BinarySearch.binarySearch(arrayWithSorted2, target);
        targetIndex = lc704BinarySearch.binarySearchV1(arrayWithSorted2, target);
        Assert.assertEquals(index, targetIndex);
    }

    @Test
    public void binarySearchV1BenchmarkTest() {
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            // [1, 100]
            int target = random.nextInt(100) + 1;
            // [1,20]
            int length = random.nextInt(20) + 1;
            int maxValue = 100;
            // arr[i] -> [-100,100]
            final int[] arrayWithSorted = MathRandomUtil.getNonRepeatArrayForSorted(length, maxValue);
            final int index = lc704BinarySearch.binarySearch(arrayWithSorted, target);
            final int targetIndex = lc704BinarySearch.binarySearchV1(arrayWithSorted, target);
            if (index != targetIndex) {
                System.out.printf("target:%d %n", target);
                MathRandomUtil.printArray(arrayWithSorted);
            }
            Assert.assertEquals(targetIndex, index);
        }
    }

    @Test
    public void binarySearchV2BenchmarkTest() {
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            // [1, 100]
            int target = random.nextInt(100) + 1;
            // [1,20]
            int length = random.nextInt(20) + 1;
            int maxValue = 100;
            // arr[i] -> [-100,100]
            final int[] arrayWithSorted = MathRandomUtil.getNonRepeatArrayForSorted(length, maxValue);
            final int index = lc704BinarySearch.binarySearch(arrayWithSorted, target);
            final int targetIndex = lc704BinarySearch.binarySearchV2(arrayWithSorted, target);
            if (index != targetIndex) {
                System.out.printf("target:%d %n", target);
                MathRandomUtil.printArray(arrayWithSorted);
            }
            Assert.assertEquals(targetIndex, index);
        }
    }

    @Test
    public void searchLeftBoundTest() {
        int target = 2;
        int[] arrayWithSorted = {1, 2, 2, 4};
        int index = 1;
        int targetIndex = lc704BinarySearch.searchLeftBound(arrayWithSorted, target);
        Assert.assertEquals(index, targetIndex);

        target = 4;
        int[] arrayWithSorted2 = {1, 2, 2, 3, 3, 4, 4, 5};
        index = 5;
        targetIndex = lc704BinarySearch.searchLeftBound(arrayWithSorted2, target);
        Assert.assertEquals(index, targetIndex);
    }

    @Test
    public void searchRightBoundTest() {
        int target = 2;
        int[] arrayWithSorted = {1, 2, 2, 4};
        int index = 2;
        int targetIndex = lc704BinarySearch.searchRightBound(arrayWithSorted, target);
        Assert.assertEquals(index, targetIndex);

        target = 4;
        int[] arrayWithSorted2 = {1, 2, 2, 3, 3, 4, 4, 5};
        index = 6;
        targetIndex = lc704BinarySearch.searchRightBound(arrayWithSorted2, target);
        Assert.assertEquals(index, targetIndex);
    }
}
