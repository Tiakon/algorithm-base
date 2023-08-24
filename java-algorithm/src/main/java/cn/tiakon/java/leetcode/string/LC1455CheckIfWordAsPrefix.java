package cn.tiakon.java.leetcode.string;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 *
 * @author tiankai.me@gmail.com on 2022/8/21 18:19.
 */
public class LC1455CheckIfWordAsPrefix {
    /**
     * 复杂度分析
     * 时间复杂度： O(N)
     * 空间复杂度： O(1)
     *
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 43.22% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/21 18:38.
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -1;
        if (sentence.length() == 0 || searchWord.length() == 0) return ans;
        String[] subString = sentence.split(" ", -1);
        for (int i = 0; i < subString.length; i++) {
            if (subString[i].indexOf(searchWord) == 0) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }

}
