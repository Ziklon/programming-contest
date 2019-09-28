package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class BBadPrices {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] seq = in.readIntArray(n);

        int[] best = new int[n + 1];

        Arrays.fill(best, 1 << 20);
        for (int i = n - 1; i >= 0; --i) {
            best[i] = Math.min(best[i + 1], seq[i]);
        }
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            if (best[i] < seq[i]) ans++;
        }
        out.printLine(ans);

    }
}
