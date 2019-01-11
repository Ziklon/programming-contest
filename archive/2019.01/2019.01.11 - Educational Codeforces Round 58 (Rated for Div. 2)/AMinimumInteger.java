package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AMinimumInteger {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int q = in.readInt();
    for (int i = 0; i < q; ++i) {

      int l = in.readInt(), r = in.readInt(), d = in.readInt();

      if (d < l) out.printLine(d);
      else {
        long b = (r + d ) / d;
        out.printLine(b * d);
      }
    }
  }
}
