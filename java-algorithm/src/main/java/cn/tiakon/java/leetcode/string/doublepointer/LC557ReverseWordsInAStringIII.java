package cn.tiakon.java.leetcode.string.doublepointer;


/**
 * 557. 反转字符串中的单词 III
 * https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 *
 * @author tiankai.me@gmail.com on 2022/8/12 7:25.
 */
public class LC557ReverseWordsInAStringIII {
    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * 执行用时：3 ms, 在所有 Java 提交中击败了91.65% 的用户
     * 内存消耗：42.5 MB, 在所有 Java 提交中击败了8.95%的用户
     * 通过测试用例： 29 / 29
     *
     * @author tiankai.me@gmail.com on 2022/8/12 7:56.
     */
    public String reverseWords(String s) {
        final char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while (i <= j && j < chars.length) {
            if (chars[j] == ' ' || j == chars.length - 1) {
                reverseString(chars, i, j == chars.length - 1 ? j : j - 1);
                i = j + 1;
            }
            j++;
        }
        return String.valueOf(chars);
    }

    private void reverseString(char[] chars, int l, int r) {
        while (l < r) {
            swap(chars, l, r);
            l++;
            r--;
        }
    }

    private void swap(char[] chars, int i1, int i2) {
        char temp = chars[i2];
        chars[i2] = chars[i1];
        chars[i1] = temp;
    }


}

