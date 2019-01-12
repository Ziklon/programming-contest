package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class DiagonalDifference {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] m = new int[n];
    int ans = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) m[j] = in.readInt();
      ans += m[i] - m[n - i - 1];
    }

    out.printLine(Math.abs(ans));
  }
}
