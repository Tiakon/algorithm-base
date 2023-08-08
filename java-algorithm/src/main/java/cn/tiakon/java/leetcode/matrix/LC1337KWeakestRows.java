package cn.tiakon.java.leetcode.matrix;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/the-k-weakest-rows-in-a-matrix">1337. 矩阵中战斗力最弱的 K 行</a>
 *
 * @author tiankai.me@gmail.com on 2022/12/8 下午5:10.
 */
public class LC1337KWeakestRows {
    /**
     * 暴力破解+排序
     * <p>
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 54.19% 的用户
     * 内存消耗： 42.4 MB , 在所有 Java 提交中击败了 73.94% 的用户
     * 通过测试用例： 52 / 52
     *
     * @author tiankai.me@gmail.com on 2022/12/8 下午6:06.
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] arr = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) break;
                ++count;
            }
            arr[i][0] = i;
            arr[i][1] = count;
        }
        // 基于二维数组某列排序
        // Arrays.sort(arr,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1][1] > arr[j][1]) {
                    int[] temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i][0];
        }
        return ans;
    }

    public int[] kWeakestRowsV2(int[][] mat, int k) {
        int[] list = new int[mat.length];
        int[] result = new int[k];
        for (int i = 0; i < mat.length; i++) {
            list[i] = count(mat[i]) * 100 + i;
        }
        Arrays.sort(list);
        for (int i = 0; i < k; i++) {
            result[i] = list[i] % 100;
        }
        return result;
    }

    public int count(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            if (n != 1) break;
            sum += n;
        }
        return sum;
    }

    public int[] kWeakestRowsV3(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        List<int[]> power = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int l = 0, r = n - 1, pos = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (mat[i][mid] == 0) r = mid - 1;
                 else {
                    pos = mid;
                    l = mid + 1;
                }
            }
            power.add(new int[]{pos + 1, i});
        }
        // 最小值栈
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                if (pair1[0] != pair2[0]) return pair1[0] - pair2[0];
                 else return pair1[1] - pair2[1];
            }
        });
        for (int[] pair : power) {
            pq.offer(pair);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = pq.poll()[1];
        }
        return ans;
    }
}
