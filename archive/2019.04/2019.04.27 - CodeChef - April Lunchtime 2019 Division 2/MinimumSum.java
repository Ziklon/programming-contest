package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class MinimumSum {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] counter = new int[30];
        for (int e : in.readIntArray(n)) {

            for (int i = 0; i < counter.length; ++i)
                if ((e & (1 << i)) > 0) counter[i]++;
        }

        long sum = 0;
        for (int i = 0; i < counter.length; ++i)
            sum += (1L << i) * Math.min(counter[i], n - counter[i]);
        out.printLine(sum);
    }
}
