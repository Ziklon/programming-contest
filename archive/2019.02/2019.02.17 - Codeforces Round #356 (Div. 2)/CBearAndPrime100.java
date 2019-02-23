package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;
import net.egork.numbers.IntegerUtils;

public class CBearAndPrime100 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] primes = IntegerUtils.generatePrimes(100);

    int countYes = 0;
    int extra = 0;
    for (int i = 0; i < 20 - extra; ++i) {
      out.printLine(primes[i]);
      out.flush();
      if ("yes".equals(in.readString())) {
        countYes++;
        if (primes[i] * primes[i] <= 100) {
          out.printLine(primes[i] * primes[i]);
          extra++;
          out.flush();
          if ("yes".equals(in.readString())) countYes++;
        }
      }
    }
    out.printLine(countYes >= 2 ? "composite" : "prime");
  }
}
