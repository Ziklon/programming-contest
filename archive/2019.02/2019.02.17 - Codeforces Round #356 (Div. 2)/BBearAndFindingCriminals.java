package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BBearAndFindingCriminals {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), x = in.readInt() - 1;
    int[] seq = in.readIntArray(n);

    int ans = seq[x];

    for (int i = 1; i <= n; ++i) {
      int left = x - i;
      int right = x + i;
      if (left < 0 && right >= n) continue;

      int opts = 0;
      int units = 0;
      if (left >= 0) {
        opts++;
        units += seq[left];
      }
      if (right < n) {
        opts++;
        units += seq[right];
      }
      if (units == opts) ans += units;
    }

    out.printLine(ans);
  }
}
