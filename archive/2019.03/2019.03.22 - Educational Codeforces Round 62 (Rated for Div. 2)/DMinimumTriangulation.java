package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class DMinimumTriangulation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    long ans = 0;

    for (int i = 3; i <= n; ++i) {
      ans += (i) * (i - 1);
    }

    out.printLine(ans);
  }
}
