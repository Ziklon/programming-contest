package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CLower {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] seq = in.readIntArray(n);
        int ans = 0;
        int cnt = 0;
        for (int i = 1; i < n; ++i) {
            if (seq[i - 1] < seq[i]) {
                ans = Math.max(ans, cnt);
                cnt = 0;
            } else {
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        out.printLine(ans);
    }
}
