package cn.tiakon.java.zbook.chapter01.example07;

import cn.tiakon.java.utils.MathRandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;

/**
 * 生成窗口最大值数组
 * 1. 输入 长度为n的数组，宽度为w，输出窗口内最大值的数组
 * 2. 最大值数组长度 = n-w+1
 *
 * @author tiankai.me@gmail.com on 2022/6/30 15:44.
 */
public class WindowsMaxValue {

    // 时间复杂度：O(N*W)
    public static int[] getWindowsMaxValueArray01(int[] arr, int width) {
        if (arr == null || width < 1 || arr.length < width) {
            return null;
        }
        int windowsMaxValueArraySize = arr.length - width + 1;
        final int[] maxArr = new int[windowsMaxValueArraySize];
        int step = width - 1;
        for (int i = 0; i < maxArr.length; i++) {
            maxArr[i] = getWindowsMaxValue(arr, i, i + step);
        }
        return maxArr;
    }

    private static int getWindowsMaxValue(int[] arr, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > arr.length) {
            throw new RuntimeException("error! startIndex less than 0 or endIndex more than arr.length");
        }
        int maxValue = arr[startIndex];
        for (int i = startIndex; i <= endIndex; i++) {
            // if (arr[i] > maxValue) {
            //     maxValue = arr[i];
            // }
            maxValue = Math.max(arr[i], maxValue);
        }
        return maxValue;
    }

    /**
     * 时间复杂度：O(N)
     * 1.利用双端队列，将队列中小于数组的数弹出，将队头作为最大值，在遍历数组时，将下标加入队列
     * 2.计算队头下标，检查是否过期（x=i-w）
     * 3.将对头放入结果数组中
     *
     * @author tiankai.me@gmail.com on 2022/7/4 14:53.
     */
    public static int[] getWindowsMaxValueArray02(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        final LinkedList<Integer> qmax = new LinkedList<>();
        final int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // 一旦数组中的数大于队列中的数，就将队列中的数全部弹出，确保队头最大
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            // 检查队头下标是否过期
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            // 取队头作为窗口最大值
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    @Test
    public void getWindowsMaxValueArrayTest() {
        final int[] randomArray = MathRandomUtil.createRandomArray(10, 10);
        final int[] windowsMaxValueArray01 = WindowsMaxValue.getWindowsMaxValueArray01(randomArray, 3);
        final int[] windowsMaxValueArray02 = WindowsMaxValue.getWindowsMaxValueArray02(randomArray, 3);
        MathRandomUtil.printArray(randomArray);
        MathRandomUtil.printArray(windowsMaxValueArray01);
        MathRandomUtil.printArray(windowsMaxValueArray02);
        Assert.assertArrayEquals(windowsMaxValueArray01, windowsMaxValueArray02);
    }

    @Test
    public void getWindowsMaxValueArray02Test() {
        int testCount = 10000;
        for (int i = 0; i < testCount; i++) {
            final Random random = new Random();
            int lengthMax = random.nextInt(100) + 1;
            int valueMax = random.nextInt(100);
            final int[] randomArray = MathRandomUtil.createRandomArray(lengthMax, valueMax);
            final int[] windowsMaxValueArray01 = WindowsMaxValue.getWindowsMaxValueArray01(randomArray, 3);
            final int[] windowsMaxValueArray02 = WindowsMaxValue.getWindowsMaxValueArray02(randomArray, 3);
            Assert.assertArrayEquals(windowsMaxValueArray01, windowsMaxValueArray02);
        }

    }

}
