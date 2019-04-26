package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ATheKingsRace {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.readLong();
    long x = in.readLong(), y = in.readLong();

    long mini1 = Math.max(x - 1, y - 1);
    long mini2 = Math.max(n - x, n - y);

    if (mini1 <= mini2) out.printLine("White");
    else out.printLine("Black");
  }
}
