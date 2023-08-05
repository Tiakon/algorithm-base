package cn.tiakon.java.leetcode.math;

import org.junit.Assert;
import org.junit.Test;

/**
 * 191. 位1的个数
 * https://leetcode.cn/problems/number-of-1-bits/
 *
 * @author tiankai.me@gmail.com on 2022/11/5 上午10:12.
 */
public class LC191NumberOf1Bits {

    /**
     * 由于计算机中存储的都是数的补码，
     * 正数的原码、反码、补码都是相同的；
     * 而负数的原码、反码、补码是不一样的，补码=原码取反+1（符号位不变）。所以，负数是按照它的补码输出的。
     * <p>
     * 复杂度分析
     * 时间复杂度：O(k)，其中 k 是 \int 型的二进制位数，k=32。我们需要检查 n 的二进制位的每一位，一共需要检查 32 位。
     * 空间复杂度：O(1)，我们只需要常数的空间保存若干变量
     *
     * @author tiankai.me@gmail.com on 2022/11/5 下午8:48.
     */
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 31; i >= 0; i--)
            if ((n >> i & 1) != 0) ++ans;
        return ans;
    }

    public int hammingWeightV2(int n) {
        return Integer.bitCount(n);
    }

    /**
     * https://leetcode.cn/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode-solution-jnwf/
     *
     * @author tiankai.me@gmail.com on 2022/11/5 下午8:47.
     */
    public int hammingWeightV3(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public void binaryToDecimal(int n) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(n >>> i & 1);
        }
        System.out.println("");
    }

    @Test
    public void hammingWeightTest() {
        LC191NumberOf1Bits numberOf1Bits = new LC191NumberOf1Bits();
        // 11111111111111111111111111111101
        // 11111111111111111111111111111101
        numberOf1Bits.binaryToDecimal(-3);

        int n = 00000000000000000000000000001011;
        int ans = numberOf1Bits.hammingWeight(n);
        Assert.assertEquals(3, ans);

        n = 00000000000000000000000010000000;
        ans = numberOf1Bits.hammingWeight(n);
        Assert.assertEquals(1, ans);

//        n = 11111111111111111111111111111101;
        n = -3;
        ans = numberOf1Bits.hammingWeight(n);
        Assert.assertEquals(31, ans);

        //              3    11111111111111111111111111111101
        // 带符号右移    >>    11111111111111111111111111111110
        // 不带符号左移  >>>   01111111111111111111111111111110
        System.out.println(Integer.toBinaryString(-3 >> 1));
        System.out.println(Integer.toBinaryString(-3 >>> 1));

    }
}