package org.example.hanoi;

import java.util.Stack;

public class HanoiModel {
    private Stack<Integer>[] pegs;
    private int diskNumber;

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

    public boolean move(int from, int to) {
        if (pegs[from].isEmpty()) return false;

        int disk = pegs[from].peek();

        if (!pegs[to].isEmpty() && pegs[to].peek() < disk) {
            return false;
        }

        pegs[from].pop();
        pegs[to].push(disk);
        return true;
    }

    public boolean isSolved() {
        return pegs[2].size() == diskNumber;
    }
}
