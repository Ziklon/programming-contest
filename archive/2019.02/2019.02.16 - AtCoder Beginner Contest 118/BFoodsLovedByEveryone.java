package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BFoodsLovedByEveryone {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt(), m = in.readInt();
    int[] counter = new int[m + 1];
    for (int i = 0; i < n; ++i) {
      int ni = in.readInt();
      for (int j = 0; j < ni; ++j) counter[in.readInt()]++;
    }

    int ans = 0;
    for (int i = 0; i <= m; ++i) if (counter[i] == n) ans++;
    out.printLine(ans);
  }
}
