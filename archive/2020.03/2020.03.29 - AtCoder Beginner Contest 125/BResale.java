package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BResale {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] c = in.readIntArray(n);
        int[] p = in.readIntArray(n);

        int ans = 0;
        for (int mask = 0; mask < (1 << n); ++mask) {
            int x = 0;
            int y = 0;
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) > 0) {
                    x += c[i];
                    y += p[i];
                }
            }
            ans = Math.max(ans, x - y);
        }
        out.printLine(ans);
    }
}
