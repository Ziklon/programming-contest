package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class BArrayStabilization {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int seq[] = new int[n];
    for (int i = 0; i < n; ++i) seq[i] = in.readInt();
    ArrayUtils.sort(seq);
    int ans = Math.min(seq[n - 2] - seq[0], seq[n - 1] - seq[1]);
    out.printLine(ans);
  }
}
