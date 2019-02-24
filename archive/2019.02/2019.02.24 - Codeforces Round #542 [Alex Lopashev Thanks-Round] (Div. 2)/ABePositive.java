package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ABePositive {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    int[] seq = in.readIntArray(n);

    for (int d = -1000; d <= 1000; ++d) {
      if (d == 0) continue;
      int count = 0;
      for (int e : seq) {
        if ((double) e / d > 0) count++;
      }
      if (count * 2 >= n) {
        out.printLine(d);
        return;
      }
    }
    out.printLine(0);
  }
}
