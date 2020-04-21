package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CSlimes {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        char[] s = in.readString().toCharArray();

        int ans = 0;
        char prev = '?';

        for (char c : s) {
            if (c == prev) continue;
            ans++;
            prev = c;
        }
        out.printLine(ans);
    }
}
