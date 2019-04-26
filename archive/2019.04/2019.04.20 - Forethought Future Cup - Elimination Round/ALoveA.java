package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ALoveA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    String s = in.readString();
    int cnt = 0;
    for (char c : s.toCharArray()) {
      if (c == 'a') cnt++;
    }

    int n = s.length();

    for (int i = 0; i < n; ++i) {

      int m = (n - i);
      if (cnt * 2 > m) {
        out.printLine(m);
        return;
      }
    }
  }
}
