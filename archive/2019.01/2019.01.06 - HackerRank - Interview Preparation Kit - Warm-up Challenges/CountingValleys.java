package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CountingValleys {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    String s = in.readString();
    int ans = 0, level = 0;
    for (int i = 0; i < n; ++i) {
      if (s.charAt(i) == 'U') {
        level++;
        if (level == 0) ans++;
      } else if (s.charAt(i) == 'D') level--;
    }

    out.printLine(ans);
  }
}
