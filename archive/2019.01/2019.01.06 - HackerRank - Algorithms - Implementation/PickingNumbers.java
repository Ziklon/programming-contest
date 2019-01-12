package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class PickingNumbers {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] m = new int[110];
    for (int i = 0; i < n; ++i) m[in.readInt()]++;

    int ans = 0;
    for (int i = 1; i + 1 < m.length; ++i) ans = Math.max(ans, m[i] + m[i + 1]);
    out.printLine(ans);
  }
}
