package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AManyEqualSubstrings {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt();
    String s = in.readString();
    int prefix = 0;
    for (int i = 1; i < s.length(); ++i) {
      String tmp = s.substring(0, i);
      if (s.endsWith(tmp)) {
        prefix  = i;
      }
    }
    int idx = s.length() - prefix;
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < k; ++i) {
        sb.append(s.substring(0,idx));
    }
    sb.append(s);
    out.printLine(sb.toString());
  }
}
