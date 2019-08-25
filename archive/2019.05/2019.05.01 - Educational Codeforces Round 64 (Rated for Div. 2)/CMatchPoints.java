package com.darkbit.problems;

import net.egork.collections.map.TreeCounter;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;


public class CMatchPoints {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt(), m = in.readInt();

        int[] seq = ArrayUtils.sort(in.readIntArray(n));

        int ans = 0;
        int low = 0, hih = n >> 1;

        while (low <= hih) {
            int middle = (low + hih) >> 1;

            boolean ok = true;

            for (int i = 0; i < middle; ++i) {
                ok &= seq[n - middle + i] - seq[i] >= m;
            }
            if (ok) low = middle + 1;
            else hih = middle - 1;
        }

        out.printLine(low - 1);

    }
}
