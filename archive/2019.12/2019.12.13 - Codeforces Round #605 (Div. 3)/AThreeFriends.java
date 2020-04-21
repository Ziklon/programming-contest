package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AThreeFriends {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int[] s = in.readIntArray(3);

        long ans = Long.MAX_VALUE;

        for (int i = -1; i < 2; ++i)
            for (int j = -1; j < 2; ++j)
                for (int k = -1; k < 2; ++k) {
                    int a = s[0] + i;
                    int b = s[1] + j;
                    int c = s[2] + k;
                    ans = Math.min(ans, Math.abs(a - b) + 0L + Math.abs(a - c) + Math.abs(b - c));
                }
        out.printLine(ans);
    }
}
