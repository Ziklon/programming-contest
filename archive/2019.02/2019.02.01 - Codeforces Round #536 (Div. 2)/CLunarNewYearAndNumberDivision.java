package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class CLunarNewYearAndNumberDivision {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    ArrayUtils.sort(seq);

    long ans = 0;

    for (int i = 0; i * 2 < n; ++i) {
      ans += (seq[i] + seq[n - i - 1]) * (seq[i] + seq[n - i - 1]);
    }

    out.printLine(ans);
  }
}
