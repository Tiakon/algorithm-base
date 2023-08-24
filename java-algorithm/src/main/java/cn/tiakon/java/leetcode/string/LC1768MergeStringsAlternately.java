package cn.tiakon.java.leetcode.string;

/**
 * 1768. 交替合并字符串
 * https://leetcode.cn/problems/merge-strings-alternately/
 *
 * @author tiankai.me@gmail.com on 2022/11/10 下午12:04.
 */
public class LC1768MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            builder.append(word1.charAt(i)).append(word2.charAt(i++));
        }
        if (word1.length() > word2.length()) builder.append(word1.substring(i));
        else if (word1.length() < word2.length()) builder.append(word2.substring(i));
        return builder.toString();
    }

    public String mergeAlternatelyV2(String s1, String s2) {
        int n = s1.length(), m = s2.length(), i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n || j < m) {
            if (i < n) sb.append(s1.charAt(i++));
            if (j < m) sb.append(s2.charAt(j++));
        }
        return sb.toString();
    }
}
