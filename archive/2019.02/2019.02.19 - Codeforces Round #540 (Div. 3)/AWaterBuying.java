package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AWaterBuying {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int q = in.readInt();
    for (int i = 0; i < q; ++i) {
      long a = in.readLong(), b = in.readInt(), c = in.readInt();

      long ans = a * b;
      ans = Math.min(ans, ((a / 2) * c) + (a % 2 == 1 ? b : 0));

      out.printLine(ans);
    }
  }
}
