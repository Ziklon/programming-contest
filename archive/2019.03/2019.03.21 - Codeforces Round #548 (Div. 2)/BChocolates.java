package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class BChocolates {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);

    int prev = Integer.MAX_VALUE;
    long ans = 0;

    for (int i = n - 1; i >= 0; --i) {
      if (prev == 1) break;
      if (seq[i] < prev) {
        ans += seq[i];
        prev = seq[i];
      } else {
        ans += prev - 1;
        prev--;
      }
    }

    out.printLine(ans);
  }
}
