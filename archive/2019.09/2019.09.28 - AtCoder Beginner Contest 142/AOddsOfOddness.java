package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AOddsOfOddness {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();

        double odd = (n + 1) / 2;

        out.printLine(odd/n);

    }
}
