package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ABA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.readInt(), b = in.readInt();
    if (b % a == 0) out.printLine(a + b);
    else out.printLine(b - a);
  }
}
