package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class DBeautifulArray {
  long max(long... item) {
    long ans = 0;
    for (long e : item) ans = Math.max(ans, e);
    return ans;
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), x = in.readInt();

    long[] dp = new long[3];
    long ans = 0;
    for (int i = 0; i < n; ++i) {
      long y = in.readLong();
      long[] best = new long[3];
      best[0] = max(y, dp[0]);
      best[1] = y * x + max(0, dp[1], dp[0]);
      best[2] = y + max(dp[2], dp[1]);

      for (int j = 0; j < 3; ++j) {
        best[j] = Math.max(best[j], 0L);
        ans = Math.max(ans, best[j]);
      }
      dp = best;
    }
    out.printLine(ans);
  }
}
