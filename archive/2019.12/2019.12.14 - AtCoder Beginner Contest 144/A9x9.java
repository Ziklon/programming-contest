package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import sun.nio.cs.ext.MacArabic;

public class A9x9 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.readInt(), b = in.readInt();

        if (Math.max(a, b) >= 10) out.printLine(-1);
        else {
            out.printLine(a * b);
        }
    }
}
