package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.Arrays;

public class ADiverseStrings {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();

    for (int i = 0; i < n; ++i) {
      char[] s = in.readString().toCharArray();
      Arrays.sort(s);
      boolean ans = true;
      for (int j = 0; j + 1 < s.length; ++j) {
        if (s[j + 1] - s[j] != 1) ans = false;
      }
      out.printLine(ans ? "Yes" : "No");
    }
  }
}
