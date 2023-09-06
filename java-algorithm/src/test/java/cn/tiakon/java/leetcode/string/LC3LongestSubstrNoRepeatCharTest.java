package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class LC3LongestSubstrNoRepeatCharTest {

    @Test
    public void lengthOfLongestSubstringTest() {
        final LC3LongestSubstrNoRepeatChar lc3LongestSubstrNoRepeatChar = new LC3LongestSubstrNoRepeatChar();
        String s = "abcabcbb";
        int longestSubstring = lc3LongestSubstrNoRepeatChar.lengthOfLongestSubstring(s);
        Assert.assertEquals(3, longestSubstring);

        s = "bbbbb";
        longestSubstring = lc3LongestSubstrNoRepeatChar.lengthOfLongestSubstring(s);
        Assert.assertEquals(1, longestSubstring);

        s = "pwwkew";
        longestSubstring = lc3LongestSubstrNoRepeatChar.lengthOfLongestSubstring(s);
        Assert.assertEquals(3, longestSubstring);

        s = "dvdf";
        longestSubstring = lc3LongestSubstrNoRepeatChar.lengthOfLongestSubstring(s);
        Assert.assertEquals(3, longestSubstring);
    }

    @Test
    public void lengthOfLongestSubstringV2Test() {
        final LC3LongestSubstrNoRepeatChar lc3LongestSubstrNoRepeatChar = new LC3LongestSubstrNoRepeatChar();
        String s = "abcabcbb";
        int longestSubstring = lc3LongestSubstrNoRepeatChar.lengthOfLongestSubstringV2(s);
        Assert.assertEquals(3, longestSubstring);

        s = "bbbbb";
        longestSubstring = lc3LongestSubstrNoRepeatChar.lengthOfLongestSubstringV2(s);
        Assert.assertEquals(1, longestSubstring);

        s = "pwwkew";
        longestSubstring = lc3LongestSubstrNoRepeatChar.lengthOfLongestSubstringV2(s);
        Assert.assertEquals(3, longestSubstring);

        s = "dvdf";
        longestSubstring = lc3LongestSubstrNoRepeatChar.lengthOfLongestSubstringV2(s);
        Assert.assertEquals(3, longestSubstring);
    }

    @Test
    public void lengthOfLongestSubstringV3Test() {
        final LC3LongestSubstrNoRepeatChar lc3LongestSubstrNoRepeatChar = new LC3LongestSubstrNoRepeatChar();
        String s = "abcabcbb";
        int longestSubstring = lc3LongestSubstrNoRepeatChar.lengthOfLongestSubstringV3(s);
        Assert.assertEquals(3, longestSubstring);

        s = "bbbbb";
        longestSubstring = lc3LongestSubstrNoRepeatChar.lengthOfLongestSubstringV3(s);
        Assert.assertEquals(1, longestSubstring);

        s = "pwwkew";
        longestSubstring = lc3LongestSubstrNoRepeatChar.lengthOfLongestSubstringV3(s);
        Assert.assertEquals(3, longestSubstring);

        s = "dvdf";
        longestSubstring = lc3LongestSubstrNoRepeatChar.lengthOfLongestSubstringV3(s);
        Assert.assertEquals(3, longestSubstring);
    }

    @Test
    public void StringToCharTest() {
        String s = "abcabcbb";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            System.out.println(ch);
        }
    }

}
