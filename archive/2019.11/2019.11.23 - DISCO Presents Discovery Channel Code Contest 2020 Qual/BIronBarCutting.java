package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BIronBarCutting {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] s = in.readIntArray(n);

        long sum = 0;
        for (int e : s) sum += e;

        long preffix = 0;

        long ans = Long.MAX_VALUE;

        for (int e : s) {
            preffix += e;
            long suffix = sum - preffix;
            ans = Math.min(ans, Math.abs(preffix - suffix));
        }

        out.printLine(ans);
    }
}
