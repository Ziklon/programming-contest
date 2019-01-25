package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class BFrog2 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt();
    int[] array = in.readIntArray(n);

    int dp[] = new int[n + 1];
    Arrays.fill(dp, 1 << 30);
    dp[0] = 0;

    for (int i = 0; i < n; ++i) {

      for (int j = 1; j <= k; ++j) {
          if (i + j < n) dp[i + j] = Math.min(dp[i + j], dp[i] + Math.abs(array[i] - array[i + j]));
      }
    }
    out.printLine(dp[n - 1]);
  }
}
