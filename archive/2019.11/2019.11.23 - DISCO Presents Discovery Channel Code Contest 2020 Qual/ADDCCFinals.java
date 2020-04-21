package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ADDCCFinals {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int[] s = in.readIntArray(2);
        int[] p = {300000, 200000, 100000};
        int sum = 0;

        for (int si : s) {
            if (si <= 3) sum += p[si - 1];
        }

        if (sum == p[0] * 2) sum += 400000;
        out.printLine(sum);
    }
}
