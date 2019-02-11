package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AIrreversibleOperation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    String s = in.readString();
    int blacks = 0;
    long ans = 0;
    for (char c : s.toCharArray()) {
      if (c == 'B') blacks++;
      else {
        ans += blacks;
      }
    }
    out.printLine(ans);
  }
}
