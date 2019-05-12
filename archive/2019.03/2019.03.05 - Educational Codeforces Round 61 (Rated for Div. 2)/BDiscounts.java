package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class BDiscounts {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    seq = ArrayUtils.radixSort(seq);
    int m = in.readInt();

    long[] prefix = new long[n + 1];
    for (int i = 0; i < n; ++i) prefix[i + 1] = prefix[i] + seq[i];
    for (int e : in.readIntArray(m)) {

      long cur = prefix[n - e];
      long ee = prefix[n] - prefix[n - e + 1];
      out.printLine(cur + ee);
    }
  }
}
