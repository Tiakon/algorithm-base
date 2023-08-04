package cn.tiakon.java.utils;

import cn.tiakon.java.leetcode.datastructure.ListNode;

import java.util.*;

/**
 * 对数器的定义:
 * 生成一个随机样本，测试算法是否正确
 * <p>
 * 对数器的使用：
 * 1.有一个你想要测的方法a；
 * 2.实现一个绝对正确但是复杂度不好的方法b；
 * 3.实现一个随机样本产生器；
 * 4.实现对比算法a和b的方法；
 * 5.把方法a和方法b比对多次来验证方法a是否正确；
 * 6.如果有一个样本使得比对出错，打印样本分析是哪个方法出错；
 * 7.当样本数量很多时比对测试依然正确，可以确定方法a已经正确。
 *
 * @author tiankai.me@gmail.com on 2022/2/16 16:41.
 */
public class MathRandomUtil {

    private static final Random random = new Random();

    private MathRandomUtil() {
    }

    public static int[] createRandomArray(int length, int maxValue) {
        return createRandomArray(length, maxValue, false);
    }

    /**
     * 1.创建长度为 length的随机数组<br>
     * 2.数组中值的取值范围在[-maxValue,+maxValue]
     *
     * @author tiankai.me@gmail.com on 2022/3/14 21:58.
     */
    public static int[] createRandomArray(int length, int maxValue, boolean isPositive) {
        if (length == 0) {
            // throw new MathRandomUtilException("The array length can't be zero.");
            return new int[0];
        }
        int[] arr1 = new int[length];
        for (int i = 0; i < arr1.length; i++) {
            if (isPositive) {
                // maxValue -> [0,maxValue]
                arr1[i] = random.nextInt(maxValue + 1);
            } else {
                // maxValue -> [-maxValue,+maxValue]
                arr1[i] = maxValue == 0 ? 0 : (random.nextInt(maxValue + 1) * (random.nextInt() > 0.5 ? 1 : -1));
            }
        }
        return arr1;
    }

    /**
     * 创建长度为 length ,只包含0和1的随机数组
     *
     * @author tiankai.me@gmail.com on 2022/8/14 7:19.
     */
    public static int[] createRandomArrayWithZeroAndOne(int length) {
        if (length == 0) {
            return new int[0];
        }
        int[] arr1 = new int[length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt() > 0.5 ? 1 : 0;
        }
        return arr1;
    }

    /**
     * 创建按升序排序的随机数组
     *
     * @author tiankai.me@gmail.com on 2022/3/14 21:58.
     */
    public static int[] createRandomArrayWithSorted(int length, int maxValue) {
        int[] array = createRandomArray(length, maxValue);
        Arrays.sort(array);
        return array;
    }

    /**
     * 得到随机不重复数组
     *
     * @author tiankai.me@gmail.com on 2022/7/4 15:19.
     */
    public static int[] getNonRepeatArray(int length, int maxValue) {
        final int[] randomArray = createRandomArray(length, maxValue);
        return Arrays.stream(randomArray).distinct().toArray();
    }

    /**
     * 得到按升序排序的随机不重复数组
     *
     * @author tiankai.me@gmail.com on 2022/7/4 15:19.
     */
    public static int[] getNonRepeatArrayForSorted(int length, int maxValue) {
        final int[] randomArray = createRandomArray(length, maxValue);
        final int[] array = Arrays.stream(randomArray).distinct().toArray();
        Arrays.sort(array);
        return array;
    }

    /**
     * 创建随机非递减数组
     *
     * @author tiankai.me@gmail.com on 2022/8/9 16:44.
     */
    public static int[] createRandomArrayWithNonDecreasing(int length, int maxValue) {
        final int[] randomArray = createRandomArray(length, maxValue);
        Arrays.sort(randomArray);
        return randomArray;
    }

    /**
     * 指定最大值与最大长度得到随机不重复数组
     *
     * @author tiankai.me@gmail.com on 2022/8/7 20:46.
     */
    public static int[] createNonRepeatArray(int length, int maxValue) {
        final int[] arr = new int[length];
        final boolean[] booleans = new boolean[maxValue];
        for (int i = 0; i < arr.length; i++) {
            do {
                arr[i] = random.nextInt(maxValue);
            } while (booleans[arr[i]]);
            booleans[arr[i]] = true;
        }
        return arr;
    }

    /**
     * 创建随机数组，满足一下条件：
     * - 数组无序。
     * - 数组内任意两个相邻的数不等。
     *
     * @author tiankai.me@gmail.com on 2022/3/14 21:58.
     */
    public static int[] getRandomArrayWithNotEquals(int length, int maxValue) {
        if (length == 0 || maxValue == 0) {
            return new int[0];
        }
        int[] arr = new int[length];
        arr[0] = random.nextInt(maxValue);
        for (int i = 1; i < arr.length; i++) {
            do {
                arr[i] = random.nextInt(maxValue);
            } while (arr[i] == arr[i - 1]);
        }
        return arr;
    }

    /**
     * 复制一份新的数组
     *
     * @author tiankai.me@gmail.com on 2022/3/14 21:58.
     */
    public static int[] copyArray(int[] arr1) {
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        return arr2;
    }

    /**
     * 判断两组数组的内容
     *
     * @author tiankai.me@gmail.com on 2022/3/14 21:58.
     */
    public static boolean compareArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println("");
    }

    public static RandomStackAndArray getRandomStackAndArray(int lenMax, int valueMax) {
        final int[] randomArray = createRandomArray(lenMax, valueMax);
        final Stack<Integer> stack = new Stack<>();
        for (int i : randomArray) {
            stack.push(i);
        }
        return new RandomStackAndArray(stack, randomArray);
    }

    public static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.printf("%d ", stack.pop());
        }
        System.out.println("");
    }

    public static int[] getNonRepeatOrderedArray() {
        int lenMax = 100;
        int maxValue = 100;
        final Random random = new Random();
        final int arrLen = random.nextInt(lenMax);
        final Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < arrLen; i++) {
            sets.add(random.nextInt(maxValue));
        }
        return Arrays.stream(sets.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 打印二维数组
     *
     * @author tiankai.me@gmail.com on 2022/7/5 16:56.
     */
    public static void print2DArray(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.printf("%d ", ints[i][j]);
            }
            System.out.println("");
        }
        System.out.println("------------------------------");
    }

    /**
     * 随机创值为0或1的二维数组
     *
     * @author tiankai.me@gmail.com on 2022/7/24 16:26.
     */
    public static int[][] create2DRandomArrayWithZeroAndOne(int row, int column) {
        int[][] arr2d = new int[row][column];
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                arr2d[i][j] = Math.random() > 0.5 ? 1 : 0;
            }
        }
        return arr2d;
    }

    /**
     * 指定行列最大值，创建二维数据, 值的取值范围 [-maxValue,maxValue]
     *
     * @author tiankai.me@gmail.com on 2022/7/24 16:26.
     */
    public static int[][] create2DRandomArrayForSpecified(int row, int column, int maxValue) {
        int[][] arr2d = new int[row][column];
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                arr2d[i][j] = maxValue == 0 ? 0 : (random.nextInt(maxValue) * (random.nextInt() > 0.5 ? 1 : -1));
            }
        }
        return arr2d;
    }

    /**
     * 打印环形数组
     *
     * @author tiankai.me@gmail.com on 2022/7/28 15:04.
     */
    public void printCircularArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print(j);
            }
            for (int j = 0; j < i; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }

    private static void loopPrintRandomArrayWithSorted() {
        for (int i = 0; i < 100; i++) {
            // [4,10]
            int length = random.nextInt(7) + 4;
            // [10,100]
            int valueMax = random.nextInt(91) + 10;
            final int[] arrayWithSorted = MathRandomUtil.createRandomArrayWithSorted(length, valueMax);
            MathRandomUtil.printArray(arrayWithSorted);
        }
    }

    /**
     * 随机创建方程式
     * 3 <= equation.length <= 1000
     * equation 只有一个 '='.
     * 方程由绝对值在 [0, 100]  范围内且无任何前导零的整数和变量 'x' 组成。
     *
     * @author tiankai.me@gmail.com on 2022/8/11 15:10.
     */
    public String createRandomEquation() {
        char[] chars = new char[]{'=', '+', '-', 'x', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int index = random.nextInt(chars.length);


        return "";
    }

    /**
     * 打印链表
     *
     * @author tiankai.me@gmail.com on 2022/8/19 18:59.
     */
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
        System.out.println("");
    }

    public static String listToString(List list) {
        final StringBuilder builder = new StringBuilder();
        for (Object o : list) {
            builder.append(",").append(o);
        }
        return builder.toString().replaceFirst(",", "");
    }

    public static String listNodeToString(ListNode head) {
        return listNodeToString(head, "");
    }

    /**
     * 将链表转字符串。
     *
     * @author tiankai.me@gmail.com on 2022/8/19 19:01.
     */
    public static String listNodeToString(ListNode head, String separator) {
        final StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(separator).append(head.val);
            head = head.next;
        }
        return builder.toString().replaceFirst(separator, "");
    }

    /**
     * 指定长度，创建随机链表。
     *
     * @author tiankai.me@gmail.com on 2022/8/15 20:55.
     */
    public static ListNode createRandomListNode(int length, int maxValue) {
        ListNode head = new ListNode(random.nextInt(maxValue) + 1);
        for (int i = 0; i < length - 1; i++) {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(random.nextInt(maxValue) + 1);
        }
        return head;
    }

    public static void main(String[] args) {
        int ops = 2;
        switch (ops) {
            case 0:
                print2DArray(create2DRandomArrayWithZeroAndOne(5, 6));
                break;
            case 1:
                loopPrintRandomArrayWithSorted();
                break;
            case 2: {
                ListNode randomListNode = createRandomListNode(10, 10);
                while (randomListNode != null) {
                    System.out.print(randomListNode.val + " ");
                    randomListNode = randomListNode.next;
                }
            }
            default:
                break;
        }
    }

}



