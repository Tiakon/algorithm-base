package cn.tiakon.java.leetcode.array;

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/
 *
 * @author tiankai.me@gmail.com on 2022/10/28 下午9:43.
 */
public class LC27RemoveElement {

    /**
     * 双指针
     * <p>
     * 1. 左指针指向被移除元素,右指针遍历数组.
     * 2. 当右指针不等于val时就与左指针交换.
     * 3. 注意临界条件,当左指针不等于val时,也向右移动.
     * <p>
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 90.29% 的用户
     * 通过测试用例： 113 / 113
     * <p>
     * # 复杂度分析
     * 时间复杂的:O(n)
     * 空间复杂的:O(1)
     *
     * @author tiankai.me@gmail.com on 2022/10/28 下午10:29.
     */
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            } else if (nums[j] != val) j++;
        }
        return j;
    }

    /**
     * 输出数组的长度一定小于等于输入数组的长度，我们可以把输出的数组直接写在输入数组上。
     * 可以使用双指针：右指针 right 指向当前将要处理的元素，左指针 left 指向下一个将要赋值的位置。
     * 右指针 right 不等于 val时 就写入 左指针将要赋值的位置.
     *
     * @author tiankai.me@gmail.com on 2022/10/28 下午10:52.
     */
    public int removeElementV2(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[j++] = nums[i];
        }
        return j;
    }

}
