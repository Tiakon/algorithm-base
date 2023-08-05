package cn.tiakon.java.leetcode.array.sort;

import cn.tiakon.java.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * 912. 排序数组
 * https://leetcode.cn/problems/sort-an-array
 *
 * @author tiankai.me@gmail.com on 2022/8/10 17:17.
 */
public class LC912SortArray {

    public int[] sortArrayWithBubbleSort(int[] nums) {
        return bubbleSort(nums);
    }

    public int[] sortArrayWithSelectSort(int[] nums) {
        return selectSort(nums);
    }

    public int[] sortArrayWithInsertSort(int[] nums) {
        return insertSort(nums);
    }

    // 冒泡排序，O(n^2)
    public int[] bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    ArrayUtils.swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    // 选择排序，O(n^2)
    public int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    ArrayUtils.swap(nums, i, j);
                }
            }
        }
        return nums;
    }

    // 插入排序，O(n^2)
    public int[] insertSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    ArrayUtils.swap(nums, j - 1, j);
                }
            }
        }
        return nums;
    }

    // 交换值
    public void swap(int[] nums, int i1, int i2) {
        int temp = nums[i2];
        nums[i2] = nums[i1];
        nums[i1] = temp;
    }

    /**
     * 希尔排序，O(nlogn)
     * https://zhuanlan.zhihu.com/p/42586566
     *
     * @author tiankai.me@gmail.com on 2022/8/10 18:20.
     */
    public static void sortArrayWithShellSort(int[] nums) {
        int temp;
        //对每个增量进行一次排序
        for (int delta = nums.length / 2; delta >= 1; delta /= 2) {
            for (int i = delta; i < nums.length; i++) {
                //注意每个地方增量和差值都是delta
                for (int j = i; j >= delta && nums[j] < nums[j - delta]; j -= delta) {
                    temp = nums[j - delta];
                    nums[j - delta] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    Random random = new Random();

    /**
     * 快速排序
     * 快速排序类似二叉树的前序遍历
     * 快速排序是先将一个元素排好序，然后再将剩下的元素排好序。
     * https://mp.weixin.qq.com/s/8ZTMhvHJK_He48PpSt_AmQ
     * 快速排序的过程是一个构造二叉搜索树的过程。
     *
     * @author tiankai.me@gmail.com on 2022/8/11 19:02.
     */
    public int[] sortArrayWithQuickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int point = partition(nums, left, right);
        quickSort(nums, left, point - 1);
        quickSort(nums, point + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int i = left;
        // 快速排序的过程是一个构造二叉搜索树的过程。
        // 但谈到二叉搜索树的构造，那就不得不说二叉搜索树不平衡的极端情况，极端情况下二叉搜索树会退化成一个链表，导致操作效率大幅降低。
        // 为了避免出现这种极端情况，需要引入随机性。
        // 常见的方式是在进行排序之前对整个数组执行洗牌算法进行打乱，或者在 partition 函数中随机选择数组元素作为分界点
        int q = random.nextInt(right - left + 1) + left;
        swap(nums, right, q);
        for (int j = left; j < right; ++j) {
            if (nums[j] < nums[right]) {
                if (i != j) swap(nums, i, j);
                i += 1;
            }
        }
        swap(nums, i, right);
        return i;
    }

    // 用于辅助合并有序数组
    private int[] temp;

    // 归并排序,类似二叉树的后序遍历
    // 一句话总结归并排序：先把左半边数组排好序，再把右半边数组排好序，然后把两半数组合并。
    // https://labuladong.github.io/algo/2/21/41/
    public int[] sortArrayWithMergeSort(int[] nums) {
        // 先给辅助数组开辟内存空间
        temp = new int[nums.length];
        // 排序整个数组（原地修改）
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    // 定义：将子数组 nums[left,right] 进行排序
    private void sort(int[] nums, int left, int right) {
        // 单个元素不用排序
        if (left == right) return;
        // 这样写是为了防止溢出，效果等同于 (hi + lo) / 2
        int mid = left + (right - left) / 2;
        // 先对左半部分数组 nums[left,mid] 排序
        sort(nums, left, mid);
        // 再对右半部分数组 nums[mid+1,right] 排序
        sort(nums, mid + 1, right);
        // 将两部分有序数组合并成一个有序数组
        merge(nums, left, mid, right);
    }

    // 将 nums[left,mid] 和 nums[mid+1,right] 这两个有序数组合并成一个有序数组
    private void merge(int[] nums, int left, int mid, int right) {
        // 先把 nums[left,right] 复制到辅助数组中
        // 以便合并后的结果能够直接存入 nums
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        // 数组双指针技巧，合并两个有序数组
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                // 左半边数组已全部被合并
                nums[k] = temp[j++];
            } else if (j == right + 1) {
                // 右半边数组已全部被合并
                nums[k] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[k] = temp[j++];
            } else {
                nums[k] = temp[i++];
            }
        }
    }

    @Test
    public void quickPartitionTest() {
        int[] nums = new int[]{5, 6, 3, 1, 8, 7, 2, 4};
        int ans = Quick.partition(nums, 0, nums.length - 1);
        Assert.assertEquals(4, ans);
        Assert.assertArrayEquals(new int[]{2, 4, 3, 1, 5, 7, 8, 6}, nums);

        nums = new int[]{2, 4, 3, 1};
        ans = Quick.partition(nums, 0, nums.length - 1);
        Assert.assertEquals(1, ans);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, nums);

        nums = new int[]{7, 8, 6};
        ans = Quick.partition(nums, 0, nums.length - 1);
        Assert.assertEquals(1, ans);
        Assert.assertArrayEquals(new int[]{6,7,8}, nums);
    }

}

/**
 * 快速排序
 * 快速排序类似二叉树的前序遍历
 * 快速排序是先将一个元素排好序，然后再将剩下的元素排好序。
 * https://mp.weixin.qq.com/s/8ZTMhvHJK_He48PpSt_AmQ
 * 快速排序的过程是一个构造二叉搜索树的过程。
 *
 * @author tiankai.me@gmail.com on 2022/9/13 16:33.
 */
class Quick {

    public static void sort(int[] nums) {
        // 为了避免出现耗时的极端情况，先随机打乱
        shuffle(nums);
        // 排序整个数组（原地修改）
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int left, int right) {
        if (left >= right) return;
        // 对 nums[left,right] 进行切分
        // 使得 nums[left,p-1] <= nums[p] < nums[p+1,right]
        int p = partition(nums, left, right);
        sort(nums, left, p - 1);
        sort(nums, p + 1, right);
    }

    /**
     * 在数组 nums[left..right] 上进行一定程度的排序.
     * 返回数组中的p位置，使得p位置比它左边的元素都大，比它右边的元素都小。
     *
     * @author tiankai.me@gmail.com on 2022/11/8 下午2:13.
     */
    public static int partition(int[] nums, int left, int right) {
        // 选定左边界作为中间值,最终返回中间值的下标
        int pivot = nums[left];
        // 定义左右指针 l, r：
        // 预期最终 [left, l) 上的值都小于等于 pivot, 在 (r, right] 上的值都大于 pivot.
        int l = left + 1, r = right;
        // 当 l > r 时结束循环，以保证区间 [left, right] 都被覆盖
        while (l <= r) {
            // 此 while 结束时恰好 nums[l] > pivot
            while (l < right && nums[l] <= pivot) l++;
            // 此 while 结束时恰好 nums[r] <= pivot
            while (r > left && nums[r] > pivot) r--;
            // 此时 [left, l) <= pivot && (r, right] > pivot
            if (l >= r) break;
            // 如果 nums[l]  大于 pivot 且 nums[r] 小于 pivot 则交换 l、r 位置上的值。
            swap(nums, l, r);
        }
        // 将 pivot 放到合适的位置，即 pivot 比左边元素都大，比右边元素都大
        swap(nums, left, r);
        return r;
    }

    // 洗牌算法，将输入的数组随机打乱
    public static void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    // 原地交换数组中的两个元素
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}