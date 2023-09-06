package cn.tiakon.java.leetcode.string;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class LC1422MaxScoreAfterSplitStringTest {

    @Test
    public void maxScoreTemplateTest() {
        final LC1422MaxScoreAfterSplitString lc1422MaxScoreAfterSplitString = new LC1422MaxScoreAfterSplitString();
        lc1422MaxScoreAfterSplitString.maxScoreTemplate("011101");
    }

    @Test
    public void maxScoreTest() {
        final LC1422MaxScoreAfterSplitString lc1422MaxScoreAfterSplitString = new LC1422MaxScoreAfterSplitString();
        String s = "011101";
        int ans = lc1422MaxScoreAfterSplitString.maxScore(s);
        Assert.assertEquals(5, ans);
        s = "00111";
        ans = lc1422MaxScoreAfterSplitString.maxScore(s);
        Assert.assertEquals(5, ans);
        s = "1111";
        ans = lc1422MaxScoreAfterSplitString.maxScore(s);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void maxScoreV2Test() {
        final LC1422MaxScoreAfterSplitString lc1422MaxScoreAfterSplitString = new LC1422MaxScoreAfterSplitString();
        String s = "011101";
        int ans = lc1422MaxScoreAfterSplitString.maxScoreV2(s);
        Assert.assertEquals(5, ans);
        s = "00111";
        ans = lc1422MaxScoreAfterSplitString.maxScoreV2(s);
        Assert.assertEquals(5, ans);
        s = "1111";
        ans = lc1422MaxScoreAfterSplitString.maxScoreV2(s);
        Assert.assertEquals(3, ans);
    }

    @Test
    public void maxScoreBenchmarkTest() {
        final LC1422MaxScoreAfterSplitString lc1422MaxScoreAfterSplitString = new LC1422MaxScoreAfterSplitString();
        final Random random = new Random();
        for (int j = 0; j < 1000; j++) {
            // length -> [2,500]
            // final int length = random.nextInt(499) + 2;
            // length -> [2,10]
            final int length = random.nextInt(9) + 2;
            final int[] array = MathRandomUtil.createRandomArrayWithZeroAndOne(length);
            // MathRandomUtil.printArray(array);
            final StringBuffer buffer = new StringBuffer();
            Arrays.stream(array).forEach(i -> buffer.append((char) (i + '0')));
            final String s = buffer.toString();
            int ans = lc1422MaxScoreAfterSplitString.maxScore(s);
            int ans2 = lc1422MaxScoreAfterSplitString.maxScoreV2(s);
            Assert.assertEquals(ans2, ans);
        }
    }
}
