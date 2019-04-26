package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BServalAndToyBricks {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt(), h = in.readInt();
    int[] a = in.readIntArray(m);
    int[] b = in.readIntArray(n);

    int[][] top = in.readIntTable(n, m);
    int[][] ans = new int[n][m];

    for (int i = 0; i < n; ++i)
      for (int j = 0; j < m; ++j) {
        if (top[i][j] == 0) continue;
        ans[i][j] = Math.min(b[i], a[j]);
      }

    for (int[] item : ans) out.printLine(item);
  }
}
