package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AEvenSubstrings {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long ans = 0;
    int n = in.readInt();
    String s = in.readString();
    for (int i = 0; i < s.length(); ++i) {
      int d = s.charAt(i) - '0';
      if (d % 2 == 0) {
        ans += (i + 1);
      }
    }
    out.printLine(ans);
  }
}
