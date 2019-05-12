package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class CBalancedTeam {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    seq = ArrayUtils.radixSort(seq);

    int ans = 0;
    int low = 0;
    for (int i = 0; i < n; ++i) {

      while (seq[i] - seq[low] > 5) low++;
      ans = Math.max(ans, i - low + 1);
    }

    out.printLine(ans);
  }
}
