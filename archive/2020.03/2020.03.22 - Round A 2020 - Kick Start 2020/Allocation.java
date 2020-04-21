package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class Allocation {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt(), b = in.readInt();
        int[] m = ArrayUtils.radixSort(in.readIntArray(n));

        int ans = 0;

        for (int e : m) {
            if (e <= b) {
                b -= e;
                ans++;
            }
        }
        out.printLine(String.format("Case #%d: %d", testNumber, ans));
    }
}
