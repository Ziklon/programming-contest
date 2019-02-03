package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ADigitsSequenceDividing {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int q = in.readInt();

    for (int i = 0; i < q; ++i) {
      int n = in.readInt();
      String s = in.readString();
      if (s.length() == 2 && s.charAt(1) <= s.charAt(0)) out.printLine("NO");
      else {
        out.printLine("YES");
        out.printLine(2);
        out.printLine(s.substring(0, 1), s.substring(1));
      }
    }
  }
}
