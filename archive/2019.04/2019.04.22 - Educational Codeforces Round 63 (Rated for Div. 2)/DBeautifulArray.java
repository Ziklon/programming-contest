package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class DBeautifulArray {

  long max(long[] item) {
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

      best[0] = max(new long[] {0L, y, dp[0] + y});
      best[1] = max(new long[] {0L, y * x, dp[1] + y * x, dp[0] + y * x});
      best[2] = max(new long[] {0L, y, dp[2] + y, dp[1] + y});
      ans = Math.max(ans, max(best));
      dp = best;
    }

    out.printLine(ans);
  }
}
