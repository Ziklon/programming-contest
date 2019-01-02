package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ANewYearAndTheChristmasOrnament {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int y = in.readInt(), b = in.readInt(), r = in.readInt();
    int ans = 0;

    for (int i = 0; i <= y; ++i) {
      if (i + 1 <= b && i + 2 <= r) {
        ans = Math.max(ans, i * 3 + 3);
      }
    }
    out.printLine(ans);
  }
}
