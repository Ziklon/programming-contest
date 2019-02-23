package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class TheTrickyDeal {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();

    for (int i = 0; i < t; ++i) {
      int a = in.readInt();

      int a1 = 0, a2 = 0;
      long diff = 0;
      for (int d = 1; d < 50; ++d) {

        long s1 = (1L << (d)) - 1;
        long s2 = d * 1L * a;
        if (s2 <= s1) {
          break;
        }
        a1 = d;
        if (s2 - s1 > diff) {
          diff = s2 - s1;
          a2 = d;
        }
      }
      out.printLine(a1, a2);
    }
  }
}
