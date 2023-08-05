package cn.tiakon.java.leetcode.math;

/**
 * 1822. 数组元素积的符号
 * https://leetcode.cn/problems/sign-of-the-product-of-an-array/
 *
 * @author tiankai.me@gmail.com on 2022/10/27 上午10:47.
 */
public class LC1822SignOfTheProductOfAnArray {
    /**
     * 极简数学:通过负数的奇偶性来判断
     *
     * @author tiankai.me@gmail.com on 2022/10/27 下午4:26.
     */
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int i : nums) {
            if (i == 0) return 0;
            if (i < 0) ans = -ans;
        }
        return ans;
    }
}
