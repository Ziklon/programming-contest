package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;
import net.egork.numbers.IntegerUtils;

public class DSwords {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] remainders = in.readIntArray(n);

        int max = ArrayUtils.maxElement(remainders);

        long sum = 0;
        long gcd = 0;

        for (int e : remainders) {
            int cur = max - e;
            sum += cur;
            gcd = IntegerUtils.gcd(gcd, cur);
        }
        out.printLine(sum / gcd, gcd);
    }
}
