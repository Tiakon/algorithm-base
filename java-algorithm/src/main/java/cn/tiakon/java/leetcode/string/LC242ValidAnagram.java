package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 * https://leetcode.cn/problems/valid-anagram/
 *
 * @author tiankai.me@gmail.com on 2022/11/24 下午11:09.
 */
public class LC242ValidAnagram {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.6 MB , 在所有 Java 提交中击败了 51.59% 的用户
     * 通过测试用例： 37 / 37
     *
     * @author tiankai.me@gmail.com on 2022/11/25 上午9:38.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] cnt = new int[128];
        for (char c : s.toCharArray()) ++cnt[c];
        for (char c : t.toCharArray()) {
            // 当t中出现s中没有出现的字符时值会为负值,可当作返回条件
            if (--cnt[c] < 0) return false;
        }
        return true;
    }

    public boolean isAnagramForMy2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] ints = new int[128];
        for (int i = 0; i < s.length(); i++) {
            ++ints[s.charAt(i)];
        }
        for (int i = 0; i < t.length(); i++) {
            if (--ints[t.charAt(i)] < 0) return false;
        }
        return true;
    }

    public boolean isAnagramForMy(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] ints = new int[128];
        for (int i = 0; i < s.length(); i++) {
            ++ints[s.charAt(i)];
            --ints[t.charAt(i)];
        }
        for (int anInt : ints) {
            if (anInt != 0) return false;
        }
        return true;
    }

    public boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    @Test
    public void isAnagramTest() {
        LC242ValidAnagram lc242ValidAnagram = new LC242ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        Assert.assertTrue(lc242ValidAnagram.isAnagramForMy2(s, t));

        s = "anagramasd";
        t = "nagaramwer";
        Assert.assertFalse(lc242ValidAnagram.isAnagramForMy2(s, t));

    }

}
