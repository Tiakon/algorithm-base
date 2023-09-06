package cn.tiakon.java.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class LC640SolveTheEquationTest {

    @Test
    public void solveEquationTest() {
        final LC640SolveTheEquation lc640SolveTheEquation = new LC640SolveTheEquation();

        String equation = "x+5-3+x=6+x-2";
        String ans = lc640SolveTheEquation.solveEquation(equation);
        Assert.assertEquals("x=2", ans);

        equation = "2x+5-3+x=6+2x-2";
        ans = lc640SolveTheEquation.solveEquation(equation);
        Assert.assertEquals("x=2", ans);

        equation = "x=x";
        ans = lc640SolveTheEquation.solveEquation(equation);
        Assert.assertEquals("Infinite solutions", ans);

        equation = "2x=1";
        ans = lc640SolveTheEquation.solveEquation(equation);
        Assert.assertEquals("No solution", ans);

        equation = "2x=x";
        ans = lc640SolveTheEquation.solveEquation(equation);
        Assert.assertEquals("x=0", ans);

        equation = "2x+3x-6x=x+2";
        ans = lc640SolveTheEquation.solveEquation(equation);
        Assert.assertEquals("x=-1", ans);

        equation = "3x=33+22+11";
        ans = lc640SolveTheEquation.solveEquation(equation);
        Assert.assertEquals("x=22", ans);
    }

    @Test
    public void solveEquationBenchTest(){

    }

}
