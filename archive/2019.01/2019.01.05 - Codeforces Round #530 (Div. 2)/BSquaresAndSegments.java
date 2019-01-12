package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BSquaresAndSegments {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int ans = n + 1;
    int limit = (int) 1e+5;

    for (int i = 1; i < limit; ++i) {

      if (1L*i * i >= n) ans = Math.min(ans, i * 2);
      if (i * (i + 1L) >= n) ans = Math.min(ans, (i * 2) + 1 );
    }
    out.printLine(ans);
  }
}
