package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import sun.nio.cs.ext.MacArabic;

public class BDivTimesMod {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt();

    long x = Long.MAX_VALUE;
    for (int i = 1; i < k; ++i) {
      if (n % i == 0) {
        x = Math.min(x, n / i * k + i);
      }
    }

    out.printLine(x);
  }
}
