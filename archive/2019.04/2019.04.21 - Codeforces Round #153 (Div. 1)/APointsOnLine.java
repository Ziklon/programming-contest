package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class APointsOnLine {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), d = in.readInt();
    int[] seq = in.readIntArray(n);

    int j = 0;
    long ans = 0;
    for (int i = 0; i < n; ++i) {

      while (seq[i] - seq[j] > d) j++;
      long dist = i - j;
      ans += (dist * (dist - 1)) / 2;
    }
    out.printLine(ans);
  }
}
