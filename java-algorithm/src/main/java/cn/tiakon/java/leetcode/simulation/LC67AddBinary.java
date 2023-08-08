package cn.tiakon.java.leetcode.simulation;

/**
 * 67 二进制求和
 *
 * @author tiankai.me@gmail.com on 2023/7/30 下午4:42.
 */
public class LC67AddBinary {

    public String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        char[] longChars = aChars.length > bChars.length ? aChars : bChars;
        char[] shortChars = aChars.length > bChars.length ? bChars : aChars;
        int count = longChars.length - 1;
        int j = longChars.length - 1;
        for (int i = shortChars.length - 1; i > 0; i--) {
            if (longChars[j] == shortChars[i] && longChars[j] == '1') {
                count--;
                longChars[i] = '0';
            } else if ((shortChars[i] == '1' || longChars[i] == '1') && count == j) {
                count--;
                longChars[i] = '0';
            } else if ((shortChars[i] == '1' || longChars[i] == '1')) {
                longChars[i] = '1';
            }
            j--;
        }
        return "";
    }

    public String addBinaryApi(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public String addBinaryError(String a, String b) {
        int i = getIntFormBin(Integer.parseInt(a));
        int j = getIntFormBin(Integer.parseInt(b));
        return getBinFormInt(i + j);
    }

    // 二进制转十进制
    public int getIntFormBin(int i) {
        int count = 0, sum = 0;
        while (i != 0) {
            if (i % 10 == 1) sum += Math.pow(2, count);
            i = i / 10;
            ++count;
        }
        return sum;
    }

    // 十进制转二进制字符串
    public String getBinFormInt(int i) {
        String ans = "";
        while (i != 0) {
            if (i % 2 == 0) ans = "0" + ans;
            else ans = "1" + ans;
            i = i / 2;
        }
        return "".equals(ans) ? "0" : ans;
    }

}
