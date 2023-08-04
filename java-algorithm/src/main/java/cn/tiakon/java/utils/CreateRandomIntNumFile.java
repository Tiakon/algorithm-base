package cn.tiakon.java.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tiankai.me@gmail.com on 2022/2/16 12:00.
 */
public class CreateRandomIntNumFile {
    public static void createRandomIntNumFile() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        String todayInMinute = format.format(new Date());
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            boolean bool = dataDir.mkdirs();
            System.out.printf(">> data dir is not exist. mkdir is :%b %n", bool);
        }
        String fileName = "data".concat(File.separator).concat(todayInMinute.concat("-20w.txt"));
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        int randomNum = 2000000;
        for (int i = 0; i < randomNum; i++) {
            // 四舍五入一个长整型
            bufferedWriter.write(Math.round(Math.random() * 1000) + "\r\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static void main(String[] args) {
        try {
            createRandomIntNumFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}