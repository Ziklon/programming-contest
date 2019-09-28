package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class BShooting {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[][] cans = new int[n][];
        for (int i = 0; i < n; ++i) cans[i] = new int[]{in.readInt(), i};

        Arrays.sort(cans, (p, q) -> q[0] - p[0]);

        long cost = 0;
        for (int i = 0; i < n; ++i) {
            cost += (cans[i][0] * i) + 1;
        }
        out.printLine(cost);
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) ans[i] = cans[i][1] + 1;
        out.printLine(ans);

    }
}
