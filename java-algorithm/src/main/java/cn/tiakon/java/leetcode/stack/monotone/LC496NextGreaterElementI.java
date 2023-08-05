package cn.tiakon.java.leetcode.stack.monotone;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 * https://leetcode.cn/problems/next-greater-element-i/
 *
 * @author tiankai.me@gmail.com on 2022/11/20 下午12:16.
 */
public class LC496NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    nums1[i] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            int index = nums1[i];
            boolean notFind = true;
            for (int j = index + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[index]) {
                    nums1[i] = nums2[j];
                    notFind = false;
                    break;
                }
            }
            if (notFind) nums1[i] = -1;
        }
        return nums1;
    }

    /**
     * 时间复杂度：维护单调栈，每个元素最多入栈出栈一次，复杂度为 O(m)；构造答案复杂度为 O(n)。整体复杂度为 O(n+m)
     * 空间复杂度：O(m)
     */
    public int[] nextGreaterElementV2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        // 倒序遍历 nums2 ，并用单调栈中维护当前位置右边的更大的元素列表，从栈底到栈顶的元素是单调递减的。
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            // 栈内只保留比数组中大的值
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            hashMap.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hashMap.get(nums1[i]);
        }
        return nums1;
    }

    @Test
    public void nextGreaterElementTest() {
        LC496NextGreaterElementI nextGreaterElementI = new LC496NextGreaterElementI();
        int[] num1 = new int[]{137, 59, 92, 122, 52, 131, 79, 236, 94, 171, 141, 86, 169, 199, 248, 120, 196, 168, 77, 71, 5, 198, 215, 230, 176};
        int[] num2 = new int[]{137, 59, 92, 122, 52, 131, 79, 236, 94, 171, 141, 86, 169, 199, 248, 120, 196, 168, 77, 71, 5, 198, 215, 230, 176};
        int[] ans = nextGreaterElementI.nextGreaterElement(num1, num2);
        // [236,92,122,131,131,198,236,248,171,199,169,169,199,248,-1,196,198,198,198,198,198,215,230,-1,-1]
        // [236,92,122,131,131,236,236,248,171,199,169,169,199,248,-1,196,198,198,198,198,198,215,230,-1,-1]
        Assert.assertArrayEquals(new int[]{236, 92, 122, 131, 131, 236, 236, 248, 171, 199, 169, 169, 199, 248, -1, 196, 198, 198, 198, 198, 198, 215, 230, -1, -1}, ans);
    }
}
