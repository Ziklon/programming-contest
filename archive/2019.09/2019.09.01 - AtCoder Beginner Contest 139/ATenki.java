package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ATenki {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.readString();
        String t = in.readString();

        int ans = 0;
        for (int i = 0; i < s.length(); ++i) if (s.charAt(i) == t.charAt(i)) ans++;

        out.printLine(ans);
    }
}
