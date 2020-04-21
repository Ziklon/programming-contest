package com.darkbit.problems;

import net.egork.collections.map.TreeCounter;
import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

public class PlusMultiply {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] s = in.readIntArray(n);
        TreeCounter<Integer> counter = new TreeCounter<>();

        for (int e : s) counter.add(e);

        long ans = counter.get(0) * (counter.get(0) - 1) / 2;

        for (int e : s) {

            if (e > 0 && e % 2 == 0) {
                int middle = e / 2;
                if (1L * middle * middle == e) {
                    long times = counter.get(middle);
                    ans += times * (times - 1) / 2;
                }

            }
        }
        out.printLine(ans);
    }
}
