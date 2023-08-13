package cn.tiakon.java.leetcode.simulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * 6. Z 字形变换
 * https://leetcode.cn/problems/zigzag-conversion/
 *
 * @author tiankai.me@gmail.com on 2022/11/1 下午6:35.
 */
public class LC6ZigzagConversion {

    /**
     * 模拟流程:
     * 将输入字符串按照给定行数,按Z字形排列
     * 1. 通过将数据放入矩阵中，按Z字形排列
     * 2. 再从矩阵中打印新的字符串
     * <p>
     * 执行用时： 35 ms , 在所有 Java 提交中击败了 20.08% 的用户
     * 内存消耗： 44.4 MB , 在所有 Java 提交中击败了 8.40% 的用户
     * 通过测试用例：
     * 1157 / 1157
     *
     * @author tiankai.me@gmail.com on 2022/11/2 下午2:28.
     */
    public String convert(String s, int numRows) {
        int l = s.length(), r = numRows;
        if (r == 1 || r >= l) return s;
        int t = r * 2 - 2;
        // 多加的t - 1,是为了向上取整
        int c = (l + t - 1) / t * (r - 1);
        char[][] matrix = new char[r][c];
        for (int i = 0, col = 0, row = 0; i < l; i++) {
            matrix[row][col] = s.charAt(i);
            if (i % t < r - 1) ++row; // 向下移动
            else {
                --row;
                ++col;// 向右上移动
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char[] rowChars : matrix) {
            for (char colChar : rowChars) {
                if (colChar != 0) builder.append(colChar);
            }
        }
        return builder.toString();
    }

    /**
     * 直接构造返回字符串
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 90.00% 的用户
     * 内存消耗： 41.9 MB , 在所有 Java 提交中击败了 59.64% 的用户
     * 通过测试用例： 1157 / 1157
     *
     * @author tiankai.me@gmail.com on 2022/11/2 下午6:16.
     */
    public String convertV2(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) return s;
        int t = r * 2 - 2;
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < r; i++) { // 枚举行
            for (int j = 0; j < n - i; j += t) { // 枚举每个周期的起始索引
                ans.append(s.charAt(i + j)); // 当前周期的第一个字符
                if (i > 0 && i < r - 1 && j + t - i < n)
                    ans.append(s.charAt(j + t - i)); // 枚举当前周期的第二个字符
            }
        }
        return ans.toString();
    }

    @Test
    public void convertTest() {
        LC6ZigzagConversion zigzagConversion = new LC6ZigzagConversion();
        String s = "a";
        String ans = zigzagConversion.convert(s, 1);
        Assert.assertEquals(s, ans);

        s = "PAYPALISHIRING";
        ans = zigzagConversion.convert(s, 3);
        Assert.assertEquals("PAHNAPLSIIGYIR", ans);

        ans = zigzagConversion.convert(s, 4);
        Assert.assertEquals("PINALSIGYAHRPI", ans);

        ans = zigzagConversion.convert(s, 9);
        Assert.assertEquals("PAYPGANLIIRSIH", ans);

        s = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";
        ans = zigzagConversion.convert(s, 10);
        Assert.assertEquals("A,tsaclmapdpohttsmetaltennarhreiheerilosnodlorornahwioawutiw.iwa,suttadnrajstosnasrefcdyr,endtarrdseeqoaaiewncaouderi,buenenhieerptddoenmecbrettgsouciimuneihfnv", ans);
    }

}
