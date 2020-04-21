package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class B81 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();

        for (int i = 1; i * i <= n; ++i) {
            int a = i;
            int b = n / i;
            if (a * b == n && Math.max(a, b) <= 9) {
                out.printLine("Yes");
                return;
            }
        }
        out.printLine("No");


    }
}
