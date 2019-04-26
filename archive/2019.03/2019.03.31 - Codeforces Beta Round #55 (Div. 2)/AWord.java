package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AWord {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.readString();

    int a = 0, b = 0;
    for (char c : s.toCharArray())
      if (c >= 'a' && c <= 'z') a++;
      else b++;

    if (a >= b) out.printLine(s.toLowerCase());
    else out.printLine(s.toUpperCase());
  }
}
