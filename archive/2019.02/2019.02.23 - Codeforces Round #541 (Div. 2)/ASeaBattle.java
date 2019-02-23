package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ASeaBattle {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long w1 = in.readInt(), h1 = in.readInt();
    long w2 = in.readInt(), h2 = in.readInt();

    long size = ((w1 + 2L) * (h1 + 2L)) - (w1 * (h1)) - (w2);

    long size2 = ((h2) * (w2 + 2)) - (w2 * (h2 - 1));

    out.printLine(size + size2);
  }
}
