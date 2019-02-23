package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class BTeamsForming {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    seq = ArrayUtils.radixSort(seq);

    long ans = 0;
    for (int t = 0; t < n; t += 2) {
      ans += seq[t + 1] - seq[t];
    }

    out.printLine(ans);
  }
}
