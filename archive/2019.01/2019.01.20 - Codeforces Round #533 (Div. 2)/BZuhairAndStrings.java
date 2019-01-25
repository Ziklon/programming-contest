package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class BZuhairAndStrings {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt(), k = in.readInt();
    String s = in.readString();

    int ans = 0;

    for (char c = 'a'; c <= 'z'; ++c) {

      int level = 0;
      int cnt = 0;
      for (int i = 0; i < n; ++i) {

        if (s.charAt(i) == c) cnt++;
        else cnt = 0;
        if (cnt == k) {
          level++;
          cnt = 0;
        }
      }
      ans = Math.max(ans, level);
    }

    out.printLine(ans);
  }
}
