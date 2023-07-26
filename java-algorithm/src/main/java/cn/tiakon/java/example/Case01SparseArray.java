package cn.tiakon.java.example;

import java.io.*;
import java.util.ArrayList;

/**
 * 稀疏数组
 * @author tiankai.me@gmail.com on 2019/2/26 17:20..
 */
public class Case01SparseArray {
    public static void main(String[] args) throws IOException {
        int[][] cherssbload = new int[11][11];

        cherssbload[5][6] = 1;
        cherssbload[6][5] = 2;

        ArrayList<Node> sparseArray = new ArrayList<Node>();
        // 用字符串表示稀疏数组
        /**
         * 稀疏数组：
         *
         * 文本中
         * 行数
         * 0    11	11	0
         * 1    2	3	1
         * 2    6	8	2
         * */
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(11).append("\t").append(11).append("\t").append(0).append("\n");
        System.out.println("-> 原始数组...");
        for (int i = 0; i < cherssbload.length; i++) {
            for (int j = 0; j < cherssbload[i].length; j++) {
                if (cherssbload[i][j] != 0) {
                    stringBuffer.append(i).append("\t").append(j).append("\t").append(cherssbload[i][j]).append("\n");
                    sparseArray.add(new Node(i, j, cherssbload[i][j]));
                }
                System.out.printf("%d\t", cherssbload[i][j]);
            }
            System.out.println();
        }
        System.out.println("-> 开始压缩..");
        for (Node node : sparseArray) {
            System.out.println(node.toString());
        }
        System.out.println("-> 开始存盘...");
        String recordStr = "D:\\testdata\\user\\tiakon\\algorithm-base\\java\\Case01SparseArray\\record";
        File recordFile = new File(recordStr);
        FileWriter fileWriter = new FileWriter(recordFile);
        fileWriter.write(stringBuffer.toString(), 0, stringBuffer.toString().length());
        fileWriter.flush();
        fileWriter.close();
        System.out.println("-> 存盘结束...");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(recordFile));
        System.out.println("-> 开始续盘...");
        StringBuffer recordBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            recordBuffer.append(line).append("\n");
        }
        bufferedReader.close();
        String deRecordStr = recordBuffer.toString();
        System.out.println(deRecordStr);
        System.out.println("-> 开始解压...");
        String[] deRecordArray = deRecordStr.split("\n");
        int rowSize = Integer.valueOf(deRecordArray[0].split("\t")[0]);
        int colSize = Integer.valueOf(deRecordArray[0].split("\t")[1]);

        int[][] deCherssArray = new int[rowSize][colSize];

        for (int i = 1; i < deRecordArray.length; i++) {
            int rowNum = Integer.valueOf(deRecordArray[i].split("\t")[0]);
            int colNum = Integer.valueOf(deRecordArray[i].split("\t")[1]);
            int value = Integer.valueOf(deRecordArray[i].split("\t")[2]);
            deCherssArray[rowNum][colNum] = value;
        }

        for (int i = 0; i < deCherssArray.length; i++) {
            for (int j = 0; j < deCherssArray[i].length; j++) {
                System.out.printf("%d\t", deCherssArray[i][j]);
            }
            System.out.println();
        }
    }
}

class Node {
    private int row;
    private int col;
    private int value;

    public Node() {
    }

    public Node(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return row + "\t" + col + "\t" + value;
    }
}
