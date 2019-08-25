package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class FastFood {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] a = in.readIntArray(n);
        int[] b = in.readIntArray(n);

        long suma[] = new long[n + 1];
        long sumb[] = new long[n + 1];
        for (int i = 0; i < n; ++i) suma[i + 1] = suma[i] + a[i];
        for (int i = n - 1; i >= 0; --i) sumb[i] = sumb[i + 1] + b[i];
        long profit = Math.max(suma[n], sumb[0]);

        for (int i = 0; i < n; ++i) {
            profit = Math.max(profit, suma[i] + sumb[i]);
        }
        out.printLine(profit);

    }
}
