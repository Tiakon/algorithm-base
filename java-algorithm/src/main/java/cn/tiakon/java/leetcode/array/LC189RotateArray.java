package cn.tiakon.java.leetcode.array;

/**
 * 189. 右轮转数组
 * https://leetcode.cn/problems/rotate-array/
 *
 * @author tiankai.me@gmail.com on 2022/8/12 22:44.
 */
public class LC189RotateArray {
    /**
     * 顺位右一移，超时
     * 时间复杂度： O(k*n)
     * 空间复杂度： O(1)
     *
     * @author tiankai.me@gmail.com on 2022/8/13 8:58.
     */
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            final int last = nums[nums.length - 1];
            // j -> [0,nums.length - 2]
            for (int j = nums.length - 2; j >= 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
            nums[0] = last;
        }
    }

    /**
     * 模拟流程
     * 时间复杂度： O(n)
     * 空间复杂度： O(n)
     * <p>
     * 创建一个新的数组，计算原数组右移k位后的下标，直接赋值到新数组中
     * 1. 先考虑临界条件，len<=1 或 len=k 不改变原数组位置，直接返回
     * 2. 当len>k 需要通过 k-=len 重新计算出k的值
     * 3. 根据 i+k 直接计算右移k位的值
     * 4. 当 i+k>len时，需要从0开始右移，根据 i-(n-1)+(k-1) 计算新的下标。
     * 5. 因为没有返回值使用 System.arraycopy 改变来数组地址。
     *
     * @author tiankai.me@gmail.com on 2022/8/13 11:07.
     */
    public void rotateV2(int[] nums, int k) {
        while (k > nums.length) {
            k -= nums.length;
        }
        if (nums.length <= 1 || nums.length == k) {
            return;
        }
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i + k >= nums.length) {
                // i-(n-1)+(k-1),
                ints[i - nums.length + k] = nums[i];
            } else {
                ints[i + k] = nums[i];
            }
        }
        System.arraycopy(ints, 0, nums, 0, ints.length);
    }

    /**
     * 时间复杂度： O(n)
     * 空间复杂度： O(1)
     * 在原地修改数组
     * <p>
     * 1.先将原值与右移后的值先进行交换
     * 2.有两种情况，交换后
     * 2.1 原值右移位置的原值的下一步右移下标，与原值的下标相等，此时更新指针i处理下一个节点。
     * 2.2 如果两者不相等，记录原值右移位置的原值的下标j,赋值给i2，作为下次循环处理节点计算右移位置。
     * 3. 根据完成右移元素个数作为终止条件。注意以上两种情况的更新完成右移个数的区别。
     *
     * @author tiankai.me@gmail.com on 2022/8/13 11:08.
     */
    public void rotateV3(int[] nums, int k) {
        while (k > nums.length) {
            k -= nums.length;
        }
        if (nums.length <= 1 || nums.length == k) {
            return;
        }
        // 当前节点的下标
        int i = 0;
        // 循环中当前节点的下标
        int i2 = i;
        int count = 0;
        while (count < nums.length) {
            // 判断当前节点的右移位置
            int j = findOfBounds(nums, i2, k);
            // 判断当前节点右移位置节点，下一步的右移位置
            int j2 = findOfBounds(nums, j, k);
            // 交换值
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            if (j2 != i) {
                // 当前节点右移位置节点下一步右移位置的下标，不相同时
                i2 = j;
                count++;
            } else {
                // 当前节点右移位置节点下一步右移位置的下标，与当前节点下标相同时
                i++;
                i2 = i;
                count += 2;
            }
        }
    }

    // 1. 判断右移下标后是否越界
    public int findOfBounds(int[] nums, int i, int k) {
        if (i + k >= nums.length) {
            // 1.1 下标越界,从0开始在右移
            // i-(n-1)+(k-1),
            return i - nums.length + k;
        } else {
            // 1.2 下标没有越界右移
            return i + k;
        }
    }

    /**
     * https://leetcode.cn/problems/rotate-array/solution/shu-zu-fan-zhuan-xuan-zhuan-shu-zu-by-de-5937/
     *
     * @author tiankai.me@gmail.com on 2022/8/13 23:17.
     */
    public void rotateV4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


}
