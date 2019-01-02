package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ARepeatingCipher {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    String s = in.readString();
    String ans = "";
    int inc = 1;
    for (int i = 0; i < n; ) {
      ans += s.substring(i, i + 1);
      i += inc;
      inc++;
    }

    out.printLine(ans);
  }
}
