package com.darkbit.problems;

import net.egork.io.InputReader;
import net.egork.io.OutputWriter;

public class PlusMinus {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int a = 0, b = 0, c = 0, d;
    for (int i = 0; i < n; ++i) {
      d = in.readInt();
      if (d > 0) a++;
      else if (d < 0) b++;
      else c++;
    }
    out.printLine(a*1.0/n);
    out.printLine(b*1.0/n);
    out.printLine(c*1.0/n);


  }
}
