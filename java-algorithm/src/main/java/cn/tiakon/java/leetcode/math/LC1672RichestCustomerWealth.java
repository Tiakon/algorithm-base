package cn.tiakon.java.leetcode.math;

import cn.tiakon.java.leetcode.string.LC136LC389FindTheDifference;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1672. 最富有客户的资产总量
 * https://leetcode.cn/problems/richest-customer-wealth/
 *
 * @author tiankai.me@gmail.com on 2022/11/10 上午11:41.
 */
public class LC1672RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).map(Arrays::stream).mapToInt(IntStream::sum).reduce(0, Math::max);
    }

    public int maximumWealthV2(int[][] accounts) {
        int ans = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    @Test
    public void maximumWealthTest() {
        LC1672RichestCustomerWealth richestCustomerWealth = new LC1672RichestCustomerWealth();
        int[][] accounts = new int[][]{{3, 2, 1}, {1, 2, 3}, {2, 1, 3}};
        int ans = richestCustomerWealth.maximumWealth(accounts);
        Assert.assertEquals(6, ans);
    }
}
