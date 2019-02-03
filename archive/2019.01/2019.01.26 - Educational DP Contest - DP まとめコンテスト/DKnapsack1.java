package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.Arrays;

public class DKnapsack1 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), w = in.readInt();
    int[] weights = new int[n];
    int[] values = new int[n];
    for (int i = 0; i < n; ++i) {
      weights[i] = in.readInt();
      values[i] = in.readInt();
    }
    long dp[] = new long[w + 1];

    for (int i = 0; i < n; ++i) {
      long[] best = new long[w + 1];
      for (int j = 0; j <= w; ++j) {
        if (weights[i] > j) best[j] = dp[j];
        else best[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
      }
      dp = best;
    }
    out.printLine(dp[w]);
  }
}
