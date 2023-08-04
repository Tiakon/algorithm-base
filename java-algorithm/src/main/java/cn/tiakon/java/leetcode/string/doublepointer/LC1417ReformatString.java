package cn.tiakon.java.leetcode.string.doublepointer;

/**
 * 1417. 重新格式化字符串
 * https://leetcode.cn/problems/reformat-the-string/
 *
 * @author tiankai.me@gmail.com on 2022/8/11 16:05.
 */
public class LC1417ReformatString {

    public String reformat(String s) {
        final char[] chars = s.toCharArray();
        if (chars.length <= 1) {
            return s;
        }
        // 统计数字的个数
        int intCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                intCount++;
            }
        }
        int strCount = chars.length - intCount;
        // 当数字的个数与字母的个数差值超过1，则无法格式化返回""
        if (Math.abs(strCount - intCount) > 1) {
            return "";
        }
        boolean preIsNum = false;
        // 当数字的个数大于字母个数时，第一个位置放数字，否则放字母
        if (intCount > strCount) {
            preIsNum = true;
        }
        int i = 0, j = 0;
        while (i <= j && j < chars.length) {
            // 都是数字或字母
            if (Character.isDigit(chars[i]) == Character.isDigit(chars[j])) {
                j++;
            } else if (i == 0 && preIsNum && !Character.isDigit(chars[i])) {
                swap(chars, i, j);
                i += 1;
            } else if (i == 0 && !preIsNum && Character.isDigit(chars[i])) {
                swap(chars, i, j);
                i += 1;
            } else {
                swap(chars, i + 1, j);
                i += 2;
            }
        }
        return String.valueOf(chars);
    }

    public String reformatV2(String s) {
        StringBuilder a = new StringBuilder(), b = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a') {
                a.append(c);
            } else {
                b.append(c);
            }
        }
        int n = a.length(), m = b.length(), tot = n + m;
        if (Math.abs(n - m) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() != tot) {
            if (n > m) {
                sb.append(a.charAt(--n));
            } else if (n < m) {
                sb.append(b.charAt(--m));
            } else {
                if (sb != null && sb.charAt(sb.length() - 1) >= 'a') {
                    sb.append(b.charAt(--m));
                } else {
                    sb.append(a.charAt(--n));
                }
            }
        }
        return sb.toString();
    }

    public void swap(char[] chars, int i1, int i2) {
        char temp = chars[i1];
        chars[i1] = chars[i2];
        chars[i2] = temp;
    }

}
