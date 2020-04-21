package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BObtainTwoZeroes {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long a = in.readInt(), b = in.readInt();
        out.printLine(check(a, b) ? "YES" : "NO");

    }

    boolean check(long a, long b) {
        if (a > b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        if ((a + b) % 3 == 0 && a * 2 >= b) return true;
        return false;
    }

}

