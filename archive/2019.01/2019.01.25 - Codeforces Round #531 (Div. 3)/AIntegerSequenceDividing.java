package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AIntegerSequenceDividing {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.readLong();
    long m = (n * (n + 1)) >> 1;
    long q = m >> 1;
    out.printLine( m- q * 2);
  }
}
