package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ABadUglyNumbers {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();

        if (n == 1) out.printLine(-1);
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(2);
            for (int i = 0; i + 1 < n; ++i) sb.append(3);
            out.printLine(sb.toString());
        }
    }
}
