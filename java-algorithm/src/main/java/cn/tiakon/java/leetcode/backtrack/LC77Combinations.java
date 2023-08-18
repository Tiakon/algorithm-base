package cn.tiakon.java.leetcode.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode.cn/problems/combinations/
 *
 * @author tiankai.me@gmail.com on 2022/8/23 11:39.
 */
public class LC77Combinations {

    // public List<List<Integer>> combine(int n, int k) {
    //     final ArrayList<List<Integer>> ans = new ArrayList<>();
    //     for (int i = 1; i <= n; i++) {
    //         for (int j = i + 1; j <= n; j++) {
    //             for (int x = j + 1; x <= n; x++) {
    //                 List<Integer> item = new ArrayList<>();
    //                 item.add(i);
    //                 item.add(j);
    //                 item.add(x);
    //                 ans.add(item);
    //             }
    //         }
    //     }
    //     return ans;
    // }
    //
    // public int recursion(int n, int k, int i) {
    //     if (k < i) return i;
    //     for (int j = i + 1; j <= n; j++) {
    //         k = recursion(n, --k, j);
    //         if (i != 0) System.out.printf("%d,%d %n", i, j);
    //     }
    //     return k;
    // }

    /**
     * 递归回溯
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.99% 的用户
     * 内存消耗： 42.6 MB , 在所有 Java 提交中击败了 64.90% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/23 16:04.
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        // 从 1 开始是题目的设定
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历可能的搜索起点
        // 优化：分析搜索起点的上界进行剪枝
        // 优化剪枝过程就是：把 i <= n 改成 i <= n - (k - path.size()) + 1
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            System.out.println("递归之前 => " + path);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }

}
