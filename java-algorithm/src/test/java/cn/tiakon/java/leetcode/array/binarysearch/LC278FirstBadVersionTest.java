package cn.tiakon.java.leetcode.array.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LC278FirstBadVersionTest {
    @Test
    public void firstBadVersionTest() {
        int bad = 4;
        // n -> [1,9]
        int n = 9;
        final LC278FirstBadVersion firstBadVersionBean = new LC278FirstBadVersion(bad);
        final int firstBadVersion = firstBadVersionBean.firstBadVersion(n);
        Assert.assertEquals(bad, firstBadVersion);
    }

    @Test
    public void firstBadVersionBenchmarkTest() {
        final Random random = new Random();
        // 1 <= bad <= n <= 2^31 - 1
        for (int i = 0; i < 1000; i++) {
            // n -> [1,50]
            int n = random.nextInt(50) + 1;
            // n -> [1,n]
            int bad = random.nextInt(n) + 1;
            final LC278FirstBadVersion firstBadVersionBean = new LC278FirstBadVersion(bad);
            final int firstBadVersion = firstBadVersionBean.firstBadVersion(n);
            Assert.assertEquals(bad, firstBadVersion);
        }
    }

    @Test
    public void firstBadVersionV2Test() {
        int bad = 4;
        // n -> [1,9]
        int n = 9;
        final LC278FirstBadVersion firstBadVersionBean = new LC278FirstBadVersion(bad);
        final int firstBadVersion = firstBadVersionBean.firstBadVersionV2(n);
        Assert.assertEquals(bad, firstBadVersion);
    }

    @Test
    public void firstBadVersionV2BenchmarkTest() {
        final Random random = new Random();
        // 1 <= bad <= n <= 2^31 - 1
        for (int i = 0; i < 1000; i++) {
            // n -> [1,50]
            int n = random.nextInt(50) + 1;
            // n -> [1,n]
            int bad = random.nextInt(n) + 1;
            final LC278FirstBadVersion firstBadVersionBean = new LC278FirstBadVersion(bad);
            final int firstBadVersion = firstBadVersionBean.firstBadVersionV2(n);
            Assert.assertEquals(bad, firstBadVersion);
        }
    }

    @Test
    public void firstBadVersionV3Test() {
        int bad = 4;
        // n -> [1,9]
        int n = 9;
        final LC278FirstBadVersion firstBadVersionBean = new LC278FirstBadVersion(bad);
        final int firstBadVersion = firstBadVersionBean.firstBadVersionV3(n);
        Assert.assertEquals(bad, firstBadVersion);
    }

    @Test
    public void firstBadVersionV3BenchmarkTest() {
        final Random random = new Random();
        // 1 <= bad <= n <= 2^31 - 1
        for (int i = 0; i < 1000; i++) {
            // n -> [1,50]
            int n = random.nextInt(50) + 1;
            // n -> [1,n]
            int bad = random.nextInt(n) + 1;
            final LC278FirstBadVersion firstBadVersionBean = new LC278FirstBadVersion(bad);
            final int firstBadVersion = firstBadVersionBean.firstBadVersionV3(n);
            Assert.assertEquals(bad, firstBadVersion);
        }
    }

}
