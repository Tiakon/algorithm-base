package cn.tiakon.java.leetcode.string;

/**
 * 58. 最后一个单词的长度
 * https://leetcode.cn/problems/length-of-last-word/
 *
 * @author tiankai.me@gmail.com on 2022/10/29 下午8:04.
 */
public class LC58LengthOfLastWord {
    /**
     * ### 双指针解题思路
     * 1. 逆序判断，右指针记录字符串的右侧位置。
     * 2. 左指针记录字符串的左侧位置。
     * 3. 注意，当左指针等于0时直接返回。
     * ### 复杂度分析
     * 时间复杂度： O(n)
     * 空间复杂度： O(1)
     * ### 实测
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 76.10% 的用户
     * 通过测试用例： 58 / 58
     *
     * @author tiankai.me@gmail.com on 2022/10/29 下午10:11.
     */
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int i = chars.length - 1, j = i;
        while (j <= i && j >= 0) {
            if (chars[i] == ' ') i--;
            else if (chars[j] == ' ') break;
            j--;
        }
        return j == 0 ? i : i - j;
    }

    public int lengthOfLastWordV2(String s) {
        String trim = s.trim();
        int indexOf = trim.lastIndexOf(" ");
        if (indexOf < 0) return trim.length();
        return trim.substring(indexOf + 1).length();
    }


}
