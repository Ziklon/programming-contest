package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class NewYearChaos {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int u = 0; u < t; ++u) {
      int n = in.readInt();
      int seq[] = new int[n];
      for (int i = 0; i < n; ++i) seq[i] = in.readInt();

      int ans = 0;
      boolean isThereSol = true;
      for (int i = 0; i < n; ++i)
        if (Math.abs(seq[i] - 1 - i) > 2) {
          isThereSol = false;
        }

      if (!isThereSol) {
        out.printLine("Too chaotic");
      } else {
        out.printLine(3);
      }
    }
  }
}
