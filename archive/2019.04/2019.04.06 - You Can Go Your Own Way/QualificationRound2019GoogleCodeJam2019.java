package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class QualificationRound2019GoogleCodeJam2019 {

  char inv(char c) {
    if (c == 'S') return 'E';
    return 'S';
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    String s = in.readString();

    char[] ans = new char[s.length()];

    for (int i = 0; i < s.length(); ++i) ans[i] = inv(s.charAt(i));

    out.printLine(String.format("Case #%d: %s", testNumber, new String(ans)));
  }
}
