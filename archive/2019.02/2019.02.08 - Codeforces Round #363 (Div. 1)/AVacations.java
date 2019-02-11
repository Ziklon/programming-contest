package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.Arrays;

public class AVacations {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);

    int[] dp = new int[] {1, 0, 0};

    for (int i = 0; i < n; ++i) {

      int[] next = new int[3];
      Arrays.fill(next, 1 << 20);
      next[0] = 1 + Math.min(dp[0], Math.min(dp[1], dp[2]));
      if (seq[i] == 1 | seq[i] == 3) next[1] = Math.min(dp[0], dp[2]);
      if (seq[i] == 2 | seq[i] == 3) next[2] = Math.min(dp[0], dp[1]);
      dp = next;
    }
    out.printLine(Math.min(dp[0], Math.min(dp[1], dp[2])));
  }
}
