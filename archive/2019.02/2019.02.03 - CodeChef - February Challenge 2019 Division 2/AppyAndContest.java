package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AppyAndContest {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int i = 0; i < t; ++i) {
      long n = in.readLong(), a = in.readLong(), b = in.readLong(), k = in.readLong();

      long sa = n / a, sb = n / b;
      long sc = n / (a * b);
      if (b > a) {
        long tmp = a;
        a = b;
        b = tmp;
      }
      long total = 0;
      if (a % b == 0) {
        sc = n / a;
      }
      total = sa + sb - (2 * sc);
      out.printLine(total >= k ? "Win" : "Lose");
    }
  }
}
