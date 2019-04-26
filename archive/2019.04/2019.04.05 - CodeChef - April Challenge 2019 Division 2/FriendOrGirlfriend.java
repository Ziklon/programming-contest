package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

import java.util.TreeSet;

public class FriendOrGirlfriend {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int t = in.readInt();
    for (int a = 0; a < t; ++a) {
      int n = in.readInt();
      String s = in.readString();
      char x = in.readCharacter();
      long ans = (n * (n + 1L) / 2);
      long cnt = 0;
      for (int i = 0; i < n; ++i) {
        if (s.charAt(i) == x) {
          ans -= (cnt * (cnt + 1) / 2);
          cnt = 0;
        } else cnt++;
      }
      ans -= (cnt * (cnt + 1) / 2);
      out.printLine(ans);
    }
  }
}
