package cn.tiakon.java.leetcode.simulation;


import org.junit.Assert;
import org.junit.Test;

/**
 * 1678. 设计 Goal 解析器
 * https://leetcode.cn/problems/goal-parser-interpretation/
 *
 * @author tiankai.me@gmail.com on 2022/11/7 下午3:36.
 */
public class LC1678GoalParserInterpretation {
    /**
     * G    -> G
     * ()   -> o
     * (al) -> al
     * G()()()()(al)
     *
     * @author tiankai.me@gmail.com on 2022/11/7 下午3:45.
     */
    public String interpret(String command) {
        StringBuffer buffer = new StringBuffer();
        char[] chars = new char[4];
        int i = 0;
        for (char c : command.toCharArray()) {
            if (c == 'G') buffer.append(c);
            else if (c == ')') {
                chars[i] = c;
                buffer.append(getValue(chars));
                chars = new char[4];
                i = 0;
            } else chars[i++] = c;
        }
        return buffer.toString();
    }

    public String getValue(char[] chars) {
        String s;
        switch (String.valueOf(chars).trim()) {
            case "()":
                s = "o";
                break;
            case "(al)":
                s = "al";
                break;
            default:
                s = "";
        }
        return s;
    }

    public String interpretV2(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == 'G') {
                sb.append('G');
                i++;
            } else if (i + 1 < n && s.charAt(i + 1) == ')') {
                sb.append('o');
                i += 2;
            } else {
                sb.append("al");
                i += 4;
            }
        }
        return sb.toString();
    }

    @Test
    public void interpretTest() {
        LC1678GoalParserInterpretation goalParserInterpretation = new LC1678GoalParserInterpretation();
        String command = "G()(al)";
        String ans = goalParserInterpretation.interpret(command);
        Assert.assertEquals("Goal", ans);

        command = "G()()()()(al)";
        ans = goalParserInterpretation.interpret(command);
        Assert.assertEquals("Gooooal", ans);

        command = "(al)G(al)()()G";
        ans = goalParserInterpretation.interpret(command);
        Assert.assertEquals("alGalooG", ans);
    }

}
