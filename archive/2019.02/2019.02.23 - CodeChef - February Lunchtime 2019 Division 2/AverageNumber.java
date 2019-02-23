package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.misc.ArrayUtils;

public class AverageNumber {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int t = in.readInt();

    for (int i = 0; i < t; ++i) {
      int n = in.readInt(), k = in.readInt(), v = in.readInt();
      int seq[] = in.readIntArray(n);

      long sum = ArrayUtils.sumArray(seq);

      long low = 1, hih = 1L << 40;

      while (hih - low > 1) {
        long middle = (low + hih) >> 1;
        double func = ((sum) + (middle * k)) / (n + k + 0.0);
        if (func <= v) {
          low = middle;
        } else hih = middle;
      }
      long remain = ((sum) + (low * k)) % (n + k);
      if (remain == 0) {
        out.printLine(low);
      } else out.printLine(-1);
    }
  }
}
