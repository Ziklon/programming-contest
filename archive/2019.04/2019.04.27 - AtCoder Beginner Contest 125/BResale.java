package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BResale {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.readInt();
        int[] v = in.readIntArray(n);
        int[] c = in.readIntArray(n);

        int ans = 0;
        for (int mask = 0; mask < (1 << n); ++mask) {


            int s1 = 0, s2 = 0;
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) > 0) {
                    s1 += v[i];
                    s2 += c[i];
                }
            }
            ans = Math.max(ans, s1 - s2);
        }
        out.printLine(ans);

    }
}
