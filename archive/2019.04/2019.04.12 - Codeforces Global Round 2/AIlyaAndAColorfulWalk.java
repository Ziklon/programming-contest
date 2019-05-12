package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AIlyaAndAColorfulWalk {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);

    int ans = 0;
    for (int i = 0; i < n; ++i) if (seq[i] != seq[0]) ans = Math.max(ans, i);
    for (int i = 0; i < n; ++i) if (seq[i] != seq[n - 1]) ans = Math.max(ans, n - i - 1);
    out.printLine(ans);
  }
}
