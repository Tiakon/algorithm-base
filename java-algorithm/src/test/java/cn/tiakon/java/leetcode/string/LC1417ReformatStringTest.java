package cn.tiakon.java.leetcode.string;

import cn.tiakon.java.leetcode.string.doublepointer.LC1417ReformatString;
import org.junit.Assert;
import org.junit.Test;

public class LC1417ReformatStringTest {
    @Test
    public void reformatTest() {
        final LC1417ReformatString lc1417ReformatString = new LC1417ReformatString();
        String s = "a0b1c2";
        String reformat = lc1417ReformatString.reformat(s);
        Assert.assertEquals("a0b1c2", reformat);

        s = "leetcode";
        reformat = lc1417ReformatString.reformat(s);
        Assert.assertEquals("", reformat);

        s = "12365479";
        reformat = lc1417ReformatString.reformat(s);
        Assert.assertEquals("", reformat);

        s = "123ab";
        reformat = lc1417ReformatString.reformat(s);
        Assert.assertEquals("1a3b2", reformat);

        s = "ab123";
        reformat = lc1417ReformatString.reformat(s);
        Assert.assertEquals("1b2a3", reformat);

        s = "123abcd";
        reformat = lc1417ReformatString.reformat(s);
        Assert.assertEquals("a2b1c3d", reformat);

        s = "abcd123";
        reformat = lc1417ReformatString.reformat(s);
        Assert.assertEquals("a1c2b3d", reformat);
    }

}
