package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ACards {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        char[] s = in.readString().toCharArray();
        int[] counter = new int[256];
        for (char c : s) counter[c]++;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < counter['n']; ++i) sb.append("1 ");
        for (int i = 0; i < counter['z']; ++i) sb.append("0 ");

        out.printLine(sb.toString().trim());
    }
}
