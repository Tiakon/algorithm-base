package cn.tiakon.java.leetcode.string;

/**
 * 13. 罗马数字转整数
 * https://leetcode.cn/problems/roman-to-integer/
 *
 * @author tiankai.me@gmail.com on 2022/10/25 下午3:43.
 */
public class LC13RomanToInteger {

    /**
     * 模拟流程
     * 按照题目的描述，可以总结如下规则：
     * 1. 前者比后者大时，加前者 , 如 IV=5+1=6；
     * 2. 前者比后者小时，减前者 , 如 VI=5-1=4；
     * 3. 最后一位,不用比较直接加。
     *
     * @author tiankai.me@gmail.com on 2022/10/27 下午5:20.
     */
    public int romanToInt(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            char c = chars[i];
            Integer v1 = getValue(c);
            if (getValue(chars[i + 1]) > v1) v1 = -v1;
            ans += v1;
        }
        ans += getValue(chars[chars.length - 1]);
        return ans;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
