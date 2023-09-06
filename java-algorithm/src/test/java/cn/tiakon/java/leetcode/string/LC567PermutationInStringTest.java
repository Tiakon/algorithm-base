package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LC567PermutationInStringTest {

    @Test
    public void checkInclusionTest() {
        final LC567PermutationInString lc567PermutationInString = new LC567PermutationInString();

        String s1 = "a";
        String s2 = "ab";
        Assert.assertTrue(lc567PermutationInString.checkInclusion(s1, s2));

        s1 = "ab";
        s2 = "eidbaooo";
        Assert.assertTrue(lc567PermutationInString.checkInclusion(s1, s2));

        s1 = "ab";
        s2 = "eidboaooo";
        Assert.assertFalse(lc567PermutationInString.checkInclusion(s1, s2));

        s1 = "abc";
        s2 = "ccccbbbbaaaa";
        Assert.assertFalse(lc567PermutationInString.checkInclusion(s1, s2));

        s1 = "hello";
        s2 = "ooolleoooleh";
        Assert.assertFalse(lc567PermutationInString.checkInclusion(s1, s2));

        s1 = "adc";
        s2 = "dcda";
        Assert.assertTrue(lc567PermutationInString.checkInclusion(s1, s2));
    }

    @Test
    public void checkInclusionV2Test() {
        final LC567PermutationInString lc567PermutationInString = new LC567PermutationInString();

        String s1 = "a";
        String s2 = "ab";
        Assert.assertTrue(lc567PermutationInString.checkInclusionV2(s1, s2));

        s1 = "ab";
        s2 = "eidbaooo";
        Assert.assertTrue(lc567PermutationInString.checkInclusionV2(s1, s2));

        s1 = "ab";
        s2 = "eidboaooo";
        Assert.assertFalse(lc567PermutationInString.checkInclusionV2(s1, s2));

        s1 = "abc";
        s2 = "ccccbbbbaaaa";
        Assert.assertFalse(lc567PermutationInString.checkInclusionV2(s1, s2));

        s1 = "hello";
        s2 = "ooolleoooleh";
        Assert.assertFalse(lc567PermutationInString.checkInclusionV2(s1, s2));

        s1 = "adc";
        s2 = "dcda";
        Assert.assertTrue(lc567PermutationInString.checkInclusionV2(s1, s2));
    }

    @Test
    public void checkInclusionV3Test() {
        final LC567PermutationInString lc567PermutationInString = new LC567PermutationInString();

        String s1 = "adc";
        String s2 = "dcda";
        Assert.assertTrue(lc567PermutationInString.checkInclusionV3(s1, s2));

        s1 = "ab";
        s2 = "eidbaooo";
        Assert.assertTrue(lc567PermutationInString.checkInclusionV3(s1, s2));

        s1 = "ab";
        s2 = "eidboaooo";
        Assert.assertFalse(lc567PermutationInString.checkInclusionV3(s1, s2));

        s1 = "hello";
        s2 = "ooolleoooleh";
        Assert.assertFalse(lc567PermutationInString.checkInclusionV3(s1, s2));

    }


    @Test
    public void StringOpsTest() {
        IntStream codePoints = "abc".codePoints();
        IntStream codePoints2 = "cab".codePoints();
        int sum = Arrays.stream(codePoints.toArray()).sum();
        int sum2 = Arrays.stream(codePoints2.toArray()).sum();
        Assert.assertEquals(sum, sum2);

        codePoints = "abc".codePoints();
        codePoints2 = "cab".codePoints();
        final IntStream sorted = Arrays.stream(codePoints.toArray()).sorted();
        final IntStream sorted2 = Arrays.stream(codePoints2.toArray()).sorted();
        Assert.assertEquals(Arrays.toString(sorted.toArray()), Arrays.toString(sorted2.toArray()));

        // MathRandomUtil.printArray(codePoints.toArray());
    }

    @Test
    public void ForTest() {
        for (int i = 0; i < 1; i++) {
            // 1声明2判断3逻辑4加加
            System.out.println(i);
        }
    }
}
