package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import org.omg.CORBA.MARSHAL;

public class CWalkOnMultiplicationTable {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n = in.readLong();
        long ans = n * 5;
        for (long i = 1; i * i <= n; ++i) {
            if (n % i == 0) {
                long e = n / i;
                ans = Math.min(ans, i + e - 2);
            }
        }
        out.printLine(ans);

    }
}
