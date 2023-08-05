package cn.tiakon.java.leetcode.math;

/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 * https://leetcode.cn/problems/average-salary-excluding-the-minimum-and-maximum-salary
 *
 * @author tiankai.me@gmail.com on 2022/11/3 下午3:20.
 */
public class LC1491AverageSalary {
    public double average(int[] salary) {
        int max = 999, min = 100001, sum = 0;
        for (int i : salary) {
            max = Math.max(max, i);
            min = Math.min(min, i);
            sum += i;
        }
        return (double) (sum - min - max) / (salary.length - 2);
    }
}
