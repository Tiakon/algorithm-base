package cn.tiakon.java.leetcode.string;

/**
 * 1422. 分割字符串的最大得分
 * https://leetcode.cn/problems/maximum-score-after-splitting-a-string/
 * 题解：https://leetcode.cn/problems/maximum-score-after-splitting-a-string/solution/by-ac_oier-3wua/
 *
 * @author tiankai.me@gmail.com on 2022/8/14 6:40.
 */
public class LC1422MaxScoreAfterSplitString {

    public int maxScore(String s) {
        final char[] chars = s.toCharArray();
        int count = 0;
        // 注意 i只能到达len-2，当i到达len-1时右子串为空不讨论。
        for (int i = 0; i < chars.length - 1; i++) {
            int temp = 0;
            for (int j = 0; j < chars.length; j++) {
                if (j < i + 1) {
                    // 统计左子串中0的数量
                    if (chars[j] == '0') {
                        temp++;
                    }
                } else {
                    // 加上统计右子串中1的数量
                    if (chars[j] == '1') {
                        temp++;
                    }
                }
            }
            count = Math.max(count, temp);
        }
        return count;
    }

    public int maxScoreV2(String s) {
        //先统计1的所有个数
        int res = 0, cnt1 = 0, cnt0 = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt1 += s.charAt(i) - '0';
        }
        //再统计0时，将左子串中1的个数减去，得到当前右子串1的个数，省去了每步统计右子串1的步骤。
        for (int i = 0; i < s.length() - 1; i++) {
            // 统计0的个数
            if (s.charAt(i) == '0') {
                cnt0++;
            } else {
                cnt1--;
            }
            // cnt0：当前左子串0的个数
            // cnt1：当前右子串1的个数
            res = Math.max(res, cnt0 + cnt1);
        }
        return res;
    }

    public int maxScoreTemplate(String s) {
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (j < i + 1) {
                    // System.out.print(" |" + j);
                    System.out.print(" |" + chars[j]);
                } else {
                    // System.out.print(" " + j);
                    System.out.print(" " + chars[j]);
                }
            }
            System.out.println("");
        }
        return -1;
    }

}
