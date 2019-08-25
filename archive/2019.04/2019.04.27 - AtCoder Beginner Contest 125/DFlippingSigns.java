package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.Arrays;

public class DFlippingSigns {

    long[][] dp;
    long[] a;


    long func(int idx, int taken) {
        if (idx >= a.length) return 0;
        if (idx + 1 == a.length) {

            return taken == 1 ? -a[idx] : a[idx];
        }

        if (dp[idx][taken] == -1) {

            long ans = 0;

            if (taken == 0) {
                ans = a[idx] + func(idx + 1, 0);
                ans = Math.max(ans, -a[idx] + func(idx + 1, 1));
            } else {
                ans = -a[idx] + func(idx + 1, 0);
                ans = Math.max(ans, a[idx] + func(idx + 1, 1));
            }
            dp[idx][taken] = ans;
        }
        return dp[idx][taken];
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        a = in.readLongArray(n);

        dp = new long[n][2];
        ArrayUtils.fill(dp, -1);
        out.printLine(func(0, 0));

    }
}
