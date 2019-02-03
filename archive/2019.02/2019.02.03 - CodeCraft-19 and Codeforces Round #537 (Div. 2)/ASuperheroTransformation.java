package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ASuperheroTransformation {

  boolean isVowerl(char c) {
    return "aeiou".contains(c + "");
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.readString();
    String t = in.readString();

    if (t.length() != s.length()) {
      out.printLine("No");
      return;
    }
    for (int i = 0; i < s.length(); ++i) {
      if (isVowerl(s.charAt(i)) ^ isVowerl(t.charAt(i))) {
        out.printLine("No");
        return;
      }
    }
    out.printLine("Yes");
  }
}
