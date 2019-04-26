package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class MaximumRemaining {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int[] seq = in.readIntArray(n);
    seq = ArrayUtils.radixSort(seq);

    int prev = n - 1;
    while (prev >= 0 && seq[prev] == seq[n - 1]) prev--;
    if (prev < 0) prev = n - 1;

    out.printLine(seq[prev] % seq[n - 1]);
  }
}
