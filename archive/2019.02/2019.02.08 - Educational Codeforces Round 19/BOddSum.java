package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.Arrays;

public class BOddSum {

  int INF = 1 << 25;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    int[] dp = new int[2];
    dp[1] = -INF;
    for (int i = 0; i < n; ++i) {
      int[] next = new int[2];
      next[0] = Math.max(dp[0], dp[seq[i] & 1] + seq[i]);
      next[1] = Math.max(dp[1], dp[~seq[i] & 1] + seq[i]);
      dp = next;
    }
    out.printLine(dp[1]);
  }
}
