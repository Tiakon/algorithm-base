package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1668. 最大重复子字符串
 * https://leetcode.cn/problems/maximum-repeating-substring/
 *
 * @author tiankai.me@gmail.com on 2022/11/3 上午10:22.
 */
public class LC1668MaximumRepeatingSubstring {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 40.3 MB , 在所有 Java 提交中击败了 5.47% 的用户
     * 通过测试用例： 212 / 212
     *
     * @author tiankai.me@gmail.com on 2022/11/3 下午12:04.
     */
    public int maxRepeating(String sequence, String word) {
        int wl = word.length(), sl = sequence.length();
        if (wl > sl) return 0;
        int left = 0, right = wl, preIndex = -1, ans = 0, max = 0;
        while (right < sl + 1) {
            if (word.equals(sequence.substring(left, right))) {
                if (ans == 0 || left - preIndex == 1) ans++;
                else ans = 1;
                preIndex = right - 1;
                left += wl;
                right += wl;
                max = Math.max(max, ans);
            } else {
                ++left;
                ++right;
            }
        }
        left = sl - wl;
        right = preIndex = sl;
        ans = 0;
        while (left >= 0) {
            if (word.equals(sequence.substring(left, right))) {
                if (ans == 0 || right == preIndex) ans++;
                else ans = 1;
                preIndex = left;
                left -= wl;
                right -= wl;
                max = Math.max(max, ans);
            } else {
                --left;
                --right;
            }
        }
        return max;
    }

    public int maxRepeatingV2(String sequence, String word) {
        String s=word;
        int ans=0;
        while(sequence.contains(s)){
            ans++;
            s+=word;
        }
        return ans;
    }

    @Test
    public void maxRepeatingTest() {
        LC1668MaximumRepeatingSubstring lc1668MaximumRepeatingSubstring = new LC1668MaximumRepeatingSubstring();

        String sequence = "ababc";
        String word = "ab";
        int ans = lc1668MaximumRepeatingSubstring.maxRepeating(sequence, word);
        Assert.assertEquals(2, ans);

        sequence = "abcab";
        word = "ab";
        ans = lc1668MaximumRepeatingSubstring.maxRepeating(sequence, word);
        Assert.assertEquals(1, ans);

        sequence = "ababc";
        word = "ba";
        ans = lc1668MaximumRepeatingSubstring.maxRepeating(sequence, word);
        Assert.assertEquals(1, ans);

        sequence = "ananc";
        word = "ac";
        ans = lc1668MaximumRepeatingSubstring.maxRepeating(sequence, word);
        Assert.assertEquals(0, ans);

        sequence = "bababbbaabbaaabbbabbaaaaabaabbaaabaab";
        word = "a";
        ans = lc1668MaximumRepeatingSubstring.maxRepeating(sequence, word);
        Assert.assertEquals(5, ans);

        sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        word = "aaaba";
        ans = lc1668MaximumRepeatingSubstring.maxRepeating(sequence, word);
        Assert.assertEquals(5, ans);

        sequence = "abaabaabaababaabaaba";
        word = "aba";
        ans = lc1668MaximumRepeatingSubstring.maxRepeating(sequence, word);
        Assert.assertEquals(4, ans);
    }
}
