package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ABiscuitGenerator {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.readInt(), b = in.readInt(), c = in.readInt();

        int sum = 0;

        for (int i = 1; i <= c; ++i) {
            if (i % a == 0)
                sum += b;
        }
        out.printLine(sum);
    }
}
