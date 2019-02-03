package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class EKnapsack2 {
  final int MAXN = 100002;
  final long INF = 1L << 50;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), w = in.readInt();
    int[] weights = new int[n];
    int[] values = new int[n];
    for (int i = 0; i < n; ++i) {
      weights[i] = in.readInt();
      values[i] = in.readInt();
    }

    long dp[] = new long[MAXN];

    Arrays.fill(dp, INF);
    dp[0] = 0;

    for (int i = 0; i < n; ++i) {
      long best[] = new long[MAXN];
      Arrays.fill(best, INF);
      for (int j = 0; j < MAXN; ++j) {
        if (values[i] > j) best[j] = dp[j];
        else best[j] = Math.min(dp[j], dp[j - values[i]] + weights[i]);
      }
      dp = best;
    }
    int ans = 0;
    for (int i = 0; i < MAXN; ++i) if (dp[i] <= w) ans = i;
    out.printLine(ans);
  }
}
