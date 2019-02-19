package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ChefAndMagicalJars {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int k = 0; k < t; ++k) {
      int n = in.readInt();
      int ans = Integer.MIN_VALUE;

      long sum = 0;
      int[] seq = in.readIntArray(n);
      for (int i = 0; i < n; ++i) {
        sum += seq[i] - 1;
      }
      out.printLine(sum + 1);
    }
  }
}
