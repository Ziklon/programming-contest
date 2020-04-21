package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class CSweetsEating {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt(), m = in.readInt();
        int[] s = ArrayUtils.sort(in.readIntArray(n));

        long[] sum = new long[n];
        long accum = 0;
        for (int i = 0; i < n; ++i) sum[i] = s[i];

        long[] ans = new long[n];
        for (int i = 0; i < n; ++i) {
            if (i >= m) sum[i] += sum[i - m];
            accum += sum[i];
            ans[i] = accum;
        }
        out.printLine(ans);
    }
}
