package cn.tiakon.java.leetcode.string;

/**
 * 640. 求解方程
 * https://leetcode.cn/problems/solve-the-equation/
 *
 * @author tiankai.me@gmail.com on 2022/8/10 23:32.
 */
public class LC640SolveTheEquation {

    // 模拟流程
    public String solveEquation(String s) {
        int nx = 0, nSum = 0;
        final char[] chars = s.toCharArray();
        boolean isLeft = true;
        boolean isPlus = true;
        // chars[i] ->  + - = 常数项 x和系数
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                isPlus = true;
            } else if (chars[i] == '-') {
                isPlus = false;
            } else if (chars[i] == '=') {
                isLeft = false;
                isPlus = true;
            } else {
                // item 可能是 常数项 x的系数 或 x
                String item = String.valueOf(chars[i]);
                while (Character.isDigit(chars[i]) && (i < chars.length - 1 && Character.isDigit(chars[i + 1]))) {
                    item = item.concat(String.valueOf(chars[i + 1]));
                    i++;
                }
                if (chars[i] == 'x') {
                    // 处理 x
                    if (isLeft) {
                        nx += isPlus ? 1 : -1;
                    } else {
                        nx += isPlus ? -1 : 1;
                    }
                } else if (i < chars.length - 1 && chars[i + 1] == 'x') {
                    // 处理 x的系数
                    int n = Integer.parseInt(item);
                    if (isLeft) {
                        nx += isPlus ? n : -n;
                    } else {
                        nx += isPlus ? -n : n;
                    }
                    i++;
                } else {
                    // 处理常数项
                    final int num = Integer.parseInt(item);
                    if (isLeft) {
                        nSum += isPlus ? num : -num;
                    } else {
                        nSum += isPlus ? -num : +num;
                    }
                }
            }
        }
        System.out.println(nx + "x " + (nSum < 0 ? "" + nSum : ("+" + nSum)));
        String ans;
        if (Math.abs(nx) == 1) {
            ans = "x=".concat(String.valueOf(nx == -1 ? nSum : -nSum));
        } else if (Math.abs(nx) > 1 && Math.abs(nSum % nx) == 0) {
            ans = "x=".concat(String.valueOf(-(nSum / nx)));
        } else if (Math.abs(nx) == Math.abs(nSum) && Math.abs(nx) == 0) {
            // 无限解
            ans = "Infinite solutions";
        } else {
            // 没有整数解
            ans = "No solution";
        }
        return ans;
    }

    public String solveEquationV2(String s) {
        int x = 0, num = 0, n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0, op = 1; i < n; ) {
            if (cs[i] == '+') {
                op = 1;
                i++;
            } else if (cs[i] == '-') {
                op = -1;
                i++;
            } else if (cs[i] == '=') {
                x *= -1;
                num *= -1;
                op = 1;
                i++;
            } else {
                int j = i;
                while (j < n && cs[j] != '+' && cs[j] != '-' && cs[j] != '=') j++;
                if (cs[j - 1] == 'x') x += (i < j - 1 ? Integer.parseInt(s.substring(i, j - 1)) : 1) * op;
                else num += Integer.parseInt(s.substring(i, j)) * op;
                i = j;
            }
        }
        if (x == 0) return num == 0 ? "Infinite solutions" : "No solution";
        else return "x=" + (num / -x);
    }

}
