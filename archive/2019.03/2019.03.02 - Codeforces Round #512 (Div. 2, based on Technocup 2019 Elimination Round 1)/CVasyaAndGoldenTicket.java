package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class CVasyaAndGoldenTicket {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    String s = in.readString();

    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) if (c != '0') sb.append(c);

    s = sb.toString();
    n = s.length();

    if (n == 0) {
      out.printLine("YES");
      return;
    }

    int prefixSum = 0;
    for (int i = 0; i + 1 < n; ++i) {
      prefixSum += s.charAt(i) - '0';

      int curSum = 0;
      for (int j = i + 1; j < n; ++j) {
        curSum += s.charAt(j) - '0';
        if (curSum == prefixSum) {
          curSum = 0;
        }
      }
      if (curSum == 0) {
        out.printLine("YES");
        return;
      }
    }
    out.printLine("NO");
  }
}
