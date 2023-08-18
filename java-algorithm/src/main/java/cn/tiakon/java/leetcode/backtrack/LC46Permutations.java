package cn.tiakon.java.leetcode.backtrack;

import java.util.*;

/**
 * 46.全排列
 * https://leetcode.cn/problems/permutations/
 *
 * @author tiankai.me@gmail.com on 2022/8/23 16:44.
 */
public class LC46Permutations {

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 80.73% 的用户
     * 内存消耗： 41.4 MB , 在所有 Java 提交中击败了 80.23% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/23 18:11.
     */
    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> ans = new ArrayList<>();
        final Deque<Integer> path = new ArrayDeque<>();
        backtrack(nums, path, ans);
        return ans;
    }

    public void backtrack(int[] nums, Deque<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.addLast(nums[i]);
                // System.out.println("  递归之前 => " + path);
                backtrack(nums, path, ans);
                path.removeLast();
                // System.out.println("  递归之前 => " + path);
            }
        }
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.7 MB , 在所有 Java 提交中击败了 48.67% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/23 18:10.
     */
    public List<List<Integer>> permuteV2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public List<List<Character>> permuteV3(char[] nums) {
        final List<List<Character>> ans = new ArrayList<>();
        final Deque<Character> path = new ArrayDeque<>();
        backtrackV3(nums, path, ans);
        return ans;
    }

    public void backtrackV3(char[] nums, Deque<Character> path, List<List<Character>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.addLast(nums[i]);
                // System.out.println("  递归之前 => " + path);
                backtrackV3(nums, path, ans);
                path.removeLast();
                // System.out.println("  递归之前 => " + path);
            }
        }
    }


}
