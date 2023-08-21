package cn.tiakon.java.leetcode.array.doublepointer;

import org.junit.Assert;
import org.junit.Test;

public class LC1464MaximumProductOfTwoElementsInArrayTest {
    @Test
    public void maxProductTest() {
        final LC1464MaximumProductOfTwoElementsInArray lc1464MaximumProductOfTwoElementsInArray = new LC1464MaximumProductOfTwoElementsInArray();

        int[] arr = new int[]{3, 4, 5, 2};
        int maxProduct = lc1464MaximumProductOfTwoElementsInArray.maxProduct(arr);
        Assert.assertEquals(12, maxProduct);

        arr = new int[]{3, 7};
        maxProduct = lc1464MaximumProductOfTwoElementsInArray.maxProduct(arr);
        Assert.assertEquals(12, maxProduct);

        arr = new int[]{1, 5, 4, 5};
        maxProduct = lc1464MaximumProductOfTwoElementsInArray.maxProduct(arr);
        Assert.assertEquals(16, maxProduct);
    }

}
