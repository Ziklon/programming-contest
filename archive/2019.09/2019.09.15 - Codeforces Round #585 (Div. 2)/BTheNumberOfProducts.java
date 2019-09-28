package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BTheNumberOfProducts {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] seq = in.readIntArray(n);
        int sign = 1;
        long pos = 1, neg = 0;
        long total = 1L * n * (n + 1) / 2;
        for (int e : seq) {
            if (e < 0) {
                sign *= -1;
            }
            if (sign == 1) pos++;
            else neg++;
        }
        out.printLine(neg * pos, total - (neg * pos));
    }
}
