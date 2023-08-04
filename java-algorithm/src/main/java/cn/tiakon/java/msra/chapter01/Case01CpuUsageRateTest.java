package cn.tiakon.java.msra.chapter01;

import org.junit.Test;

/**
 * win7 任务管理器在一个刷新周期内，CPU忙（执行应用程序）的时间和刷新周期总时间的比率，就是CPU的占用率。
 * 任务管理器中显示的是每个刷新周期内CPU占用率的统计平均值，通过调节忙闲的比例，控制任务管理器中的CPU占用率。
 * @author tiankai.me@gmail.com on 2022/8/1 22:48.
 */
public class Case01CpuUsageRateTest {

    /**
     * 得到每个时钟周期执行的代码行数
     *
     * @author tiankai.me@gmail.com on 2022/8/3 0:02.
     */
    public void getCodeRowNumPerClockPeriod() {
        int i = 0;
        while (true) {
            i++;
        }
    }

    /**
     * CPU曲线成直线
     * 单核 cpu 100%
     * 多核 cpu 1/8 = 12.5 %
     *
     * @author tiankai.me@gmail.com on 2022/8/3 0:07.
     */
    @Test
    public void CPU01Test() {
        int i = 0;
        while (true) {
            i++;
        }
    }

    /**
     * CPU曲线成直线
     * 单核 cpu 50%
     * 多核 cpu 1/16 = 6.25 %
     *
     * @author tiankai.me@gmail.com on 2022/8/3 0:07.
     */
    @Test
    public void CPU02Test() throws InterruptedException {
        // cpu 时钟频率 = 2.7gHz 每秒
        double osClockPeriod = 2.7 * 1000 * 1000 * 1000;
        // 平均每个时钟频率执行的代码行数
        int avgCodeRowPerClockPeriod = 4;
        // for (int i = 0; i < n; i++) {} 对应5行汇编代码
        // 1秒执行多少次空的for循环，除以100，降低两个数量级、同时设置休眠时间为10毫秒，防止休眠时间过长导致曲线成锯齿状
        long n = (long) osClockPeriod * avgCodeRowPerClockPeriod / 5 / 100;
        for (; ; ) {
            for (int i = 0; i < n; i++) {
            }
            Thread.sleep(10);
        }
    }

    /**
     * CPU曲线成锯齿状
     * 默认 win7 任务管理器普通1秒更新一次。
     * 单核 cpu 50%
     * 多核 cpu 1/16 = 6.25 %
     *
     * @author tiankai.me@gmail.com on 2022/8/3 0:07.
     */
    @Test
    public void CPU03Test() throws InterruptedException {
        // cpu 时钟频率 = 2.7gHz 每秒
        double osClockPeriod = 2.7 * 1000 * 1000 * 1000;
        // 平均每个时钟频率执行的汇编代码行数
        int avgCodeRowPerClockPeriod = 2;
        // for (int i = 0; i < n; i++) {} 对应5行汇编代码
        // 1秒执行多少次空的for循环
        long n = (long) (osClockPeriod * avgCodeRowPerClockPeriod / 5);
        for (; ; ) {
            for (int i = 0; i < n; i++) {
            }
            Thread.sleep(1000);
        }
    }

    /**
     * 多核CPU环境，让CPU使用率到达 50%
     *
     * @author tiankai.me@gmail.com on 2022/8/2 23:49.
     */
    @Test
    public void CpuUsageRateRunnable01Test() {
        Thread t1 = new Thread(new CpuUsageRateRunnable());
        Thread t2 = new Thread(new CpuUsageRateRunnable());
        Thread t3 = new Thread(new CpuUsageRateRunnable());
        Thread t4 = new Thread(new CpuUsageRateRunnable());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CpuUsageRateRunnable implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
        }
    }
}




