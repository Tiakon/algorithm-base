package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * 2490. 回环句
 * https://leetcode.cn/problems/circular-sentence/
 *
 * @author tiankai.me@gmail.com on 2023-08-01 23:23.
 */
public class LC2490CircularSentence {
    /**
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 为 sentence sentence 的长度。
     * 空间复杂度： O(1)。
     *
     * @author tiankai.me@gmail.com on 2023-08-02 0:14.
     */
    public boolean isCircularSentence(String sentence) {
        for (int i = 0; i <= sentence.length() - 1; ++i) {
            if (i == sentence.length() - 1) {
                if (sentence.charAt(0) == sentence.charAt(i)) break;
                else return false;
            } else if (sentence.charAt(i) == ' ' && i + 1 <= sentence.length() - 1 && (sentence.charAt(i - 1) != sentence.charAt(i + 1))) {
                return false;
            }
        }
        return true;
    }

    public boolean isCircularSentenceV2(String sentence) {
        if (sentence.charAt(sentence.length() - 1) != sentence.charAt(0)) return false;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i + 1) != sentence.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void case01Test() {
        final LC2490CircularSentence circularSentence = new LC2490CircularSentence();

        String in = "leetcode exercises sound delightful";
        Assert.assertTrue(circularSentence.isCircularSentence(in));

        in = "eetcode";
        Assert.assertTrue(circularSentence.isCircularSentence(in));

        in = "Leetcode is cool";
        Assert.assertFalse(circularSentence.isCircularSentence(in));

        in = "leetcode";
        Assert.assertFalse(circularSentence.isCircularSentence(in));

        in = "ab a";
        Assert.assertFalse(circularSentence.isCircularSentence(in));
    }
}
