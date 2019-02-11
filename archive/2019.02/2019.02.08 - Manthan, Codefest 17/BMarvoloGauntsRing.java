package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class BMarvoloGauntsRing {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), p = in.readInt(), q = in.readInt(), r = in.readInt();

    long[] seq = in.readLongArray(n);

    long[][] dp = new long[2][n + 1];
    ArrayUtils.fill(dp, Long.MIN_VALUE);

    dp[0][0] = p * seq[0];
    for (int i = 1; i < n; ++i) dp[0][i] = Math.max(p * seq[i], dp[0][i - 1]);

    dp[1][0] = dp[0][0] + q * seq[0];
    for (int i = 1; i < n; ++i) dp[1][i] = Math.max(q * seq[i] + dp[0][i], dp[1][i - 1]);

    long ans = dp[1][0] + r * seq[0];

    for (int i = 1; i < n; ++i) ans = Math.max(ans, r * seq[i] + dp[1][i]);

    out.printLine(ans);
  }
}
