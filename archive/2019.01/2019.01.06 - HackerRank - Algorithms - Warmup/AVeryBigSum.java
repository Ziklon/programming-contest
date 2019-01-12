package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AVeryBigSum {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    long ans = 0;
    for (int i = 0; i < n; ++i) ans += in.readLong();
    out.printLine(ans);
  }
}
