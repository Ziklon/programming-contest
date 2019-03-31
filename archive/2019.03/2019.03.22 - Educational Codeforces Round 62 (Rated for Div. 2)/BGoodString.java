package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Map;

public class BGoodString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int i = 0; i < t; ++i) {
      int n = in.readInt();
      String s = in.readString();
      int a = 0, b = 0;

      for (int j = 0; j < n; ++j) {
        if (s.charAt(j) == '<') a++;
        else break;
      }
      for (int j = 0; j < n; ++j) {
        if (s.charAt(n - j - 1) == '>') b++;
        else break;
      }

      out.printLine(Math.min(a, b));
    }
  }
}
