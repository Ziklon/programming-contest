package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

public class AModularExponentiation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), m = in.readInt();

    if (n >= 30) {
      out.printLine(m);
    } else {
      out.printLine(m % IntegerUtils.power(2, n));
    }
  }
}
