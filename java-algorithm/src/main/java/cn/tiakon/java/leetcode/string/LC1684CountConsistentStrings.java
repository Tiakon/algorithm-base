package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1684. 统计一致字符串的数目
 * https://leetcode.cn/problems/count-the-number-of-consistent-strings/
 *
 * @author tiankai.me@gmail.com on 2022/11/8 下午9:26.
 */
public class LC1684CountConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        for (String word : words) {
            boolean isAllContains = true;
            for (char aChar : word.toCharArray()) {
                if (!allowed.contains(aChar + "")) {
                    isAllContains = false;
                    break;
                }
            }
            if (isAllContains) ++ans;
        }
        return ans;
    }

    // 哈希表或数组
    public int countConsistentStringsV2(String allowed, String[] words) {
        boolean[] s = new boolean[26];
        for (char c : allowed.toCharArray()) s[c - 'a'] = true;
        int ans = 0;
        for (String w : words) if (check(w, s)) ++ans;
        return ans;
    }

    private boolean check(String w, boolean[] s) {
        for (int i = 0; i < w.length(); ++i) if (!s[w.charAt(i) - 'a']) return false;
        return true;
    }

    // 使用位运算
    public int countConsistentStringsV3(String allowed, String[] words) {
        int mask = f(allowed);
        int ans = 0;
        for (String w : words) if ((mask | f(w)) == mask) ++ans;
        return ans;
    }

    private int f(String w) {
        int mask = 0;
        for (int i = 0; i < w.length(); ++i) mask |= 1 << (w.charAt(i) - 'a');
        return mask;
    }

    @Test
    public void LC1684CountConsistentStringsTest() {
        LC1684CountConsistentStrings countConsistentStrings = new LC1684CountConsistentStrings();
        String allowed = "ab";
        String[] words = new String[]{"ad", "bd", "aaab", "baa", "badab"};
        int ans = countConsistentStrings.countConsistentStrings(allowed, words);
        Assert.assertEquals(2, ans);

        allowed = "abc";
        words = new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"};
        ans = countConsistentStrings.countConsistentStrings(allowed, words);
        Assert.assertEquals(7, ans);

        allowed = "cad";
        words = new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        ans = countConsistentStrings.countConsistentStrings(allowed, words);
        Assert.assertEquals(4, ans);

    }
}
