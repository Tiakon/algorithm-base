package cn.tiakon.java.zbook.chapter01.example06;

import org.junit.Test;

import java.util.Stack;

/**
 * 用栈来求解汉诺塔问题
 * 1. 把塔从左移动到右
 * 2. 不能从最左侧直接移动到最右侧，也不能直接从最右侧移动到最左侧，必须经过中间。
 * 打印最优移动过程和最优移动总步数
 *
 * @author tiankai.me@gmail.com on 2022/6/30 14:13.
 */
public class HanoiProblem {

    /**
     * @param num   塔的层数
     * @param left  左塔名称
     * @param mid   中塔名称
     * @param right 右塔名称
     * @author tiankai.me@gmail.com on 2022/6/30 14:50.
     */
    public int hanoiProblem1(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    /**
     * @param num   塔的层数
     * @param left  左塔名称
     * @param mid   中塔名称
     * @param right 右塔名称
     * @param from  当前位置
     * @param to    目标位置
     * @author tiankai.me@gmail.com on 2022/6/30 14:50.
     */
    private int process(int num, String left, String mid, String right, String from, String to) {
        // 1 层塔 ， 边界条件
        if (num == 1) {
            // 上一步是 中 或下一步是中
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

    @Test
    public void hanoiProblem1Test() {
        final HanoiProblem hanoiProblem = new HanoiProblem();
        final int i = hanoiProblem.hanoiProblem1(3, "left", "mid", "right");
        System.out.printf("Total step: %d %n", i);
    }

    @Test
    public void hanoiProblem2Test() {
        final HanoiProblem hanoiProblem = new HanoiProblem();
        final int i = hanoiProblem.hanoiProblem2(19, "left", "mid", "right");
        System.out.printf("Total step: %d %n", i);
    }

    enum Action {
        No, LToM, MToL, MToR, RToM
    }

    public int hanoiProblem2(int num, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<Integer>();
        Stack<Integer> mS = new Stack<Integer>();
        Stack<Integer> rS = new Stack<Integer>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--) {
            lS.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rS.size() != num + 1) {
            step += fStackTotStack(record, Action.MToL, Action.LToM, lS, mS, left, mid);
            step += fStackTotStack(record, Action.LToM, Action.MToL, mS, lS, mid, left);
            step += fStackTotStack(record, Action.RToM, Action.MToR, mS, rS, mid, right);
            step += fStackTotStack(record, Action.MToR, Action.RToM, rS, mS, right, mid);
        }
        return step;
    }

    public int fStackTotStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fStack, Stack<Integer> tStack, String from, String to) {
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move " + tStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }


}


