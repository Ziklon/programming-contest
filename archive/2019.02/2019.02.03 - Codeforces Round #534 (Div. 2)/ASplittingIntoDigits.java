package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ASplittingIntoDigits {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();

        for (int j = 9; j >= 1; --j) {
            if (n % j == 0) {
                int m = n / j;
                out.printLine(m);
                for (int i = 0; i < m; ++i) out.print(j + " ");
                return;
            }
        }
    }
}
