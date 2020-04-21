package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class CSongsCompression {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        long m = in.readInt();
        int[][] ab = in.readIntTable(n, 2);

        int[] diffs = new int[n];

        for (int i = 0; i < n; ++i)
            diffs[i] = ab[i][0] - ab[i][1];

        diffs = ArrayUtils.radixSort(diffs);

        for (int[] cur : ab) m -= cur[0];

        if (m >= 0) {
            out.printLine(0);
            return;
        }

        for (int i = n - 1; i >= 0; --i) {
            m += diffs[i];
            if (m >= 0) {
                out.printLine(n - i);
                return;
            }
        }
        out.printLine(-1);

    }
}
