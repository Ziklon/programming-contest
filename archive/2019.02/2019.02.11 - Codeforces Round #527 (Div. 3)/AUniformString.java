package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AUniformString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int i = 0; i < t; ++i) {
      int n = in.readInt(), k = in.readInt();

      int cur = 0;
      for (int j = 0; j < n; ++j) {
        out.print((char)('a' + cur));
        cur = (cur + 1) % k;
      }
      out.printLine();
    }
  }
}
