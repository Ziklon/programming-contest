package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BuyingNewTablet {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();

    for (int i = 0; i < t; ++i) {
      int n = in.readInt(), p = in.readInt();
      int ans = -1;
      for (int j = 0; j < n; ++j) {
        int x = in.readInt(), y = in.readInt(), pi = in.readInt();
        if (pi <= p) ans = Math.max(ans, x * y);
      }
      out.printLine(ans == -1 ? "no tablet" : ans);
    }
  }
}
