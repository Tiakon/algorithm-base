package cn.tiakon.java.leetcode.array.doublepointer;

import cn.tiakon.java.utils.ArrayUtils;

/**
 * 283. 移动零：最优解法双指针
 * https://leetcode.cn/problems/move-zeroes
 *
 * 2460. 对数组执行操作
 * https://leetcode.cn/problems/apply-operations-to-an-array/
 *
 * @author tiankai.me@gmail.com on 2022/8/10 15:06.
 */
public class LC283MoveZeroes {

    // 冒泡解法：O(n^2)
    public int[] moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] == 0) {
                    ArrayUtils.swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    // 双指针解法
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int[] moveZeroesV2(int[] nums) {
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
        return nums;
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * <p>
     * 双指针思路及解法
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     * 注意到以下性质：
     * 左指针左边均为非零数；
     * 右指针左边直到左指针处均为零。
     * 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
     * 作者：wang_ni_ma
     * 链接：https://leetcode.cn/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @author tiankai.me@gmail.com on 2022/8/10 16:14.
     */
    public int[] moveZeroesV3(int[] nums) {
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
        return nums;
    }

}
