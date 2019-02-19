package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CDoorsBreakingAndRepairing {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), x = in.readInt(), y = in.readInt();

    if (x > y) out.printLine(n);
    else {
      int ans = 0;
      for (int i = 0; i < n; ++i) {
        int e = in.readInt();
        if (e <= x) ans++;
      }
      out.printLine((ans + 1) >> 1);
    }
  }
}
