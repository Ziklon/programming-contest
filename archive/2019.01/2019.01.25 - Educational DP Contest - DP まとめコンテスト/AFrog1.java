package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;
import java.util.Map;

public class AFrog1 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] array = in.readIntArray(n);

    int dp[] = new int[n + 1];
    Arrays.fill(dp, 1 << 30);
    dp[0] = 0;

    for (int i = 0; i < n; ++i) {
      if (i + 1 < n) dp[i + 1] = Math.min(dp[i + 1], dp[i] + Math.abs(array[i] - array[i + 1]));
      if (i + 2 < n) dp[i + 2] = Math.min(dp[i + 2], dp[i] + Math.abs(array[i] - array[i + 2]));
    }
    out.printLine(dp[n - 1]);
  }
}
