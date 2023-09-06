package cn.tiakon.java.leetcode.string;

import cn.tiakon.java.leetcode.string.doublepointer.LC344ReverseString;
import org.junit.Assert;
import org.junit.Test;

public class LC344ReverseStringTest {

    @Test
    public void reverseStringTest() {
        final LC344ReverseString lc344ReverseString = new LC344ReverseString();
        String s1 = "helloworld";
        char[] c1 = s1.toCharArray();
        lc344ReverseString.reverseString(c1);
        Assert.assertArrayEquals(new StringBuffer(s1).reverse().toString().toCharArray(), c1);

        s1 = "Hanna";
        c1 = s1.toCharArray();
        lc344ReverseString.reverseString(c1);
        Assert.assertArrayEquals(new StringBuffer(s1).reverse().toString().toCharArray(), c1);
    }

}
