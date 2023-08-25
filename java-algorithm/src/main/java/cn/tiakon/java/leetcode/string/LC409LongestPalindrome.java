package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 409. 最长回文串
 * https://leetcode.cn/problems/longest-palindrome/
 *
 * @author tiankai.me@gmail.com on 2022/11/22 下午1:56.
 */
public class LC409LongestPalindrome {
    /**
     * 在一个回文串中，只有最多一个字符出现了奇数次，其余的字符都出现偶数次。
     *
     * @author tiankai.me@gmail.com on 2022/11/22 下午2:44.
     */
    public int longestPalindrome(String s) {
        int[] ints = new int[128];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i)] += 1;
        }
        int ans = 0;
        for (int v : ints) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) ++ans;
        }
        return ans;
    }

    public int longestPalindromeV2(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            // 一开始ans是偶数,当v是奇数时,ans加1,此后ans一直会是奇数,此判断条件只会执行一次.
            if (v % 2 == 1 && ans % 2 == 0) ans++;
        }
        return ans;
    }

    @Test
    public void longestPalindromeTest() {
        LC409LongestPalindrome lc409LongestPalindrome = new LC409LongestPalindrome();
        String s = "abccccdd";
        int ans = lc409LongestPalindrome.longestPalindrome(s);
        Assert.assertEquals(7, ans);
        s = "aaaaaccc";
        ans = lc409LongestPalindrome.longestPalindrome(s);
        Assert.assertEquals(7, ans);
        s = "a";
        ans = lc409LongestPalindrome.longestPalindrome(s);
        Assert.assertEquals(1, ans);
        s = "ccc";
        ans = lc409LongestPalindrome.longestPalindrome(s);
        Assert.assertEquals(3, ans);
        s = "bb";
        ans = lc409LongestPalindrome.longestPalindrome(s);
        Assert.assertEquals(2, ans);
    }
}
