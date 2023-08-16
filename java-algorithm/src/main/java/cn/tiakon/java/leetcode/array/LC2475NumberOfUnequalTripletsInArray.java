package cn.tiakon.java.leetcode.array;

import org.junit.Assert;
import org.junit.Test;


/**
 * <a href="https://leetcode.cn/problems/number-of-unequal-triplets-in-array/">2475. 数组中不等三元组的数目</a>
 * @author tiankai.me@gmail.com on 2022/12/8 上午11:23.
 */
public class LC2475NumberOfUnequalTripletsInArray {

    // 某次周赛的题解
    public int unequalTriplets(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] == nums[j]) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) ans++;
                }
            }
        }
        return ans;
    }

    @Test
    public void unequalTripletsTest() {
        LC2475NumberOfUnequalTripletsInArray tripletsInArray = new LC2475NumberOfUnequalTripletsInArray();
        int[] nums = new int[]{4, 4, 2, 4, 3};
        int ans = tripletsInArray.unequalTriplets(nums);
        Assert.assertEquals(3, ans);

        nums = new int[]{1, 1, 1, 1, 1};
        ans = tripletsInArray.unequalTriplets(nums);
        Assert.assertEquals(0, ans);
    }
}
