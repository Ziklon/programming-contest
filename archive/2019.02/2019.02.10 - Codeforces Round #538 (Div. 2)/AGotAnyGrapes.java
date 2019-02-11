package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class AGotAnyGrapes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = in.readInt(), y = in.readInt(), z = in.readInt();
    int green = in.readInt(), purple = in.readInt(), black = in.readInt();

    if (green < x) {
      out.printLine("NO");
      return;
    }
    green -= x;

    if (green + purple < y) {
      out.printLine("NO");
      return;
    }
    if (green + purple - y + black < z) {
      out.printLine("NO");
      return;
    }
    out.printLine("YES");
  }
}
