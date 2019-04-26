package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

public class CNekoDoesMaths {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long a = in.readLong(), b = in.readLong();

        long diff = Math.abs(a - b);
        long lcm = IntegerUtils.lcm(a, b);

        if (a == b) {
            out.printLine(0);
            return;
        }


        long ans = 0;
        for (int i = 1; i * i <= diff; ++i) {

            if (diff % i == 0) {
                long k1 = (b % diff) - i;
                long k2 = (b % diff) - (diff / i);

                for (long k : new long[]{k1, k2}) {
                    if (k > 0) continue;
                    k = Math.abs(k);

                    if (IntegerUtils.lcm(a + k, b + k) < lcm) {
                        lcm = IntegerUtils.lcm(a + k, b + k);
                        ans = k;
                    }
                }
            }
        }

        out.printLine(ans);

    }
}
