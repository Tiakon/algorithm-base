package cn.tiakon.java.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1656. 设计有序流
 * https://leetcode.cn/problems/design-an-ordered-stream/
 *
 * @author tiankai.me@gmail.com on 2022/8/16 13:10.
 */
public class LC1656DesignOrderedStream {

    /**
     * 执行用时： 69 ms , 在所有 Java 提交中击败了 98.39% 的用户
     * 内存消耗： 42.7 MB , 在所有 Java 提交中击败了 53.01% 的用户
     *
     * @author tiankai.me@gmail.com on 2022/8/16 17:43.
     */
    public static class OrderedStream {
        final String[] nodes;
        int prt;

        public OrderedStream(int n) {
            nodes = new String[n];
            prt = 0;
        }

        // 模拟流程
        // 插入流程：
        // 1. 创建节点后，根据id映射到对应下标的数组，注意idKey从1开始，需要减1。
        // 2. 当指针与插入ID相等时，遍历该id之后的数组，保存结果到ArrayList中。
        // 执行用时： 72 ms, 在所有 Java 提交中击败了 69.88%的用户
        // 内存消耗： 43.2 MB, 在所有 Java 提交中击败了 5.22%的用户
        public List<String> insert(int idKey, String value) {
            List<String> ans = new ArrayList<>();
            if (value.length() == 5) {
                nodes[idKey - 1] = value;
            }
            if (prt == idKey - 1) {
                while (prt < nodes.length && nodes[prt] != null) {
                    ans.add(nodes[prt++]);
                }
            }
            return ans;
        }
    }

    // https://leetcode.cn/problems/design-an-ordered-stream/solution/by-ac_oier-5pe8/
    public static class OrderedStreamV2 {
        String[] arr;
        int prt;

        public OrderedStreamV2(int n) {
            arr = new String[1000];
            // 数组默认值使用""填充
            Arrays.fill(arr, "");
            prt = 1;
        }

        public List<String> insert(int key, String value) {
            arr[key] = value;
            List<String> ans = new ArrayList<>();
            // prt位置有值，才打印数组中连续的结果。
            while (arr[prt].length() == 5) {
                ans.add(arr[prt++]);
            }
            return ans;
        }
    }

}
