package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ACurtain {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.readInt(), b = in.readInt();
        out.printLine(Math.max(0, a - b * 2 ));
    }
}
