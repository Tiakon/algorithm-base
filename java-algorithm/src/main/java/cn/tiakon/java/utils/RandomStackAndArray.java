package cn.tiakon.java.utils;

import java.util.Stack;

public class RandomStackAndArray {
    private Stack<Integer> randomStack;
    private int[] randomArray;

    public RandomStackAndArray(Stack<Integer> randomStack, int[] randomArray) {
        this.randomStack = randomStack;
        this.randomArray = randomArray;
    }

    public Stack<Integer> getRandomStack() {
        return randomStack;
    }

    public int[] getRandomArray() {
        return randomArray;
    }
}
