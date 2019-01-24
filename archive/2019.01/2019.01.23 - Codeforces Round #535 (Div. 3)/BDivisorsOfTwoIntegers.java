package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class BDivisorsOfTwoIntegers {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = new int[n];
    for (int i = 0; i < n; ++i) seq[i] = in.readInt();

    ArrayUtils.sort(seq);

    int ans1 = seq[n - 1];
    boolean seen[] = new boolean[n];
    for (int i = 1; i < n; ++i)
      if (ans1 % seq[i] == 0 && seq[i] != seq[i - 1]) {
        seen[i] = true;
      }
    int ans2 = 0;

    for (int a = n - 1; a >= 0; a--) {
      if (seen[a]) continue;
      ans2 = seq[a];
      break;
    }
    out.printLine(ans1, ans2);
  }
}
