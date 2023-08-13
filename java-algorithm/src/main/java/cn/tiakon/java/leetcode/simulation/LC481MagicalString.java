package cn.tiakon.java.leetcode.simulation;

/**
 * 481. 神奇字符串
 * https://leetcode.cn/problems/magical-string/
 *
 * @author tiankai.me@gmail.com on 2022/10/31 下午5:09.
 */
public class LC481MagicalString {

    /**
     * 统计神奇字符串中1的数量
     *
     * @author tiankai.me@gmail.com on 2022/10/31 下午7:16.
     */
    public int magicalString(int n) {
        if (n < 3) return 1;
        char[] chars = new char[n];
        chars[0] = '1';
        chars[1] = chars[2] = '2';
        int i = 2;
        int j = 3;
        int ans = 1;
        while (j < n) {
            char lastChar = chars[j - 1];
            if (chars[i] == '1') {
                if (lastChar == '1') chars[j++] = '2';
                else {
                    chars[j++] = '1';
                    ++ans;
                }
            } else {
                if (lastChar == '1') {
                    chars[j++] = '2';
                    if (j >= n) break;
                    chars[j++] = '2';
                } else {
                    chars[j++] = '1';
                    ans += 1;
                    if (j >= n) break;
                    chars[j++] = '1';
                    ans += 1;
                }
            }
            i++;
        }
        return ans;
    }

    // 没有严格限制生成字符串的长度
    public String getMagicalString(int size) {
        StringBuilder builder = new StringBuilder();
        builder.append("122");
        int i = 2;
        while (builder.toString().length() < size) {
            String s = builder.toString();
            char lastChar = s.charAt(s.length() - 1);
            if (s.charAt(i) == '1') builder.append(lastChar == '1' ? "2" : "1");
            else builder.append(lastChar == '1' ? "22" : "11");
            i++;
        }
        return builder.toString();
    }

    public String getMagicalStringV2(int n) {
        char[] chars = new char[n];
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = '2';
        int i = 2;
        int j = 3;
        int ans = 1;
        while (j < n) {
            char lastChar = chars[j - 1];
            if (chars[i] == '1') {
                if (lastChar == '1') chars[j++] = '2';
                else {
                    chars[j++] = '1';
                    ++ans;
                }
            } else {
                if (lastChar == '1') {
                    chars[j++] = '2';
                    if (j >= n) break;
                    chars[j++] = '2';
                } else {
                    chars[j++] = '1';
                    ans += 1;
                    if (j >= n) break;
                    chars[j++] = '1';
                    ans += 1;
                }
            }
            i++;
        }
//        System.out.println(ans);
        return new String(chars);
    }

    public int magicalStringV3(int n) {
        char[] s = new char[n + 2];
        s[0] = 1;
        s[1] = s[2] = 2;
        char c = 2;
        for (int i = 2, j = 3; j < n; ++i) {
            // 异或运算符=无进位相加
            // 1^2=011=3
            // 1^3=010=2
            // 2^3=001=1
            c ^= 3; // 1^3=2, 2^3=1，这样就能在 1 和 2 之间转换
            s[j++] = c;
            if (s[i] == 2) s[j++] = c;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) ans += 2 - s[i]; // 2-1=1，2-2=0，这样就只统计了 1
        return ans;
    }


}
