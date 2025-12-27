package org.example.hanoi;

import java.util.Stack;

public class HanoiModel {
    public Stack<Integer>[] pegs;
    public int diskNumber;

    public HanoiModel(int n) {
        pegs = new Stack[3];
        for (int i = 0; i < 3; i++) pegs[i] = new Stack<>();
        reset(n);
    }

    public void reset(int number) {
        diskNumber = number;
        for (int i = 0; i < 3; i++) pegs[i].clear();
        for (int d = number; d >= 1; d--) pegs[0].push(d);
    }

    public int getDiskNumber() { return diskNumber; }
    public Stack<Integer>[] getPegs() { return pegs; }

}
