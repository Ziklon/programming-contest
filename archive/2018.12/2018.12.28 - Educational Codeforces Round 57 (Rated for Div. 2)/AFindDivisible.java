package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AFindDivisible {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int x = 0; x < t; ++x) {
      long a = in.readInt(), b = in.readInt();
      out.printLine(a, a * 2);
    }
  }
}
