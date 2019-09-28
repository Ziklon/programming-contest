package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class DModSum {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n = in.readInt();

        out.printLine(n * (n - 1)/2);
    }
}
