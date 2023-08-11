package cn.tiakon.java.leetcode.simple;

/**
 * 【 #07 难易程度：简单 】
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * Integer.MAX_VALUE = 2^31 − 1 = 2147483647
 * Integer.MIN_VALUE = −2^31    = -2147483648
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * project : algorithm-base
 * package : cn.tiakon.java.leetcode.simple
 * email : tiankai.me@gmail.com
 *
 * @author Created by Tiakon on 2019/2/14 22:07.
 */
public class LC07IntReverse {

    // 15 ms	38 MB
    private static int intReverse(int n) {
        boolean isSymbol = false;
        String intStr = Integer.toString(n);
        if (intStr.contains("-")) {
            isSymbol = true;
            intStr = intStr.replaceFirst("\\-", "");
        }
        char[] chars = intStr.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            builder.append(chars[i]);
        }
        if (!isSymbol) {
            intStr = builder.toString();
        } else {
            intStr = "-".concat(builder.toString());
        }
        try {
            return Integer.valueOf(intStr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(">> 数值溢出...");
            return 0;
        }
    }

    // 1 ms	37 MB
    public static int reverseWay1(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            //如果数字溢出，直接返回0
            if ((newRes - t) / 10 != res)
                return 0;
            res = newRes;
            x = x / 10;
        }
        return res;
    }

    // 1 ms	36.8 MB ，通过取余与乘10累加来实现反转。主要区分是如何判断溢出条件？
    public static int reverseWay2(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    // 	1 ms	37.1 MB
    public static int reverseWay3(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverseWay3(2147483647));
    }

}
