package cn.tiakon.java.example;

import java.util.Arrays;
import java.util.List;

/**
 * 最大逆向分词
 *
 * @author tiankai.me@gmail.com on 2022/2/11 18:25.
 */
public class Case02MaxReverseParticiple {

    private static String[] sentences = {"南京市长江大桥欢迎您", "计算语言学课程有意思", "java是世界第一计算机编程语言", "开发者搜索Beta让技术搜索更简单高效", "你中午准备吃什么？"};
    private static String[] dict = {"南京", "南京市", "长江大桥", "大桥", "市长", "江大桥", "南京市", "欢迎您", "欢迎", "您", "计算",
            "计算语言学", "课程", "有", "意思", "java", "java是", "世界第一", "计算机编程", "语言", "开发者搜索", "开发者", "Beta", "让技术搜索", "技术搜索", "更简单高效"};
    private static int maxSplitSize = 5;

    public static void main(String[] args) {
        for (int i = 0; i < sentences.length; i++) {
            String currentSentence = sentences[i];
            System.out.printf(" sentence: %s %n max dict word: %n", currentSentence);
            splitSentence(currentSentence);
            System.out.println("--------------------------");
            maxSplitSize = 5;
        }
    }

    public static String splitSentence(String currentSentence) {
        int length = currentSentence.length();
        currentSentence = currentSentence.substring(0, length - splitStringBySize(currentSentence).length());
        int newLength = currentSentence.length();
        return length != 0 && length > newLength ? splitSentence(currentSentence) : "";
    }

    public static String splitStringBySize(String sentence) {
        if (sentence.length() < maxSplitSize) {
            maxSplitSize = sentence.length();
        }
        String maxSplitStr = sentence.substring(sentence.length() - maxSplitSize);
        String dictWord = recursion(maxSplitStr);
        System.out.println(" " + dictWord);
        return dictWord;
    }

    public static String recursion(String subString) {
        if (!subString.isEmpty()) {
            return getMaxDictWord(subString) ? subString : recursion(subString.substring(1));
        } else return "";
    }

    public static Boolean getMaxDictWord(String subString) {
        return Arrays.stream(dict).filter(subString::equals).toArray().length > 0;
    }

}
