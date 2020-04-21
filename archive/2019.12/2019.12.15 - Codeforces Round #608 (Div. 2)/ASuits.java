package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import sun.nio.cs.ext.MacArabic;

public class ASuits {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.readInt();
        int b = in.readInt();
        int c = in.readInt();
        int d = in.readInt();
        int e = in.readInt();
        int f = in.readInt();

        long ans = 0;

        for (int i = 0; i <= 100_000; ++i) {
            if (Math.min(a, d) >= i) {
                long c1 = i * e;
                long c2 = f * Math.min(b, Math.min(c, d - i));
                ans = Math.max(ans, c1 + c2);
            }
        }
        out.printLine(ans);
    }
}
