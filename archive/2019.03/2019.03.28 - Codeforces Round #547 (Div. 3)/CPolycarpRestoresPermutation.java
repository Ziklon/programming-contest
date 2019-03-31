package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class CPolycarpRestoresPermutation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    long[] q = in.readLongArray(n - 1);

    long sum = 0;
    long min_val = 0;
    for (long e : q) {
      sum += e;
      if (sum < min_val) min_val = sum;
    }
    long[] p = new long[n];
    p[0] = 1 - min_val;
    for (int i = 0; i + 1 < n; ++i) p[i + 1] = p[i] + q[i];

    Set<Long> S = new HashSet<>();
    for (long e : p) S.add(e);

    for (long e = 1; e <= n; ++e) {
      if (!S.contains(e)) {
        out.printLine(-1);
        return;
      }
    }
    out.printLine(p);
  }
}
