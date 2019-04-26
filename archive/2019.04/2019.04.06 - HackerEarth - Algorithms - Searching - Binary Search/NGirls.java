package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

import java.util.Arrays;

public class NGirls {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt(), p = in.readInt(), q = in.readInt();
    long[] seq = in.readLongArray(n);

    Arrays.sort(seq);

    int cnt = 0;
    int i = 0, j = 0;

    for (; j < n && i < n; ) {
      if (seq[j] * p < seq[i] * q) j++;
      else i++;
      cnt = Math.max(cnt, Math.abs(j - i));
    }

    out.printLine(Math.min(n, cnt + k));
  }
}
