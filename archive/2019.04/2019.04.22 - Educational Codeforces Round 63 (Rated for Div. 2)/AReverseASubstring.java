package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AReverseASubstring {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.readInt();
    char[] s = in.readString().toCharArray();

    for (int i = 0; i + 1 < n; ++i) {
      if (s[i + 1] < s[i]) {
        out.printLine("YES");
        out.printLine(new int[] {i + 1, i + 2});
        return;
      }
    }
    out.printLine("NO");
  }
}
