package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CAnnoyingPresent {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    long n = in.readInt(), m = in.readInt();



    long sum = 0;

    long odd = (n >> 1) * ((n + 1) >> 1);
    long even = ((n - 1) * n) >> 1;

    for (int i = 0; i < m; ++i) {
      long x = in.readInt(), d = in.readInt();

      if (d > 0) sum += even * d;
      else sum += odd * d;
      sum += n * x;
    }
    out.printLine(sum / (n * 1.0));
  }
}
