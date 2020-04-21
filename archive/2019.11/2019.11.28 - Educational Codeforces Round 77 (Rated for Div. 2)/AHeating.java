package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

public class AHeating {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        for (int i = 0; i < n; ++i) {
            int ci = in.readInt(), si = in.readInt();

            long lower = si / ci;
            long remaind = si % ci;

            long x = IntegerUtils.power(lower, 2) * (ci - remaind);
            long y = IntegerUtils.power(lower + 1, 2) * remaind;

            out.printLine(x + y);
        }
    }
}
