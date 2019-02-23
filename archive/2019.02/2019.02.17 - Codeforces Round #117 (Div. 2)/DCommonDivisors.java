package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class DCommonDivisors {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.readString(), t = in.readString();

    int ans = 0;
    for (int size = 1; size <= s.length(); ++size) {
      if (s.length() % size == 0 && t.length() % size == 0) {
        if (checkPrefix(s, s, size) && checkPrefix(t, s, size)) {
          ans++;
        }
      }
    }
    out.printLine(ans);
  }

  private boolean checkPrefix(String s, String t, int size) {
    int idx = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) != t.charAt(idx)) return false;
      idx = (idx + 1) % size;
    }
    return true;
  }
}
