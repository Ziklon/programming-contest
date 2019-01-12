package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class NonDivisibleSubset {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt();
    int[] seq = new int[n];
    for (int i = 0; i < n; ++i) seq[i] = in.readInt() % k;

  }
}
