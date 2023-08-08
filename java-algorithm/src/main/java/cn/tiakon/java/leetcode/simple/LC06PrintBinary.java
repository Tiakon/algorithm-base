package cn.tiakon.java.leetcode.simple;

public class LC06PrintBinary {

    public static void main(String[] args) {
        int num = 8569856;
        printBinary(num);
    }

    private static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

}
