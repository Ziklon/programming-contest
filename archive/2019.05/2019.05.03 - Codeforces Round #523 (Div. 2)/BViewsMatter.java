package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class BViewsMatter {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt(), m = in.readInt();

    int[] seq = in.readIntArray(n);

    Arrays.sort(seq);

    long sum = 0;
    long maxi = 0;
    for (int e : seq) {
      sum += e;
      maxi = Math.max(maxi, e);
    }
    long select = 0;

    for (int e : seq) {
      if (e > select) select++;
    }

    long left = seq[n - 1] - select;
    long rem = sum - left - n;

    out.printLine(rem);
  }
}
