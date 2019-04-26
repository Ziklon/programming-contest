package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AServalAndBus {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), t = in.readInt();

    int best = -1, cost = 1 << 30;

    for (int i = 0; i < n; ++i) {

      int s = in.readInt();
      int d = in.readInt();

      int next = 0;

      if (t <= s) next = s;
      else {
        // [si , si+d1 , se+2di, ..., s+10d]
        next = (t - s + d - 1) / d * d + s;
      }
      if (next - t < cost) {
        cost = next - t;
        best = i + 1;
      }
    }

    out.printLine(best);
  }
}
