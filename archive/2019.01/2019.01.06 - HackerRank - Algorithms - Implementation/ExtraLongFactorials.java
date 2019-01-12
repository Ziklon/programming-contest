package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.math.BigInteger;

public class ExtraLongFactorials {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    BigInteger bi = BigInteger.ONE;
    for (int i = 2; i <= n; ++i) bi = bi.multiply(new BigInteger(i + ""));

    out.printLine(bi.toString());
  }
}
