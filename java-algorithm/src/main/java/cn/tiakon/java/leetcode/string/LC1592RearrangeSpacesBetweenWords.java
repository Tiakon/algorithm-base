package cn.tiakon.java.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 1592. 重新排列单词间的空格
 * https://leetcode.cn/problems/rearrange-spaces-between-words/
 *
 * @author tiankai.me@gmail.com on 2022/9/7 11:00.
 */
public class LC1592RearrangeSpacesBetweenWords {

    /**
     * 模拟流程
     * 1. 计算单词间隔与空格长度的值求平均值
     *
     * @author tiankai.me@gmail.com on 2022/9/7 12:03.
     */
    public String reorderSpaces(String text) {
        if (!text.contains(" ")) return text;
        String[] arrStr = text.trim().split("\\s+", -1);
        int wordInterval = arrStr.length - 1, wordLength = 0, spaceNum = 0;
        for (char c : text.toCharArray()) {
            if (c > 96 && c < 123) wordLength++;
            else spaceNum++;
        }
        final StringBuilder builder = new StringBuilder();
        if (wordInterval == 0) builder.append(arrStr[0]).append(getSpaceString(spaceNum));
        else {
            for (int i = 0; i < arrStr.length; i++) {
                builder.append(arrStr[i]);
                if (i == arrStr.length - 1) {
                    if (spaceNum % wordInterval != 0) builder.append(getSpaceString(spaceNum % wordInterval));
                } else builder.append(getSpaceString(spaceNum / wordInterval));
            }
        }
        return builder.toString();
    }

    public String getSpaceString(int spaceLength) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < spaceLength; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    /**
     * 模拟流程之双指针
     * 复杂度分析
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @author tiankai.me@gmail.com on 2022/9/7 13:56.
     */
    public String reorderSpacesV2(String s) {
        int n = s.length(), cnt = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == ' ' && ++i >= 0 && ++cnt >= 0) continue;
            int j = i;
            while (j < n && s.charAt(j) != ' ') j++;
            list.add(s.substring(i, j));
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        int m = list.size(), t = cnt / Math.max(m - 1, 1);
        String k = "";
        while (t-- > 0) k += " ";
        for (int i = 0; i < m; i++) {
            sb.append(list.get(i));
            if (i != m - 1) sb.append(k);
        }
        while (sb.length() != n) sb.append(" ");
        return sb.toString();
    }

}
