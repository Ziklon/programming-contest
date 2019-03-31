package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int ti = 0; ti < t; ++ti) {
      int n = in.readInt(), p = in.readInt();

      int[] seq = in.readIntArray(n);

      seq = ArrayUtils.radixSort(seq);

      long[] sum = new long[n + 1];
      for (int i = 0; i < n; ++i) sum[i + 1] = sum[i] + seq[i];

      long ans = Long.MAX_VALUE;

      for (int i = p - 1; i < n; ++i) {
        int at = seq[i];
        long totalSum = at * 1L * p;
        long curSum = sum[i + 1] - sum[i + 1 - p];

        ans = Math.min(ans, totalSum - curSum);
      }

      out.printLine(String.format("Case #%d: %d", ti + 1, ans));
    }
  }
}
