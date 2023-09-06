package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class LC1374GenerateStringWithCharTest {

    @Test
    public void checkGenerateTheStringTest() {
        final LC1374GenerateStringWithChar lc1374GenerateStringWithChar = new LC1374GenerateStringWithChar();
        String randomString = "aaabcd";
        Assert.assertTrue(lc1374GenerateStringWithChar.checkGenerateTheString(randomString));
        randomString = "aabcd";
        Assert.assertFalse(lc1374GenerateStringWithChar.checkGenerateTheString(randomString));
        randomString = "abcd";
        Assert.assertTrue(lc1374GenerateStringWithChar.checkGenerateTheString(randomString));
    }

    @Test
    public void generateTheStringTest() {
        final LC1374GenerateStringWithChar lc1374GenerateStringWithChar = new LC1374GenerateStringWithChar();

        String randomString = lc1374GenerateStringWithChar.generateTheString(10);
        boolean ans = lc1374GenerateStringWithChar.checkGenerateTheString(randomString);
        if (!ans) System.out.println("randomString: " + randomString);
        Assert.assertTrue(ans);
        randomString = lc1374GenerateStringWithChar.generateTheString(4);
        ans = lc1374GenerateStringWithChar.checkGenerateTheString(randomString);
        if (!ans) System.out.println("randomString: " + randomString);
        Assert.assertTrue(ans);
        randomString = lc1374GenerateStringWithChar.generateTheString(6);
        ans = lc1374GenerateStringWithChar.checkGenerateTheString(randomString);
        if (!ans) System.out.println("randomString: " + randomString);
        Assert.assertTrue(ans);
        randomString = lc1374GenerateStringWithChar.generateTheString(3);
        ans = lc1374GenerateStringWithChar.checkGenerateTheString(randomString);
        if (!ans) System.out.println("randomString: " + randomString);
        Assert.assertTrue(ans);

    }

    @Test
    public void generateTheStringBenchmarkTest() {
        final LC1374GenerateStringWithChar lc1374GenerateStringWithChar = new LC1374GenerateStringWithChar();
        final Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            final int n = random.nextInt(500) + 1;
            String randomString = lc1374GenerateStringWithChar.generateTheString(n);
            final boolean ans = lc1374GenerateStringWithChar.checkGenerateTheString(randomString);
            if (!ans) System.out.println("randomString: " + randomString);
            Assert.assertTrue(ans);
        }
    }

    @Test
    public void IntToCharTest() {
        // ascii 码 a~z 十进制范围 97~122
        // ascii 码 A~Z 十进制范围 65~90
        char aChar = (char) 97;
        char zChar = (char) 122;
        char AChar = (char) 65;
        char ZChar = (char) 90;
        Assert.assertEquals('a', aChar);
        Assert.assertEquals('z', zChar);
        Assert.assertEquals('A', AChar);
        Assert.assertEquals('Z', ZChar);

        boolean[] booleans = new boolean[26];
        for (boolean aBoolean : booleans) {
            Assert.assertFalse(aBoolean);
        }
    }

}
