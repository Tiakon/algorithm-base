package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1662. 检查两个字符串数组是否相等
 * https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/
 *
 * @author tiankai.me@gmail.com on 2022/11/1 上午10:27.
 */
public class LC1662CheckStringArraysEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length) builder1.append(word1[i++]);
        while (j < word2.length) builder2.append(word2[j++]);
        return builder1.toString().equals(builder2.toString());
    }

    public boolean arrayStringsAreEqualV2(String[] word1, String[] word2) {
        int i = 0, j = 0;
        while (i < word1.length && j < word2.length) {
            String s1 = word1[i];
            String s2 = word2[j];
            if (s1.charAt(0) != s2.charAt(0)) return false;
            if (s1.length() > 1) word1[i] = s1.substring(1);
            else i++;
            if (s2.length() > 1) word2[j] = s2.substring(1);
            else j++;
        }
        return (j != word2.length || i >= word1.length) && (i != word1.length || j >= word2.length);
//        if ((j == word2.length && i < word1.length) || (i == word1.length && j < word2.length)) return false;
//        return true;
    }

    @Test
    public void arrayStringsAreEqualTest() {
        LC1662CheckStringArraysEquivalent lc1662CheckStringArraysEquivalent = new LC1662CheckStringArraysEquivalent();
        String[] word1 = new String[]{"ab", "c"};
        String[] word2 = new String[]{"a", "bc"};
        Assert.assertTrue(lc1662CheckStringArraysEquivalent.arrayStringsAreEqualV2(word1, word2));

        word1 = new String[]{"a", "cb"};
        word2 = new String[]{"ab", "c"};
        Assert.assertFalse(lc1662CheckStringArraysEquivalent.arrayStringsAreEqualV2(word1, word2));

        word1 = new String[]{"abc", "d", "defg"};
        word2 = new String[]{"abcddefg"};
        Assert.assertTrue(lc1662CheckStringArraysEquivalent.arrayStringsAreEqualV2(word1, word2));

        word1 = new String[]{"abc", "d", "defg"};
        word2 = new String[]{"abcddef"};
        Assert.assertFalse(lc1662CheckStringArraysEquivalent.arrayStringsAreEqualV2(word1, word2));

        word1 = new String[]{"abcddef"};
        word2 = new String[]{"abc", "d", "defg"};
        Assert.assertFalse(lc1662CheckStringArraysEquivalent.arrayStringsAreEqualV2(word1, word2));
    }

}
