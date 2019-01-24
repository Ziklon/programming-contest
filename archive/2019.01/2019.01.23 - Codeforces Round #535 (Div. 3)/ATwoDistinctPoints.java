package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ATwoDistinctPoints {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int q = in.readInt();
    for (int i = 0; i < q; ++i) {
      int l1 = in.readInt(), r1 = in.readInt(), l2 = in.readInt(), r2 = in.readInt();

      int a = l1;
      int b = l2;
      if (a == b && r2 - l2 > 0) b++;
      else if (a == b) a++;

      out.printLine(a, b);
    }
  }
}
