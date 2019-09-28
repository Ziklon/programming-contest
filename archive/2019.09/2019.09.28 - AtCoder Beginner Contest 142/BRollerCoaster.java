package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BRollerCoaster {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt(), k = in.readInt();
        int ans = 0;

        for (int e : in.readIntArray(n)) {
            if (e >= k) ans++;
        }
        out.printLine(ans);
    }
}
