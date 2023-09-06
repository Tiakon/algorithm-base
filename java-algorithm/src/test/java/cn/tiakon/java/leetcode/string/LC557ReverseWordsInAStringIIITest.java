package cn.tiakon.java.leetcode.string;

import cn.tiakon.java.leetcode.string.doublepointer.LC557ReverseWordsInAStringIII;
import org.junit.Assert;
import org.junit.Test;

public class LC557ReverseWordsInAStringIIITest {
    @Test
    public void reverseWordsTest() {
        final LC557ReverseWordsInAStringIII lc557ReverseWordsInAStringIII = new LC557ReverseWordsInAStringIII();

        String s = "Let's take LeetCode contest";
        String ans = lc557ReverseWordsInAStringIII.reverseWords(s);
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", ans);

        s = "God Ding";
        ans = lc557ReverseWordsInAStringIII.reverseWords(s);
        Assert.assertEquals("doG gniD", ans);
    }

}
