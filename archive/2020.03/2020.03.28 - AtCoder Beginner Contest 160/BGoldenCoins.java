package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BGoldenCoins {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long x = in.readInt();

        long ans = x / 500 * 1000;

        x = x % 500;

        ans += x / 5 * 5;
        out.printLine(ans);
    }
}
