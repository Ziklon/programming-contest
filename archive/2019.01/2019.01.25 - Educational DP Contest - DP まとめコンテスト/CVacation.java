package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.Arrays;

public class CVacation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[][] array = in.readIntTable(n, 3);
    int best[] = new int[3];

    for (int i = 0; i < n; ++i) {
      int[] dp = new int[3];
      for (int j = 0; j < 3; ++j)
        for (int k = 0; k < 3; ++k) {
          if (j == k) continue;
          dp[k] = Math.max(dp[k], best[j] + array[i][k]);
        }
      best = dp;
    }
    out.printLine(ArrayUtils.maxElement(best));
  }
}
