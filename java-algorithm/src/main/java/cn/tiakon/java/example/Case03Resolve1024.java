package cn.tiakon.java.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.cn/circle/discuss/Tf0j5K/
 *
 * @author tiankai.me@gmail.com on 2022/10/20 下午1:55.
 */
public class Case03Resolve1024 {
    private static int calcOnce(int left, int right, String op) throws Exception {
        int ret = 0;
        switch (op) {
            case "+":
                ret = left + right;
                break;
            case "-":
                ret = left - right;
                break;
            case "*":
                ret = left * right;
                break;
            case "**":
                ret = (int) Math.pow((double) left, (double) right);
                break;
            case "%":
                ret = left % right;
                break;
            case "//":
                ret = left / right;
                break;
            case "|":
                ret = left | right;
                break;
            case "&":
                ret = left & right;
                break;
            case "^":
                ret = left ^ right;
                break;
            case "<<":
                ret = left << right;
                break;
            case ">>":
                ret = left >> right;
                break;
            default:
                throw new Exception("非法的运算符号" + op);
        }
        return ret;
    }

    // 递归地求出list中size个数的所有排列
    private static List<LinkedList<Integer>> permute(LinkedList<Integer> list, int size) {
        List<LinkedList<Integer>> ret = new ArrayList<>();
        if (size == 1) {
            for (int num : list) {
                LinkedList<Integer> tl = new LinkedList<>();
                tl.add(num);
                ret.add(tl);
            }
            return ret;
        }
        int times = 0;
        while (times++ < list.size()) {
            int head = list.removeFirst();
            for (LinkedList<Integer> rest : permute(list, size - 1)) {
                rest.addFirst(head);
                ret.add(rest);
            }
            list.add(head);
        }
        return ret;
    }

    public static void calc(int[] nums, String[] ops) throws Exception {
        LinkedList<Integer> numIds = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) numIds.add(i);
        LinkedList<Integer> opIds = new LinkedList<>();
        for (int i = 0; i < ops.length; i++) opIds.add(i);

        List<LinkedList<Integer>> numPms = permute(numIds, 4);
        List<LinkedList<Integer>> opPms = permute(opIds, 3);

        for (LinkedList<Integer> numPm : numPms) {
            for (LinkedList<Integer> opPm : opPms) {
                Iterator<Integer> numIt = numPm.iterator();
                Iterator<Integer> opIt = opPm.iterator();
                int ret = nums[numIt.next()];
                StringBuilder sb = new StringBuilder();
                sb.append(ret);
                try {
                    while (numIt.hasNext()) {
                        int right = nums[numIt.next()];
                        String op = ops[opIt.next()];
                        sb.append(" ");
                        sb.append(op);
                        sb.append(" ");
                        sb.append(right);
                        ret = calcOnce(ret, right, op);
                    }
                } catch (Exception e) {
                    ret = 0;
                }

                if (ret == 1024) {
                    sb.append(" = 1024");
                    System.out.println(sb);
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
//        int[] nums = {32, 9, 31, 9, 2, 30, 32, 2, 0, 2, 2}; //在这里填写你拥有的数字牌
//        String[] ops = {">>", "*", "&", "|"};// 在这里填写你拥有的运算符牌
        //在这里填写你拥有的数字牌
        int[] nums = {5, 15, 14, 955, 0, 5, 7};
        // 在这里填写你拥有的运算符牌
        String[] ops = {">>", ">>", ">>"};
        Set<String> allOps = new HashSet<>(Arrays.asList("+", "-", "*", "**", "%", "//", "|", "&", "^", "<<", ">>"));
        Set<String> myOpSet = new HashSet<>(Arrays.asList(ops));
        myOpSet.removeAll(allOps);
        if (!myOpSet.isEmpty()) throw new RuntimeException("非法的操作符，请检查拼写");
        if (nums.length < 4 || ops.length < 3) throw new RuntimeException("卡牌不足，加油搜集！");
        calc(nums, ops);
    }

    @Test
    public void mathTest() {
        Assert.assertEquals(31, 15 ^ 16);
        // ((0%2)-32)^2
        Assert.assertEquals(1024, Math.pow(((0%2)-32),2),0);
        //**
        Assert.assertEquals(1024.0, Math.pow(32, 2), 0);
    }
}
