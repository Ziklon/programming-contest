package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class ASnowball {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int w = in.readInt(), h = in.readInt();

    int u1 = in.readInt(), h1 = in.readInt();
    int u2 = in.readInt(), h2 = in.readInt();

    for (int i = h; i > 0 ;  --i) {
      w += i;
      if (i == h1) {
        w -= u1;
      } else if (i == h2) {
        w -= u2;
      }
      if(w < 0 )w= 0;
    }
    out.printLine(w);
  }
}
