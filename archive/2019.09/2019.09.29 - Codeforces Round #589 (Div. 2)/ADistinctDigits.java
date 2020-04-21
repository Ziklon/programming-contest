package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ADistinctDigits {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.readInt(), b = in.readInt();

        for (int i = a; i <= b; ++i) {
            if (isValid(i)) {
                out.printLine(i);
                return;
            }
        }
        out.printLine(-1);

    }

    boolean isValid(int e) {
        boolean[] seen = new boolean[10];
        while (e > 0) {

            if (seen[e % 10]) return false;
            seen[e % 10] = true;
            e /= 10;
        }
        return true;
    }
}
